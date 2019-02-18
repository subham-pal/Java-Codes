package com.subham.hotelreservaion.service;

import com.subham.hotelreservation.models.Category;
import com.subham.hotelreservation.models.Hotel;
import com.subham.hotelreservation.models.HotelList;
import com.subham.hotelreservation.models.Request;
import java.util.*;

public class HotelFinder {

    public Hotel find(HotelList myHotels, Request r){
        ArrayList<SortArgument> list = new ArrayList<SortArgument>();
        for(int i = 0; i < myHotels.count(); ++i){
            double sum = 0;
            HashMap<Category, Double> rateCard = myHotels.getHotel(i).getRateCard();
            for(int j = 0; j < r.dayListSize(); ++j){
                Category c = new Category(r.getDay(j), r.getType());
                sum += rateCard.get(c);
            }
            list.add(new SortArgument(sum, myHotels.getHotel(i)));
        }
        Collections.sort(list, new Comp());
        return list.get(0).getHotel();
    }
}
