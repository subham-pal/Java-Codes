package com.subham.hotelreservation.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Day{
    WEEKEND(1), WEEKDAY(2);
    int id;
}
