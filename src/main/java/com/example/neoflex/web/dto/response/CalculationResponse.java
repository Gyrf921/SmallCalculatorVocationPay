package com.example.neoflex.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CalculationResponse {

    private BigDecimal calculationResult;

}
