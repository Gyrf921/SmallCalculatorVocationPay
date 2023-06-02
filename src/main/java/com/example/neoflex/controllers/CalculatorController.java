package com.example.neoflex.controllers;

import com.example.neoflex.model.dto.CalculationResponse;
import com.example.neoflex.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculatorController {

    @Autowired
    CalculationService calculationService;

    @GetMapping("/calculate")
    public CalculationResponse calculateVacationPay(@RequestParam(value = "salary") BigDecimal salary,
                                                    @RequestParam(value = "startDate" ) String startDateParam,
                                                    @RequestParam(value = "endDate") String endDateParam) {

        CalculationResponse calculationResponse = new CalculationResponse();

        calculationResponse.setCalculationResult(calculationService.calculationVocationPayWithHolidays(salary, startDateParam, endDateParam));

        return calculationResponse;
    }

}
