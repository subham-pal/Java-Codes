package com.subham.hotelreservation.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class Request {
    ArrayList<Day> dayList;
    CustomerType type;

    public int dayListSize(){
        return dayList.size();
    }

    public Day getDay(int index){
        return dayList.get(index);
    }
}
