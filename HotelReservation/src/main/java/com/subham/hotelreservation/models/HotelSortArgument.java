package com.subham.hotelreservation.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HotelSortArgument {
    private Integer amount;
    private Hotel hotel;
}