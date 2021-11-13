package com.example.fivecalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

public class DiaActivity extends AppCompatActivity {

    private int[] fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia);
        fecha = (int[]) getIntent().getExtras().get("fecha");
        Toolbar toolbar = findViewById(R.id.toolbarTarea);
        toolbar.setTitle("Tareas del día " + fecha[0] + "/" + fecha[1] + "/" + fecha[2]);
        Calendario calendario = Calendario.getInstance();
        List<Tarea> tareas = calendario.getTareasDia(fecha[0], fecha[1], fecha[2]);
    }

    public void añadirTarea(View view) {
        Intent i = new Intent(DiaActivity.this, NewTareaActivity.class);
        startActivity(i);
    }
}