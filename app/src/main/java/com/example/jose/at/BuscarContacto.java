package com.example.jose.at;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class BuscarContacto extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView lista;
    EditText edBusqueda;

    public BuscarContacto() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuscarContacto.
     */
    // TODO: Rename and change types and number of parameters
    public static BuscarContacto newInstance(String param1, String param2) {
        BuscarContacto fragment = new BuscarContacto();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        lista = (ListView)getView().findViewById(R.id.lvLista);
        edBusqueda = (EditText)getView().findViewById(R.id.edBusqueda);
        //ArrayList<Contacto> c = BBDD.buscarContacto(edBusqueda.getText().toString());
        ArrayList<Contacto> c = BBDD.buscarContacto(edBusqueda.getText().toString(),getContext());
        ListAdapter adaptador=new Adaptador(c, getContext());
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();

            }
        });
    }

}
