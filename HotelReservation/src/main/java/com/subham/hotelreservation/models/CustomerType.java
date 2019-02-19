package com.subham.hotelreservation.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomerType{
    REGULAR(3), REWARD(4);
    int id;
}