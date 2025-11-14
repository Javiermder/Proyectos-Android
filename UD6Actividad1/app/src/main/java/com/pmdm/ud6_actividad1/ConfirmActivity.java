package com.pmdm.ud6_actividad1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        String nombre = getIntent().getStringExtra("nombre");
        String correo = getIntent().getStringExtra("correo");
        String telefono = getIntent().getStringExtra("telefono");

        Button btnAceptar = findViewById(R.id.btnAceptar);
        Button btnRechazar = findViewById(R.id.btnRechazar);

        btnAceptar.setOnClickListener(v -> {

            Intent resultIntent = new Intent();
            resultIntent.putExtra("nombre", nombre);
            resultIntent.putExtra("correo", correo);
            resultIntent.putExtra("telefono", telefono);
            setResult(RESULT_OK, resultIntent);
            finish(); // cerrar la Activity

        });

        btnRechazar.setOnClickListener(v ->{

            Intent resultIntent = new Intent();
            resultIntent.putExtra("nombre", "");
            resultIntent.putExtra("correo", "");
            resultIntent.putExtra("telefono", "");
            setResult(RESULT_CANCELED, resultIntent);
            finish(); // cerrar la Activity

        });

    }
}