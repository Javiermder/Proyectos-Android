package com.pmdm.actividadlistas;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Bici> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarDatos();

        GridView gridviewItems = findViewById(R.id.gridviewItems);

AdaptadorItem adaptador =new AdaptadorItem(this, lista);

gridviewItems.setAdapter(adaptador);

    }


    public void cargarDatos(){

        lista.add(new Bici("orbea","Marca de bicicletas muy reconocida"));
        lista.add(new Bici("trek", "Marca estadounidense muy popular en ciclismo de montaña"));
        lista.add(new Bici("specialized", "Fabricante líder en bicicletas de carretera y montaña"));
        lista.add(new Bici("cannondale", "Conocida por sus cuadros innovadores y ligeros"));
        lista.add(new Bici("giant", "Una de las mayores productoras de bicicletas a nivel mundial"));
        lista.add(new Bici("bh", "Marca española con gran tradición en ciclismo"));

    }
}