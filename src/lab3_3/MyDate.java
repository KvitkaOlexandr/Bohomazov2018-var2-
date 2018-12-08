package lab3_3;

import java.util.*;

public class MyDate{
	
	private int day;
	private int month;
	private int year;
    private Week weekday;
    private String monthName;
    private int numberOfDays;

    private static String [] months = {"January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};

	
	public MyDate(){
		Calendar date = Calendar.getInstance();
		day = 1;
		month = date.get(Calendar.MONTH) + 1;
		year = date.get(Calendar.YEAR);
        weekday = Week.Monday;
        monthName = months[month - 1];
        numberOfDays = dayInMonth(month);
	}

	public MyDate(int day, int month, int year, Week weekday){
		if(!dateIsValid(day, month, year))
			throw new IllegalArgumentException();
		this.day = day;
		this.month = month;
		this.year = year;
        this.weekday = weekday;
        monthName = months[month - 1];
        numberOfDays = dayInMonth(month);
	}
	
	public int getDay(){
		return day;
	}
	
	public int getMonth(){
		return month;
	}

	public int getYear(){
		return year;
	}

	public Week getWeekday() { return weekday; }

	public String getMonthName() { return  monthName; }

	public int getNumberOfDays() { return numberOfDays; }

	public void setDate(int day, int month, int year, Week weekday){
		if(dateIsValid(day, month, year)){
			this.day = day;
			this.month = month;
			this.year = year;
			this.weekday = weekday;
			monthName = months[month - 1];
		}
	}

    public void nextDay(){
        day++;
        if(day > numberOfDays){
            day = 1;
            monthName = months[month];
            month++;
        }
        if(month > 12){
            monthName = months[month];
            day = 1;
            month = 1;
            year++;
        }
        switch(weekday) {
            case Monday:
                weekday = Week.Tuesday;
                break;
            case Tuesday:
                weekday = Week.Wednesday;
                break;
            case Wednesday:
                weekday = Week.Thursday;
                break;
            case Thursday:
                weekday = Week.Friday;
                break;
            case Friday:
                weekday = Week.Saturday;
                break;
            case Saturday:
                weekday = Week.Sunday;
                break;
            case Sunday:
                weekday = Week.Monday;
                break;
        }
    }

    private int dayInMonth(int number){
        List m = new ArrayList<Integer>();
        m.addAll(Arrays.asList(4, 6, 9, 11));
        if(m.contains(number))
            return 30;
        else if(number == 2)
            return 28;
        else
            return 31;
    }

	private boolean dateIsValid(int day, int month, int year) {
		List m = new ArrayList<Integer>();
		m.addAll(Arrays.asList(4, 6, 9, 11));
		if(year < 1 || month < 1 || day < 1)
			return false;
		if(month > 12)
			return false;
		if(day > 31)
			return false;
		if(month == 2 && day > 28)
			return false;
		if(m.contains(month) && day > 30)
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return weekday.toString() + ", the " + String.valueOf(day)
                + "th of " + monthName + ", " + String.valueOf(year);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MyDate myDate = (MyDate) o;
		return day == myDate.day &&
				month == myDate.month &&
				year == myDate.year &&
                weekday == myDate.weekday &&
                monthName == myDate.monthName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, month, year, weekday, monthName);
	}


}
