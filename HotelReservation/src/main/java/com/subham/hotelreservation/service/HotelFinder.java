package com.subham.hotelreservation.service;

import com.subham.hotelreservation.models.Category;
import com.subham.hotelreservation.models.Hotel;
import com.subham.hotelreservation.models.HotelList;
import com.subham.hotelreservation.models.Request;
import com.subham.hotelreservation.utils.Comp;

import java.util.*;

public class HotelFinder {

    public Hotel find(HotelList myHotels, Request request){
        ArrayList<Request.HotelSortArgument> list = new ArrayList<Request.HotelSortArgument>();
        for(int i = 0; i < myHotels.count(); ++i){
            double sum = 0;
            HashMap<Category, Double> rateCard = myHotels.getHotel(i).getRateCard();
            for(int j = 0; j < request.dayListSize(); ++j){
                Category c = new Category(request.getDay(j), request.getType());
                sum += rateCard.get(c);
            }
            list.add(new Request.HotelSortArgument(sum, myHotels.getHotel(i)));
        }
        Collections.sort(list, new Comp());
        return list.get(0).getHotel();
    }
}
