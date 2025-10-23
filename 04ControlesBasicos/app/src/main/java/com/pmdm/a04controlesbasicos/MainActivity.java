package com.pmdm.a04controlesbasicos;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int state = 1;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView1);
        Button button1 = findViewById(R.id.button1);
        ToggleButton toggleButton1 = findViewById(R.id.toggleButton);
        ImageButton im1 = findViewById(R.id.imageButton1);
        Button botonEntrar = findViewById(R.id.button2);
        EditText etNombre = findViewById(R.id.editTextText1);
        EditText etPass = findViewById(R.id.editTextTextPassword);
        AutoCompleteTextView acTextView = findViewById(R.id.autoCompleteTextView);
        Spinner spinner = findViewById(R.id.spinner);
        TextView tv = findViewById(R.id.textViewSpinner);
        CheckBox checkBox = findViewById(R.id.checkBox);
        RadioGroup radioGroup = findViewById(R.id.grupo);
        Switch mySwitch = findViewById(R.id.switch1);
        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView textViewSeekBar = findViewById(R.id.textViewSeekBar);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d(TAG, "Valor seleccionado: " + rating);
            }
        });



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeekBar.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    Log.d(TAG,"Esta chekiado");
                }else{

                    Log.d(TAG,"NOOO chekiado");
                }
            }
        });



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.radio1){
                    Log.d("MainActivity", "Seleccionado el color rojo");
                } else if (checkedId == R.id.radio2) {

                    Log.d("MainActivity", "Seleccionado el color azul");
                }

            }
        });



        textView.setText("holaaaa");
        textView.setTextColor(Color.MAGENTA);

        textView.setTextColor(ContextCompat.getColor(this, R.color.especial));

       /* button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Pulsando el boton");
                textView.setText("Adios mundo");
            }
        });*/

        button1.setOnClickListener((View view) -> {
            Log.d("MainActivity", "Pulsando el boton");
            textView.setText("Adios mundo");
        });

        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setText("Encendido");
                } else {
                    textView.setText("APagando ");
                }
            }
        });

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (state) {
                    case 0:

                        im1.setImageResource(R.drawable.battery_full);
                        state = 1;
                        break;
                    case 1:

                        im1.setImageResource(R.drawable.battery_half);
                        state = 2;
                        break;
                    case 2:
                        im1.setImageResource(R.drawable.battery_empty);
                        state = 0;
                        break;
                }
            }
        });


        botonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = etNombre.getText().toString();
                String pass = etPass.getText().toString();
                if (pass.equals("")) {
                    etPass.setError("ESTO NO PUEDE ESTAR VACIO");
                } else {
                    Log.d("MainActivity", nombre + pass);

                }
            }
        });


        String[] opciones = {"lucena", "Cabra", "Rute", "montilla", "Priego"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, opciones);
        acTextView.setAdapter(adaptador);

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String opcion = parent.getItemAtPosition(position).toString();
                tv.setText("Opcion:" + opcion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        checkBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean pulsado) {
                if (pulsado) {
                    Log.d("MainActivity","Activado");
                } else {
                    Log.d("MainActivity","Desactivado");
                }
            }
        });

    }
}