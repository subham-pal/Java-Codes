package com.subham.hotelreservation.service;

import com.subham.hotelreservation.utils.HotelSortArgument;

import java.util.Comparator;

class Comp implements Comparator<HotelSortArgument> {

    public int compare(HotelSortArgument hotelSortArgument, HotelSortArgument t1) {
        if(hotelSortArgument.getAmount() != t1.getAmount()){
            return (int)(hotelSortArgument.getAmount() - t1.getAmount());
        }
        return (t1.getHotel().getRating() - hotelSortArgument.getHotel().getRating());
    }
}
