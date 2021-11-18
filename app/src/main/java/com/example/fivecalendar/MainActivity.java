package com.example.fivecalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File file = new File(getFilesDir(), "calendario.bin");
        Calendario calendario = Calendario.getInstance(file);
    }

    public void abrirCalendario(View view) {
        Intent i = new Intent(MainActivity.this, CalendarioActivity.class);
        startActivity(i);
    }

    public void anadirTarea(View view) {
        Intent i = new Intent(MainActivity.this, NewTareaActivity.class);
        startActivity(i);
    }

    public void noDesarrollado(View view) {
        Toast.makeText(MainActivity.this, "No desarrollado todavía", Toast.LENGTH_SHORT).show();
    }

}