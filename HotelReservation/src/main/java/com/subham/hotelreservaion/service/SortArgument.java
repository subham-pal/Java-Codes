package com.subham.hotelreservaion.service;

import com.subham.hotelreservation.models.Hotel;

public class SortArgument {
    private Double amount;
    private Hotel h;

    public SortArgument(double amount, Hotel h) {
        this.amount = amount;
        this.h = h;
    }

    public Hotel getHotel() {
        return h;
    }
    public double getAmount(){
        return amount;
    }
}

