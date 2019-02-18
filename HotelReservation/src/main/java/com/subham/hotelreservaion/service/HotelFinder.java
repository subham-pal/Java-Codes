package com.subham.hotelreservaion.service;

import com.subham.hotelreservation.models.Category;
import com.subham.hotelreservation.models.Hotel;
import com.subham.hotelreservation.models.HotelList;
import com.subham.hotelreservation.models.Request;

import java.util.*;

class SortArgument {
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

class Comp implements Comparator<SortArgument>{

    public int compare(SortArgument sortArgument, SortArgument t1) {
        if(sortArgument.getAmount() != t1.getAmount()){
            return (int)(sortArgument.getAmount() - t1.getAmount());
        }
        return (t1.getHotel().getRating() - sortArgument.getHotel().getRating());
    }
}


public class HotelFinder {

    public Hotel find(HotelList myHotels, Request r){
        ArrayList<SortArgument> list = new ArrayList<SortArgument>();
        for(int i = 0; i < myHotels.size(); ++i){
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
