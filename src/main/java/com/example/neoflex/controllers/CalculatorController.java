package com.example.neoflex.controllers;

import com.example.neoflex.model.dto.CalculationResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
public class CalculatorController {

    @GetMapping("/calculate")
    public CalculationResponse calculateVacationPay(@RequestParam(value = "salary") BigDecimal salary,
                                                    @RequestParam(value = "countDays") Integer countDays) {

        BigDecimal countDaysInMonth = BigDecimal.valueOf(30.0);

        CalculationResponse calculationResponse = new CalculationResponse();

        calculationResponse.setCalculationResult(salary.divide(countDaysInMonth, RoundingMode.HALF_DOWN).multiply(BigDecimal.valueOf(countDays)));

        return calculationResponse;
    }

}
