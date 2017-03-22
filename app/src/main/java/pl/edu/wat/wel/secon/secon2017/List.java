package pl.edu.wat.wel.secon.secon2017;

/**
 * Created by Damian Bondaruk on 12/03/2017.
 */

public class List {


    private String date;
    private String message;

    public List(String date, String message){
        this.date = date;
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
