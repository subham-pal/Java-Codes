package com.subham.hotelreservation.models;

import java.util.HashMap;

public class Hotel {
    private String hotelName;
    private Integer rating;
    private HashMap<Category, Double> rateCard;

    public Hotel(String hotelName, Integer rating, HashMap<Category, Double> rateCard) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.rateCard = rateCard;
    }

    public String getHotelName() {
        return hotelName;
    }

    public HashMap<Category, Double> getRateCard(){
        return rateCard;
    }

    public Integer getRating() {
        return rating;
    }
}

