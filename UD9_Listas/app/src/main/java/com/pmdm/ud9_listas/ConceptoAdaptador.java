package com.pmdm.ud9_listas;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ConceptoAdaptador extends BaseAdapter {

    ArrayList<Concepto> lista;

    Context context;

    public ConceptoAdaptador(Context context, ArrayList lista){
        this.context = context;
        this.lista = lista;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(context);
        View elemento = li.inflate(R.layout.elemento, parent, false);
        TextView tvNombre = elemento.findViewById(R.id.tvNombre);
        tvNombre.setText(lista.get(position).getNombre());

        TextView tvDefinicion = elemento.findViewById(R.id.tvDefinicion);
        tvDefinicion.setText(lista.get(position).getDeficinion());

        return elemento;

    }
}
