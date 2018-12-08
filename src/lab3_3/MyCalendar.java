package lab3_3;

import java.util.*;

public class MyCalendar{

    private List<MyDate> currentMonth;

    public MyCalendar(){
        MyDate date = new MyDate();
        currentMonth = new ArrayList<>();
        for(int i = 0; i < date.getNumberOfDays(); i++){
            currentMonth.add(new MyDate(date.getDay(), date.getMonth(), date.getYear(), date.getWeekday()));
            date.nextDay();
        }
    }

    public MyCalendar(int month, int year, Week weekday){
        MyDate date = new MyDate(1, month, year, weekday);
        currentMonth = new ArrayList<>();
        for(int i = 0; i < date.getNumberOfDays() - 1; i++){
            currentMonth.add(new MyDate(date.getDay(), date.getMonth(), date.getYear(), date.getWeekday()));
            date.nextDay();
        }
        currentMonth.add(new MyDate(date.getDay(), date.getMonth(), date.getYear(), date.getWeekday()));
    }

    public MyDate getDate(int date){
        if(date < 0 || date > currentMonth.get(0).getNumberOfDays())
            throw new IllegalArgumentException();
        return currentMonth.get(date - 1);
    }

    public Week getWeekDayByDate(int date){
        if(date < 0 || date > currentMonth.get(0).getNumberOfDays())
            throw new IllegalArgumentException();
        return currentMonth.get(date - 1).getWeekday();
    }

    public List<MyDate> getDateByWeekday(Week weekday){
        List<MyDate> list = new ArrayList<>();
        int i = 0;
        while(currentMonth.get(i).getWeekday() != weekday && i < currentMonth.get(i).getNumberOfDays())
            i++;
        do {
            list.add(currentMonth.get(i));
            if(i + 7 > currentMonth.get(i).getNumberOfDays())
                break;
            i+=7;
        } while (i < currentMonth.get(i).getNumberOfDays() - 1);
        return list;
    }

    public Week nextMonthWeekDay(){
        MyDate date = currentMonth.get(currentMonth.size() - 1);
        date.nextDay();
        return date.getWeekday();
    }

    @Override
    public String toString(){
        String string = "";
        for(int i = 0; i < currentMonth.get(0).getNumberOfDays(); i++)
            string += currentMonth.get(i).toString() + "\n";
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCalendar calendar = (MyCalendar) o;
        return Objects.equals(currentMonth, calendar.currentMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentMonth);
    }
}
