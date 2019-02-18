package com.subham.hotelreservaion.service;

import java.util.Comparator;

class Comp implements Comparator<SortArgument> {

    public int compare(SortArgument sortArgument, SortArgument t1) {
        if(sortArgument.getAmount() != t1.getAmount()){
            return (int)(sortArgument.getAmount() - t1.getAmount());
        }
        return (t1.getHotel().getRating() - sortArgument.getHotel().getRating());
    }
}
