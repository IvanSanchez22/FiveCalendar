package com.example.fivecalendar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class NewTareaActivity extends AppCompatActivity {

    private static final String TAG = "NewTareaActivity";
    private int[] fechaA;
    private EditText nombre, descripcion, horaInicio, horaFin;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextView mDisplayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tarea);
        nombre = (EditText)findViewById(R.id.editTextTextPersonName2);
        descripcion = (EditText)findViewById(R.id.editTextTextMultiLine);
        horaInicio = (EditText)findViewById(R.id.editTextTime);
        horaInicio = (EditText)findViewById(R.id.editTextTime2);

        mDisplayDate = (TextView)findViewById(R.id.tvDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        NewTareaActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + year + "/" + month + "/" + dayOfMonth);
                String date = month + "/" + dayOfMonth + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey("fecha")) {
            Toast.makeText(this, "Llamado desde el Menú", Toast.LENGTH_SHORT).show();

        } else {
            fechaA = (int[]) extras.get("fecha");
            Toast.makeText(this, "Llamado desde el día" + Integer.toString(fechaA[0]) + "/" + Integer.toString(fechaA[1]) + "/" + Integer.toString(fechaA[2]), Toast.LENGTH_SHORT).show();

        }
    }

    public void GuardarTarea() {
        //Tarea NewTarea = new Tarea(nombre.getText().toString(), descripcion.getText().toString(), fecha.getText(), horaInicio, horaFin);


        this.finish();
    }
}