package com.pmdm.ud6_actividad4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public EditText edNombre,edTelefono,edCorreo;
    public Button btnFecha, btnHora,btnRevisar;

    public Spinner spinnerComensales;
    public ToggleButton tbTerraza;
    public CheckBox chbAccesible, chbInfantil,chbVegetariano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre = findViewById(R.id.etNombre);
        edTelefono = findViewById(R.id.etTelefono);
        edCorreo = findViewById(R.id.etEmail);
        btnFecha = findViewById(R.id.btnFecha);
        btnHora = findViewById(R.id.btnHora);
        btnRevisar = findViewById(R.id.btnRevisar);
        spinnerComensales = findViewById(R.id.spinnerComensales);
        tbTerraza = findViewById(R.id.tbTerraza);
        chbAccesible = findViewById(R.id.chbAccesibilidad);
        chbInfantil = findViewById(R.id.chbInfantil);
        chbVegetariano = findViewById(R.id.chbVegetariano);


        btnRevisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edNombre.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Uno de los campos rellenables esta vacio compruebelo y vuelve a mandarlo",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}