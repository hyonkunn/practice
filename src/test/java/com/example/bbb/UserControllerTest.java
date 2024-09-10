package com.example.bbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCheckIdExists() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/checkId")
                        .param("id", "apple"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("このIDはすでに使用されています。"));
    }

    @Test
    public void testCheckIdAvailable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/checkId")
                        .param("id", "banana"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("このIDは使用可能です。"));
    }
}
