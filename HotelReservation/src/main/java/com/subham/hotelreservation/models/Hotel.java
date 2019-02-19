package com.subham.hotelreservation.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
@AllArgsConstructor
@Getter
public class Hotel {
    private String hotelName;
    private Integer rating;
    private HashMap<Category, Integer> rateCard;
}

