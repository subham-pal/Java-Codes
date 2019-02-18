package com.subham.hotelreservaion.service;

import com.subham.hotelreservation.models.Customer;
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

    public Hotel find(HotelList myHotels, Customer c){
        ArrayList<SortArgument> list = new ArrayList<SortArgument>();
        for(int i = 0; i < myHotels.size(); ++i){
            double sum = 0;
            HashMap<Request, Double> rateCard = myHotels.getHotel(i).getRateCard();
            for(int j = 0; j < c.dayListSize(); ++j){
                Request r = new Request(c.getDay(j), c.getType());
                sum += rateCard.get(r);
            }
            list.add(new SortArgument(sum, myHotels.getHotel(i)));
        }
        Collections.sort(list, new Comp());
        return list.get(0).getHotel();
    }
}
