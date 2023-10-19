package com.example.neoflex.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class VocationPayCalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculateVacationPay() throws Exception {

        this.mockMvc
                .perform(post("/vacation/pay/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"salary\": 30000,\n" +
                                "  \"vacationStartDate\": \"2023-10-19\",\n" +
                                "  \"vacationEndDate\": \"2023-11-19\"\n" +
                                "}"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.calculationResult").value(22000));
    }

    @Test
    void calculateVacationPay_VacationPayException() throws Exception {

        this.mockMvc
                .perform(post("/vacation/pay/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"salary\": 30000,\n" +
                                "  \"vacationStartDate\": \"2023-11-19\",\n" +
                                "  \"vacationEndDate\": \"2023-10-19\"\n" +
                                "}"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void calculateVacationPay_Exception() throws Exception {

        this.mockMvc
                .perform(post("/vacation/pay/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"salary\": 30000\n" +
                                "}"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is5xxServerError());
    }

}