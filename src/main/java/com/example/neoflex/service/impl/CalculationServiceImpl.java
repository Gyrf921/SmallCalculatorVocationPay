package com.example.neoflex.service.impl;

import com.example.neoflex.constant.HolidayDays;
import com.example.neoflex.exception.VacationDateException;
import com.example.neoflex.service.CalculationService;
import com.example.neoflex.web.dto.request.InfoForVacationPayDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CalculationServiceImpl implements CalculationService {
    private static final Calendar CALENDAR = new GregorianCalendar();
    private static final BigDecimal COUNT_DAYS_IN_MONTH = BigDecimal.valueOf(30.0);

    @Override
    public BigDecimal calculateVocationPay(InfoForVacationPayDTO requestDTO) {
        log.info("[calculateVocationPay] >> infoForVacationPayDTO: {}", requestDTO);


        long countVocationDay = countDaysInVocation(requestDTO.getVacationStartDate(), requestDTO.getVacationEndDate());

        BigDecimal vocationPay = requestDTO.getSalary().multiply(BigDecimal.valueOf(countVocationDay)).divide(COUNT_DAYS_IN_MONTH, RoundingMode.DOWN);

        log.info("[calculateVocationPay] << result: {}", vocationPay);

        return vocationPay;
    }

    private Long countDaysInVocation(LocalDate dateStart, LocalDate dateEnd) {
        log.info("[countDaysInVocation] >> dateStart: {}, dateEnd: {}", dateStart, dateEnd);
        Set<LocalDate> vocationDays;

        try {
            vocationDays = dateStart.datesUntil(dateEnd).collect(Collectors.toSet());
        } catch (IllegalArgumentException ex) {
            throw new VacationDateException("The start date of the vacation was more than the end date, it is not possible, exception massage: " + ex.getMessage());
        }

        Set<HolidayDays> holidayDaysSet = Arrays.stream(HolidayDays.values()).collect(Collectors.toSet());


        for (HolidayDays holidayDay : holidayDaysSet) {
            vocationDays.removeIf(days -> holidayDay.getHolidayDate().getMonth() == days.getMonth() &&
                    holidayDay.getHolidayDate().getDayOfMonth() == days.getDayOfMonth());
        }

        vocationDays.removeIf(vocationDay -> {
            CALENDAR.setTime(Date.from(vocationDay.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            return CALENDAR.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                    CALENDAR.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
        });

        long countVocationDays = vocationDays.size();

        log.info("[countDaysInVocation] << result: {}", countVocationDays);

        return countVocationDays;
    }

}
