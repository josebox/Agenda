package com.example.jose.at;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edNombreInsert,edtelefonoInsert,edBusqueda;
    Button btnAñadir;
    //lista buscar
    ListView lista;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    nuevoTelefono();
                    return true;
                case R.id.navigation_dashboard:
                    buscarContacto();
                    return true;
            }
            return false;
        }

    };

    private void buscarContacto() {
        Fragment fragmento_seleccionado2=new BuscarContacto();
        FragmentManager fm2=getSupportFragmentManager();
        FragmentTransaction t2=fm2.beginTransaction();
        t2.replace(R.id.content, fragmento_seleccionado2);
        t2.commit();
    }

    private void nuevoTelefono() {
        Fragment fragmento_seleccionado=new NuevoTelefono();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction t=fm.beginTransaction();
        t.replace(R.id.content, fragmento_seleccionado);
        t.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        nuevoTelefono();

        //xcvxzvxcvcv
        //lista = (ListView)findViewById(R.id.lvLista);
        //edBusqueda =(EditText)findViewById(R.id.edBusqueda);
        //ArrayList<Contacto>c = BBDD.buscarContacto(edBusqueda.getText().toString());

    }

}
