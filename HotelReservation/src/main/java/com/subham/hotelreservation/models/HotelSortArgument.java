package com.subham.hotelreservation.models;

public class HotelSortArgument {
    private Double amount;
    private Hotel h;

    public HotelSortArgument(double amount, Hotel h) {
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