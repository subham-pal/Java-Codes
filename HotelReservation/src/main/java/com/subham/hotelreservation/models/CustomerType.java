package com.subham.hotelreservation.models;

public enum CustomerType{
    REGULAR(3), REWARD(4);
    int id;

    CustomerType(int value){
        id = value;
    }

    public int getId(){
        return id;
    }
}