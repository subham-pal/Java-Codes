package com.subham.hotelreservation.utils;

import com.subham.hotelreservation.models.Request;

import java.util.Comparator;

public class Comp implements Comparator<Request.HotelSortArgument> {

    public int compare(Request.HotelSortArgument hotelSortArgument, Request.HotelSortArgument t1) {
        if(hotelSortArgument.getAmount() != t1.getAmount()){
            return (int)(hotelSortArgument.getAmount() - t1.getAmount());
        }
        return (t1.getHotel().getRating() - hotelSortArgument.getHotel().getRating());
    }
}
