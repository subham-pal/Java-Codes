package com.subham.hotelreservation.models;

import com.subham.hotelreservation.models.Hotel;

import java.util.ArrayList;

public class HotelList {
    private ArrayList<Hotel> listOfHotels;

    public HotelList(){
        listOfHotels = new ArrayList<Hotel>();
    }
    public void addHotel(Hotel h){
        listOfHotels.add(h);
    }

    public void removeHotel(Hotel h){
        listOfHotels.remove(h);
    }

    public int count(){
        return listOfHotels.size();
    }

    public Boolean contains(String h){
        for(int i = 0; i < listOfHotels.size(); ++i){
            if(listOfHotels.get(i).getHotelName().equals(h)){
                return true;
            }
        }
        return false;
    }

    public Hotel getHotel(String name){
        for(int i = 0; i < listOfHotels.size(); ++i){
            if(listOfHotels.get(i).getHotelName().equals(name)){
                return listOfHotels.get(i);
            }
        }
        return null;
    }

    public Hotel getHotel(int index){
        return listOfHotels.get(index);
    }

}
