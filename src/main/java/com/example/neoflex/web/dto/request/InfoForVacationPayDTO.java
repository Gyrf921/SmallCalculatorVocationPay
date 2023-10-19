package com.example.neoflex.web.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class InfoForVacationPayDTO {

    @NotNull
    @DecimalMin(value = "13890", message = "The salary cannot be lower than the minimum wage(MROT)")
    BigDecimal salary;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "The begin of the vacation cannot be in the past")
    LocalDate vacationStartDate;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "The end of the vacation cannot be in the past")
    LocalDate vacationEndDate;
}
