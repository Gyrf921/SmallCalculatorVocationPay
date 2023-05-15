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
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class CalculatorController {

    private static final Set<LocalDate> nonWorkingHolidays = new HashSet<>();
    private static void fillHolidaysArray()
    {
        nonWorkingHolidays.addAll(Arrays.asList(
                LocalDate.of(2023 , 1 , 1 ),
                LocalDate.of(2023 , 1 , 2 ),
                LocalDate.of(2023 , 1 , 3 ),
                LocalDate.of(2023 , 1 , 4 ),
                LocalDate.of(2023 , 1 , 5 ),
                LocalDate.of(2023 , 1 , 6 ),
                LocalDate.of(2023 , 1 , 7 ),
                LocalDate.of(2023 , 1 , 8 ),
                LocalDate.of( 2023 , 2 , 23 ),
                LocalDate.of( 2023 , 3 , 8 ),
                LocalDate.of( 2023 , 5 , 1 ),
                LocalDate.of( 2023 , 5 , 9 ),
                LocalDate.of( 2023 , 6 , 12 ),
                LocalDate.of( 2023 , 4 , 11 )));
    }

    @GetMapping("/calculate")
    public CalculationResponse calculateVacationPay(@RequestParam(value = "salary") BigDecimal salary,
                                                    @RequestParam(value = "startDate") String startDateParam,
                                                    @RequestParam(value = "endDate") String endDateParam) {
        LocalDate startDate = LocalDate.parse( startDateParam);
        //plusDays is necessary so that the program takes into account the last day (passed in the parameter)
        LocalDate endDate = LocalDate.parse(endDateParam).plusDays(1);

        fillHolidaysArray();
        BigDecimal countDaysInMonth = BigDecimal.valueOf(30.0);
        long countAllDays = startDate.until(endDate, ChronoUnit.DAYS);
        long countHoliday = 0;
        Calendar calendarForCheckingWeekends = new GregorianCalendar();
        List<LocalDate> allDatesBetweenStartAndEndDate = startDate.datesUntil(endDate).toList();

        for (LocalDate localDate : allDatesBetweenStartAndEndDate){
            if (localDate.getYear() > 2023) {
                throw new UnsupportedOperationException("this year more than contains in nonWorkingHolidays arrays");
            }
            if (nonWorkingHolidays.contains(localDate)){
                countHoliday++;
                continue;
            }

            calendarForCheckingWeekends.setTime(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            if(calendarForCheckingWeekends.get(Calendar.DAY_OF_WEEK) == 1 || calendarForCheckingWeekends.get(Calendar.DAY_OF_WEEK) == 7){
                countHoliday++;
            }
        }

        CalculationResponse calculationResponse = new CalculationResponse();

        calculationResponse.setCalculationResult(salary.divide(countDaysInMonth, RoundingMode.HALF_DOWN).multiply(BigDecimal.valueOf(countAllDays - countHoliday)));

        return calculationResponse;
    }

}
