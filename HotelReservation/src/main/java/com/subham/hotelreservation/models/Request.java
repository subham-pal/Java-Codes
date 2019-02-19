package com.subham.hotelreservation.models;

import java.util.ArrayList;

public class Request {
    ArrayList<Day> dayList;
    CustomerType type;

    public Request(ArrayList<Day> dayList, CustomerType type) {
        this.dayList = dayList;
        this.type = type;
    }

    public int dayListSize(){
        return dayList.size();
    }

    public Day getDay(int index){
        return dayList.get(index);
    }

    public CustomerType getType(){
        return type;
    }

    public static class HotelSortArgument {
        private Double amount;
        private Hotel h;

        public HotelSortArgument(double amount, Hotel h) {
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
}
