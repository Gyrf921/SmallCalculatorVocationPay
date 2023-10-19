package com.example.neoflex.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InfoForVacationPayDTO {

    @NotNull
    @DecimalMin(value = "13890", message = "The salary cannot be lower than the minimum wage(MROT)")
    private BigDecimal salary;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate vacationStartDate;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate vacationEndDate;
}
