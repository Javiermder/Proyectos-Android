package com.pmdm.unidad06;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

     private Button btnSaltar, btnii;
     private EditText etPassword;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnii = findViewById(R.id.principal_btnii);

        btnii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ABRIR UNA WEB CON EL SMARTPHONE
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.todofp.es"));
                //startActivity(intent);


                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:123456789"));
                //startActivity(intent);

                //ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);

             /*   Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Hola, estoy compartiendo este mensaje!");
                startActivity(Intent.createChooser(intent, "Compartir con..."));
*/

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);

            }


        });

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            String dato = result.getData().getStringExtra("dato_devuelto");
                            //tvResultado.setText("Recibido: " + dato);
                            Log.d("MainActivity","Contrasña modificada devulta:" + dato);
                        }
                    }
                });

        btnSaltar = findViewById(R.id.buttonPrincipal);
        etPassword = findViewById(R.id.Principal_etPassword);

        btnSaltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = etPassword.getText().toString();
                Intent secundaria = new Intent(MainActivity.this, SecondActivity.class);
                secundaria.putExtra("password", password);

                //startActivity(secundaria);
                launcher.launch(secundaria);
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:123456789"));
                startActivity(intent);
            } else {
                Toast.makeText(this, "Permiso denegado para hacer llamadas", Toast.LENGTH_SHORT).show();
            }
        }
    }
}