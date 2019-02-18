package com.subham.hotelreservation.models;

public enum Type{
    REGULAR(3), REWARD(4);
    int id;

    Type(int value){
        id = value;
    }

    public int getId(){
        return id;
    }
}