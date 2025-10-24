package com.pmdm.a04controlesbasicos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3Ejercicio2 extends AppCompatActivity {

    Spinner spinner ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_ejercicio2);

        spinner = findViewById(R.id.spinner2);

        String[] paises = {"España","Andorra","Portugal","Alemania","Suecia"};
        spinner.setAdapter( new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,paises));



    }
}