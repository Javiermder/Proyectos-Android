package com.pmdm.ud05;

import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnToast, btnDateDialog, btnTimeDialog, btnNotification;
    private Button btnDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();

        btnToast = findViewById(R.id.btnToast);
        btnDialog = findViewById(R.id.btnDialog);
        btnDateDialog = findViewById(R.id.btnDateDialog);
        btnTimeDialog = findViewById(R.id.btnTimeDialog);
        btnNotification = findViewById(R.id.btnNotification);


        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //construye la notificación

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "1")
                        .setSmallIcon(android.R.drawable.ic_dialog_info) // Icono
                        .setContentTitle("Titulo") // Título
                        .setContentText("Mi primera noti") // Contenido
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT) // Prioridad
                        .setAutoCancel(true); // Desaparece al tocarla

                //envía la notificación
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                int notificationId = 1; //id de la notificación
                notificationManager.notify(notificationId, builder.build()); //lanza la notificación
            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Helou mundoo!", Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(), "Helou mundoo!", Toast.LENGTH_LONG).show();

            }
        });

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showDialog2();
                //showDialog2();
                //showDialog3();
                showDialog4();
            }
        });

        btnDateDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calen = Calendar.getInstance();
                int year = calen.get(Calendar.YEAR);
                int month = calen.get(Calendar.MONTH);
                int day = calen.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog fecha = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


                            }
                        }, year, month, day);
                fecha.show();
            }
        });

        btnTimeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calen = Calendar.getInstance();
                int hour = calen.get(Calendar.HOUR_OF_DAY);
                int minute = calen.get(Calendar.MINUTE);

                TimePickerDialog hora = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {



                            }
                        }, hour, minute, false);
                hora.show();
            }
        });



    }

    private void showDialog1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("EJEMPLO DE DIÁLOGO");
        builder.setTitle("TÍTULO DEL DIÁLOGO");
        builder.setIcon(R.mipmap.ic_launcher);
        AlertDialog dialogo = builder.create();
        dialogo.show();
    }

    private void showDialog2(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("EJEMPLO DE DIÁLOGO");
        builder.setTitle("TÍTULO DEL DIÁLOGO");
        builder.setIcon(R.mipmap.ic_launcher);



        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Acción al hacer clic en Aceptar
                Toast.makeText(MainActivity.this, "Aceptado", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Acción al hacer clic en Cancelar
                Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(MainActivity.this, "Neutraaaal", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialogo = builder.create();
        dialogo.show();
    }

    private void showDialog3(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("TÍTULO DEL DIÁLOGO");
        builder.setIcon(R.mipmap.ic_launcher);

        CharSequence[] elementos={"CASO 0","CASO 1","CASO 2","CASO 3","CASO 4","CASO 5"};

        builder.setItems(elementos, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "id:"+id, Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog dialogo = builder.create();
        dialogo.show();
    }
    private void showDialog4(){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(view);

        // Referencias a los elementos del layout
        EditText etName = view.findViewById(R.id.etName);
        CheckBox cbRemember = view.findViewById(R.id.cbRemember);
        Button btnCustomAction = view.findViewById(R.id.btnCustomAction);



        AlertDialog dialogo = builder.create();
        dialogo.show();

        btnCustomAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                boolean remember = cbRemember.isChecked();

                    Toast.makeText(MainActivity.this,  name + " - "+ remember, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void createNotificationChannel() {
        //id de canal, nombre e importancia
        NotificationChannel channel = new NotificationChannel("1", "1", NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("1");    //descripción del canal

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
    }
}