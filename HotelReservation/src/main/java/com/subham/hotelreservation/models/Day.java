package com.subham.hotelreservation.models;

public enum Day{
    WEEKEND(1), WEEKDAY(2);
    int id;

    Day(int value){
        id = value;
    }
    public int getId(){
        return id;
    }
}
