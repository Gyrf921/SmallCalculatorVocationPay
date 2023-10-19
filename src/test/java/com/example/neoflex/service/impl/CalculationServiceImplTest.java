package com.example.neoflex.service.impl;

import com.example.neoflex.exception.VacationDateException;
import com.example.neoflex.web.dto.request.InfoForVacationPayDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CalculationServiceImplTest {

    @InjectMocks
    private CalculationServiceImpl calculationService;

    @Test
    void calculateVocationPay() {
        InfoForVacationPayDTO info = new InfoForVacationPayDTO(BigDecimal.valueOf(30000.0), LocalDate.of(2023, 10, 19), LocalDate.of(2024, 1, 19));

        BigDecimal vocationPay = calculationService.calculateVocationPay(info);

        System.out.println(vocationPay);
        assertThat(vocationPay).isNotNull();
        assertThat(vocationPay).isNotNegative();
        assertThat(vocationPay).isEqualTo(BigDecimal.valueOf(60000.0));
    }

    @Test
    void calculateVocationPay_VacationDateException() {
        InfoForVacationPayDTO info = new InfoForVacationPayDTO(BigDecimal.valueOf(30000.0), LocalDate.of(2023, 10, 19), LocalDate.of(2023, 1, 19));

        assertThrows(VacationDateException.class, () -> calculationService.calculateVocationPay(info));
    }
}