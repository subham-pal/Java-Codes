package com.subham.hotelreservation.service;

import com.subham.hotelreservation.models.*;
import com.subham.hotelreservation.utils.Comp;

import java.util.*;

public class HotelFinder {

    public Hotel find(HotelList myHotels, Request r){
        ArrayList<HotelSortArgument> list = new ArrayList<HotelSortArgument>();
        for(int i = 0; i < myHotels.count(); ++i){
            double sum = 0;
            HashMap<Category, Double> rateCard = myHotels.getHotel(i).getRateCard();
            for(int j = 0; j < r.dayListSize(); ++j){
                Category c = new Category(r.getDay(j), r.getType());
                sum += rateCard.get(c);
            }
            list.add(new HotelSortArgument(sum, myHotels.getHotel(i)));
        }
        Collections.sort(list, new Comp());
        return list.get(0).getHotel();
    }
}
