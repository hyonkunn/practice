package com.example.bbb;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final String EXISTING_ID = "apple";

    public String checkId(String id) {
        if (EXISTING_ID.equals(id)) {
            return "このIDはすでに使用されています。";
        } else {
            return "このIDは使用可能です。";
        }
    }
}
