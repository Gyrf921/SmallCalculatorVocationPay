package com.example.neoflex.model.dto;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Data
@ComponentScan
public class CalculationResponse {

    private BigDecimal calculationResult;

}
