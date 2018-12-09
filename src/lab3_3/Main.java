package lab3_3;

import java.util.*;

public class Main {
    public static void main(String [] args){
        List<MyCalendar> year = new ArrayList();
        year.add(new MyCalendar(1, 2018, Week.Monday));
        for(int i = 2; i < 13; i++) {
            year.add(new MyCalendar(i, 2018, year.get(i - 2).nextMonthWeekDay()));
        }
        System.out.println("January 14 was " + year.get(0).getWeekDayByDate(14).toString());
        System.out.println("In January mondays were " + year.get(0).getDateByWeekday(Week.Monday).toString());
    }
}
