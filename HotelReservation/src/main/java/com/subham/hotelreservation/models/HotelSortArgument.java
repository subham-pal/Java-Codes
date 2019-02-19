package com.subham.hotelreservation.models;

public class HotelSortArgument {
    private Double amount;
    private Hotel hotel;

    public HotelSortArgument(double amount, Hotel hotel) {
        this.amount = amount;
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }
    public double getAmount(){
        return amount;
    }
}