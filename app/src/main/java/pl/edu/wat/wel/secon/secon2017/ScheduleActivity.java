package pl.edu.wat.wel.secon.secon2017;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);



        ArrayList<List> list = new ArrayList<>();

        Calendar c = Calendar.getInstance();


        list.add(new List("7:00 8:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("8:01 9:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:01 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("18:01 19:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("18:59","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("19:03","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));
        list.add(new List("9:00 - 10:00","test test test test test test test test test test test test test test test test test test "));




        ListAdapter adapter = new ListAdapter(this,list);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


    }
}
