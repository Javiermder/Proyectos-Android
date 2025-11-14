package com.pmdm.ud6_actividad1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public EditText etNombre,etCorreo,etTelefono;
    private ActivityResultLauncher<Intent> launcher;

    public Button btnEnviar;
    public TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.edNombre);
        etCorreo = findViewById(R.id.edCorreo);
        etTelefono = findViewById(R.id.edTelefono);
        btnEnviar = findViewById(R.id.btnEnviar);
        tv = findViewById(R.id.tv);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            String nombre = result.getData().getStringExtra("nombre");
                            String correo = result.getData().getStringExtra("correo");
                            String telefono = result.getData().getStringExtra("telefono");
                            tv.setText(nombre + correo + telefono);

                        }
                        if(result.getResultCode() == RESULT_CANCELED){
                            tv.setText("RECHAZADO");
                        }
                    }
                });

        btnEnviar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            String correo = etCorreo.getText().toString();
            String telefono = etTelefono.getText().toString();

            Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
            intent.putExtra("nombre",nombre);
            intent.putExtra("correo",correo);
            intent.putExtra("telefono",telefono);
            launcher.launch(intent);
        });
    }

}