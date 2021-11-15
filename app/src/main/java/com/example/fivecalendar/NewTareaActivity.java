package com.example.fivecalendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class NewTareaActivity extends AppCompatActivity {

    private static final String TAG = "NewTareaActivity";
    private EditText nombre, descripcion;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextView displayFecha, displayHoraInicio, displayHoraFin;

    private int[] fecha = new int[3];
    private int[] horaInicio = new int[2];
    private int[] horaFin = new int[2];

    private void actualizarDisplayFecha() {
        String fecha = String.format(Locale.getDefault(), "%02d", this.fecha[0]) + "/" + String.format(Locale.getDefault(), "%02d", this.fecha[1] + 1) + "/" + String.format(Locale.getDefault(), "%02d", this.fecha[2]);
        displayFecha.setText(fecha);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tarea);

        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey("fecha")) {
            Calendar calendar = Calendar.getInstance();
            fecha[2] = calendar.get(Calendar.YEAR);
            fecha[1] = calendar.get(Calendar.MONTH);
            fecha[0] = calendar.get(Calendar.DAY_OF_MONTH);
        } else {
            fecha = (int[]) extras.get("fecha");
        }

        nombre = findViewById(R.id.editTextTextPersonName2);
        descripcion = findViewById(R.id.editTextTextMultiLine);
        displayHoraInicio = findViewById(R.id.editTextTime);
        displayHoraFin = findViewById(R.id.editTextTime2);
        displayFecha = findViewById(R.id.tvDatePicker);
        actualizarDisplayFecha();
    }

    public void guardarTarea(View v) {
        Calendar fechaTarea = Calendar.getInstance();
        fechaTarea.set(fecha[2], fecha[1], fecha[0]);
        //Tarea NewTarea = new Tarea(nombre.getText().toString(), descripcion.getText().toString(), fechaTarea, horaInicio, horaFin);

        this.finish();
    }

    public void abrirFecha(View v) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                NewTareaActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fecha[0] = dayOfMonth;
                        fecha[1] = month;
                        fecha[2] = year;
                        actualizarDisplayFecha();
                    }
                },
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void abrirHoraInicio(View view) {
        Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        TimePickerDialog tmd = new TimePickerDialog(NewTareaActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                displayHoraInicio.setText(hourOfDay + ":" + minute);
            }
        }, hora, min, true);
        tmd.show();
    }

}