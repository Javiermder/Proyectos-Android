package com.pmdm.actividadlistas;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class ItemParaLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_para_lista);

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvDescripcion = findViewById(R.id.tvDescripcion);
        ImageView img = findViewById(R.id.imageView3);



    }
}