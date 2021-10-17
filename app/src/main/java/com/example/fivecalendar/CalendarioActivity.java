package com.example.fivecalendar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class CalendarioActivity extends AppCompatActivity {

    CalendarView cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        cal = findViewById(R.id.calendarView);

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String fecha = dayOfMonth + "/" + month + "/" + year ;
                Toast.makeText(CalendarioActivity.this, fecha, Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(this, );
                int date[] = {dayOfMonth, month, year};
                intent.putExtra("date", date);
                startActivity(intent);*/
            }
        });
    }
}