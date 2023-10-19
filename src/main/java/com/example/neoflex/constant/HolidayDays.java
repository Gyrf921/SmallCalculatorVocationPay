package com.example.neoflex.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public enum HolidayDays {

    NEW_YEAR_1DAY(LocalDate.of(2023, 1, 1)),
    NEW_YEAR_2DAY(LocalDate.of(2023, 1, 2)),
    NEW_YEAR_3DAY(LocalDate.of(2023, 1, 3)),
    NEW_YEAR_4DAY(LocalDate.of(2023, 1, 4)),
    NEW_YEAR_5DAY(LocalDate.of(2023, 1, 5)),
    NEW_YEAR_6DAY(LocalDate.of(2023, 1, 6)),
    NEW_YEAR_7DAY(LocalDate.of(2023, 1, 7)),
    NEW_YEAR_8DAY(LocalDate.of(2023, 1, 8)),
    DEFENDER_OF_THE_FATHERLAND_DAY (LocalDate.of(2023, 2, 23)),
    INTERNATIONAL_WOMEN_DAY (LocalDate.of(2023, 3, 8)),
    SPRING_AND_LABOR_HOLIDAY (LocalDate.of(2023, 5, 1)),
    VICTORY_DAY (LocalDate.of(2023, 5, 9)),
    DAY_OF_RUSSIA (LocalDate.of(2023, 6, 12)),
    NATIONAL_UNITY_DAY (LocalDate.of(2023, 1, 4));

    private final LocalDate holidayDate;

}
