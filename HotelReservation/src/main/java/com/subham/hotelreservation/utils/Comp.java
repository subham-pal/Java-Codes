package com.subham.hotelreservation.utils;

import com.subham.hotelreservation.models.HotelSortArgument;
import com.subham.hotelreservation.models.Request;

import java.util.Comparator;

public class Comp implements Comparator<HotelSortArgument> {

    public int compare(HotelSortArgument hotelSortArgument, HotelSortArgument t1) {
        if(hotelSortArgument.getAmount() < t1.getAmount()){
            return -1;
        }
        else if(hotelSortArgument.getAmount() > t1.getAmount()){
            return 1;
        }
        else{
            if(hotelSortArgument.getHotel().getRating() > t1.getHotel().getRating()){
                return -1;
            }
            return 0;
        }
    }
}
