package com.jborn.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jbornema on 2/23/18.
 */
public class Date {

    private int year;
    private int month;
    private int dayOfMonth;

    final private static Map monthToDays;

    static {
        monthToDays = new HashMap(12){{
            put(1, 31);
            put(2, 28);
            put(3, 31);
            put(4, 30);
            put(5, 31);
            put(6, 30);
            put(7, 31);
            put(8, 31);
            put(9, 30);
            put(10, 31);
            put(11, 30);
            put(12, 31);
        }};
    }

    public Date(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    private static int daysInMonth(int month) { return (Integer)monthToDays.get(month); }

    /**
     * Adds the specified number of days to this date
     * @throws IllegalArgumentException when days < 0
     * @param days to add
     */
    public void addDays(int days){
        if(days < 0) throw new IllegalArgumentException("days must be > 0");
        if(days == 0) return;
        int daysToAdd = days;
        while(daysToAdd > 360) {
            year++;
            daysToAdd -= 360;
        }
        while(daysToAdd > daysInMonth(month)) {
            daysToAdd -= daysInMonth(month);
            month++;
            if(month > 12) {
                year++;
                month = month-12 == 0 ? 1 : month-12;
            }
        }
        dayOfMonth += daysToAdd;
        if(dayOfMonth > daysInMonth(month)) {
            dayOfMonth -= daysInMonth(month);
            month++;
        }
        if(month > 12) {
            year++;
            month = month-12 == 0 ? 1 : month-12;
        }
    }

    public String getDate() {
        return String.format("%d/%d/%d \n", month, dayOfMonth, year);
    }

    public static void main(String[] args) {
        Date date = new Date(2018, 2, 23);
        System.out.printf("Starting at %s", date.getDate());
        date.addDays(10);
        System.out.printf("Now at %s", date.getDate());

        date = new Date(2018, 2, 23);
        System.out.printf("Starting at %s", date.getDate());
        date.addDays(0);
        System.out.printf("Now at %s", date.getDate());

        date = new Date(2018, 12, 31);
        System.out.printf("Starting at %s", date.getDate());
        date.addDays(1);
        System.out.printf("Now at %s", date.getDate());
    }
}
