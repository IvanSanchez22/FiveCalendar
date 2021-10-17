package com.example.fivecalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tv = findViewById(R.id.textView);
    }

    public void abrirCalendario(View view) {

        Intent i = new Intent(this, CalendarioActivity.class);
        startActivity(i);
        /*Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String fecha = dayOfMonth + "/" + month + "/" + year ;
                tv.setText(fecha);
            }
        }, year, month, day); dpd.getWindow().setBackgroundDrawable(new ColorDrawable());
        dpd.show();*/
    }

    public void noDesarrollado(View view) {
        Toast.makeText(this, "No desarrollado todavía", Toast.LENGTH_SHORT).show();
    }

}