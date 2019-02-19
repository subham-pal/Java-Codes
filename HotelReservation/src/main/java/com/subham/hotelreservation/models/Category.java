package com.subham.hotelreservation.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    private Day day;
    private CustomerType type;
}

