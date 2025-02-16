package com.app.financialmanagement.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TicketType {
    EXPENSE(1, "EXPENSE"), GAIN(2, "GAIN");

    private final Integer id;
    private final String type;
}
