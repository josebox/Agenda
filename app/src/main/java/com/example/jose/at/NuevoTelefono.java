package com.example.jose.at;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NuevoTelefono extends Fragment {

    EditText edNombreInsert ,edTelefonoInsert;
    Button btnAñadir;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public NuevoTelefono() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NuevoTelefono.
     */
    // TODO: Rename and change types and number of parameters
    public static NuevoTelefono newInstance(String param1, String param2) {
        NuevoTelefono fragment = new NuevoTelefono();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
       edNombreInsert = (EditText)getView().findViewById(R.id.edNombreInsert);
        edTelefonoInsert = (EditText)getView().findViewById(R.id.edTelefonoInsert);
        btnAñadir = (Button)getView().findViewById(R.id.btnAñadir);

        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = edNombreInsert.getText().toString();
                String t = edTelefonoInsert.getText().toString();
                Contacto c = new Contacto(n,t);
               // Log.d("n", String.valueOf(edNombreInsert));
                BBDD.insertarContacto(c,getContext());
            }
        });
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nuevo_telefono, container, false);
    }


}
