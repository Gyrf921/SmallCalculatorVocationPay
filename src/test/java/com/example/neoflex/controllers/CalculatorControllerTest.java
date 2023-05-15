package com.example.neoflex.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc //simulating a http request without a server
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculateVacationPay() throws Exception {
        this.mockMvc
                .perform(get("/calculate?salary=30000&countDays=15"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("calculationResult")
                        .value("15000"));

    }
}