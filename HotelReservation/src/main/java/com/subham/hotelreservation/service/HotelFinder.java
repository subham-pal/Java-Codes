package com.subham.hotelreservation.service;

import com.subham.hotelreservation.models.*;
import com.subham.hotelreservation.utils.Comp;

import java.util.*;

public class HotelFinder {

    public Hotel find(HotelList myHotels, Request request){
        ArrayList<HotelSortArgument> list = new ArrayList<HotelSortArgument>();
        for(int i = 0; i < myHotels.count(); ++i){
            Integer sum = 0;
            HashMap<Category, Integer> rateCard = myHotels.getHotel(i).getRateCard();
            for(int j = 0; j < request.dayListSize(); ++j){
                Category category = new Category(request.getDay(j), request.getType());
                sum += rateCard.get(category);
            }
            list.add(new HotelSortArgument(sum, myHotels.getHotel(i)));
        }
        Collections.sort(list, new Comp());
        return list.get(0).getHotel();
    }
}
