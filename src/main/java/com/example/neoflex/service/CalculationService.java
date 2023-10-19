package com.example.neoflex.service;

import com.example.neoflex.web.dto.request.InfoForVacationPayDTO;

import java.math.BigDecimal;

public interface CalculationService {

    /**
     * A method that calculates vacation pay for an employee based on his salary, the start date of the vacation and the end date
     *
     * @param infoForVacationPayDTO - information about employers salary, and dates for vocation
     * @return - vocation pay
     */
    BigDecimal calculateVocationPay(InfoForVacationPayDTO infoForVacationPayDTO);

}
