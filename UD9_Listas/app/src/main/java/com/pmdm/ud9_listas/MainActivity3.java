package com.pmdm.ud9_listas;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ArrayList<Concepto> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //cargamos datos en la lista
        cargarDatos();

        ListView listview2 = findViewById(R.id.listview2);

        ConceptoAdaptador adaptador = new ConceptoAdaptador(this, lista);

        //ponemos el adaptador a la vista
        listview2.setAdapter(adaptador);

    }


    private void cargarDatos(){
        lista.add(new Concepto("Mesa", "definicion de mesa"));
        lista.add(new Concepto("Silla", "Asiento con respaldo, generalmente con cuatro patas."));
        lista.add(new Concepto("Ordenador", "Máquina electrónica que almacena, procesa y recupera datos."));
        lista.add(new Concepto("Ventana", "Abertura en la pared o techo que permite la entrada de luz y ventilación."));
        lista.add(new Concepto("Libro", "Conjunto de hojas de papel impresas unidas por un lado y protegidas con una tapa."));
        lista.add(new Concepto("Teclado", "Dispositivo de entrada compuesto por un conjunto de teclas."));
        lista.add(new Concepto("Ratón", "Dispositivo apuntador de mano usado para interactuar con una interfaz gráfica."));
        lista.add(new Concepto("Impresora", "Periférico que produce una copia permanente de textos o gráficos de documentos almacenados en formato electrónico."));
        lista.add(new Concepto("Servidor", "Un sistema que proporciona recursos, datos, servicios o programas a otros ordenadores."));

    }
}