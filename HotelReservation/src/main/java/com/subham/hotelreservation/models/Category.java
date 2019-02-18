package com.subham.hotelreservation.models;

public class Category {
    private Day day;
    private CustomerType type;

    public Category(Day day, CustomerType type) {
        this.day = day;
        this.type = type;
    }

    public Day getDay() {
        return day;
    }

    public CustomerType getType() {
        return type;
    }


    @Override
    public int hashCode() {
        System.out.println();
        return day.getId() * 31 + type.getId() * 31 * 31;
    }

    @Override
    public boolean equals(Object obj) {
        return (((Category)obj).getDay() == day && ((Category)obj).getType() == type);
    }
}

