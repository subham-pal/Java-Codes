package com.subham.hotelreservation.models;

import java.util.HashMap;

public class Hotel {
    private String hotelName;
    private Integer rating;
    private HashMap<Request, Double> rateCard;

    public Hotel(String hotelName, Integer rating, HashMap<Request, Double> rateCard) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.rateCard = rateCard;
    }

    public String getHotelName() {
        return hotelName;
    }

    public HashMap<Request, Double> getRateCard(){
        return rateCard;
    }

    public Integer getRating() {
        return rating;
    }
}

