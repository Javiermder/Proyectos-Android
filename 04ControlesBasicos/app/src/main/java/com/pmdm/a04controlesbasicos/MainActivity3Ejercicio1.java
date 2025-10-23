package com.pmdm.a04controlesbasicos;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3Ejercicio1 extends AppCompatActivity {

    Switch s1noti ;
    Switch s2modo ;
    Switch s3sonido ;

    TextView tvnoti;
    TextView tvmodo;
    TextView tvsonido;

    TextView tvSeek;

    SeekBar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_ejercicio1);

        s1noti = findViewById(R.id.switch2);
        s2modo = findViewById(R.id.switch3);
        s3sonido = findViewById(R.id.switch4);

        tvnoti = findViewById(R.id.tvNoti);
        tvmodo = findViewById(R.id.tvModo);
        tvsonido = findViewById(R.id.tvSonido);
        tvSeek = findViewById(R.id.tvSeek);

        sb = findViewById(R.id.seekBar);


        s1noti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    tvnoti.setText("Notificaciones activadas");

                }else {
                    tvnoti.setText("Notificaciones desactivadas");
                }
            }
        });

        s2modo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tvmodo.setText("Modo act");
                }else {
                    tvmodo.setText("Modo desact");
                }
            }
        });

        s3sonido.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    tvsonido.setText("Sonido activado");

                }else {
                    tvsonido.setText("Sonido desactivado");
                }
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeek.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}