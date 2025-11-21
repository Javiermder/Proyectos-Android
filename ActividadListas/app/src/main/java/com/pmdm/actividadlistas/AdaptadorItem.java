package com.pmdm.actividadlistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptadorItem extends BaseAdapter {

    private Context context;
    List<Bici> lista;

    public AdaptadorItem(Context Context, List<Bici> Lista){

        this.context = Context;
        this.lista = Lista;

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.activity_item_para_lista, parent, false);
        }

        // Obtener los elementos de la vista
        Bici article = lista.get(position);

        // Asignar los valores a los elementos de la vista
        TextView nombreTextView = view.findViewById(R.id.tvNombre);
        TextView descripcionTextView = view.findViewById(R.id.tvDescripcion);
        ImageView imageView = view.findViewById(R.id.imageView3);

        nombreTextView.setText(article.getNombre());
        descripcionTextView.setText(article.getDescripcion());
        //imageView.setImageResource(article.getUrlImagen());

        return view;
    }

}
