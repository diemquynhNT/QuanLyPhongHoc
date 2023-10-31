/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalendarForm;

import java.util.Calendar;

public class ToDay {
     int day,month,year;

    public ToDay() {
    }

    public ToDay(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
     
    public boolean checkToDay(ToDay date)
    {
        if(day==date.getDay() && month==date.getMonth() && year==date.getYear())
            return true ;
        return false;
    }
}
