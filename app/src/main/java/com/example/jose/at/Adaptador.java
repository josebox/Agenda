package com.example.jose.at;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jose on 23/11/2017.
 */

public class Adaptador implements ListAdapter {

    // ListAdapter: Adaptador extendido que es el puente entre un ListView y los datos que respaldan la lista. //
    // Frecuentemente, los datos provienen de un Cursor, pero eso no es obligatorio. //
    // El ListView puede mostrar cualquier información siempre que esté envuelto en un ListAdapter.
    ArrayList<Contacto> lista_contactos;
    Context contexto;

    public Adaptador(ArrayList<Contacto> lista_contactos, Context contexto) {
        this.lista_contactos = lista_contactos;
        this.contexto = contexto;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }
    //tamaño de la lista
    @Override
    public int getCount() {
        return lista_contactos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View vistaC = inflater.inflate(R.layout.vista,parent,false);
        TextView tvNombre=(TextView)vistaC.findViewById(R.id.idNombre);
        TextView tvTelefono=(TextView)vistaC.findViewById(R.id.idTelefono);
        tvNombre.setText(lista_contactos.get(position).getNombre());
        tvTelefono.setText(lista_contactos.get(position).getTelefono());
        return vistaC;
    }

    @Override
    public int getItemViewType(int position) {
        Log.v("getItemViewType", String.valueOf(position));
        return lista_contactos.size();
    }

    @Override
    public int getViewTypeCount() {
        return lista_contactos.size();
    }

    @Override
    public boolean isEmpty() {
        return lista_contactos.isEmpty();
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
