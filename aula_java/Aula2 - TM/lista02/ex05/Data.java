import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Data{

    private GregorianCalendar timestamp;
    private Date date;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Data(){
        System.err.println("U must pass a date or string date.");
    }

    public Data (Date date){
        this.timestamp = new GregorianCalendar();
        this.timestamp.setTime(date);
        this.date = date;
    }

    public Data (String date){
        try {
            this.timestamp = new GregorianCalendar();
            this.timestamp.setTime(formatter.parse(date));
            this.date = formatter.parse(date);
        } catch (ParseException e) {
            System.err.print("String DATE invalid format.");
        }
    }

    @Override
    public String toString(){
        return ""+this.date;
    }

    public void addDay(int ammount){
        this.add(ammount, Calendar.DAY_OF_MONTH);
    }

    public void addMonth(int ammount){
        this.add(ammount, Calendar.MONTH);
    }

    public void addYear(int ammount){
        this.add(ammount, Calendar.YEAR);
    }

    private void add(int ammount, int calendarType){
        this.timestamp.add(calendarType, ammount);
        this.date = this.timestamp.getTime();
    }


}