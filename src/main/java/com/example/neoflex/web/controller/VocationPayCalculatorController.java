package com.example.neoflex.web.controller;

import com.example.neoflex.web.dto.request.InfoForVacationPayDTO;
import com.example.neoflex.web.dto.response.CalculationResponse;
import com.example.neoflex.service.CalculationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/vacation/pay")
public class VocationPayCalculatorController {

    private final CalculationService calculationService;

    @Operation(summary = "Calculate vacation  for employer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Validation failed for some argument. Invalid input supplied"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PostMapping("/calculate")
    public ResponseEntity<CalculationResponse> calculateVacationPay(@Valid @RequestBody InfoForVacationPayDTO infoForVacationPayDTO) {
        log.info("[calculateVacationPay] >> infoForVacationPayDTO: {}", infoForVacationPayDTO);

        CalculationResponse calculationResponse
                = new CalculationResponse(calculationService.calculateVocationPay(infoForVacationPayDTO));

        log.info("[calculateVacationPay] << result: {}", calculationResponse);

        return ResponseEntity.ok().body(calculationResponse);
    }

}
