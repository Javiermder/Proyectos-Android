package com.pmdm.act7;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button multichoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multichoice.findViewById(R.id.button);

        CharSequence[] elementos={"CASO 0","CASO 1","CASO 2","CASO 3","CASO 4","CASO 5"};

        multichoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("versiones de android");

                builder.setMultiChoiceItems(elementos, null,
                        new DialogInterface().OnMultiChoiceClickListener() {
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    // Código para realizar
                                } else {
                                    // Código para realizar
                                }
                            }
                        })

            }
        });

    }

}