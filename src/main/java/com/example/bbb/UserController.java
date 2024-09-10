package com.example.bbb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class UserController {

    private static final String EXISTING_ID = "apple";

    @GetMapping("/checkId")
    public String checkId(@RequestParam("id") String id) {
        if (EXISTING_ID.equals(id)) {
            return "このIDはすでに使用されています。";
        } else {
            return "このIDは使用可能です。";
        }
    }

    @GetMapping("/calculateAge")
    public AgeResponse calculateAge(@RequestParam("birthday") String birthday) {
        LocalDate birthDate = LocalDate.parse(birthday);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();

        return new AgeResponse(age);
    }

    public static class AgeResponse {
        private int age;

        public AgeResponse(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
