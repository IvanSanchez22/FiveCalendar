package com.example.fivecalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.List;

public class TareaActivity extends AppCompatActivity {

    private int[] fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea);
        fecha = (int[]) getIntent().getExtras().get("fecha");
        Toolbar toolbar = findViewById(R.id.toolbarTarea);
        toolbar.setTitle("Tareas del día " + fecha[0] + "/" + fecha[1] + "/" + fecha[2]);
        Calendario calendario = Calendario.getInstance();
        List<Tarea> tareas = calendario.getTareasDia(fecha[0], fecha[1], fecha[2]);
    }
}