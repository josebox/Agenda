package com.example.jose.at;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by jose on 20/11/2017.
 */
//
public class BBDD {


    static SQLiteOpenHelper openhelper;

    public static SQLiteDatabase inicializar(Context c)
    {
         openhelper=new SQLiteOpenHelper(c, "agenda2", null, 1) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                String tablaContactos="CREATE TABLE `Agenda` (\n" +
                        "  `contacto` TEXT,\n" +
                        "  `telefono` TEXT\n" +
                        ");";
                //cargamos la tabla en la bbdd
                db.execSQL(tablaContactos);

            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }
        };
        SQLiteDatabase bbdd;
        bbdd=openhelper.getWritableDatabase();
        return bbdd;
    }
    public static void insertarContacto (Contacto c,Context context)
    {
        inicializar(context);
        inicializar(context);
        String nombre = c.getNombre();
        String telefono = c.getTelefono();
        String insertar = "Insert into Contactos (nombre,telefono) values ('"+nombre+"','"+telefono+"');";
        SQLiteDatabase bbdd = inicializar(context);
        bbdd.execSQL(insertar);
    }


    public static ArrayList<Contacto> buscarContacto ( String busqueda,Context context)
    {

        ArrayList<Contacto>listaAgenda = new ArrayList<>();
        String select = "select contacto,telefono from Agenda";
        String selectNombre = "select contacto,telefono from Agenda where nombre LIKE %?%";
        String selectTelefono = "select contacto,telefono from Agenda where telefono=?";
        boolean esNumero = true;
        Cursor cursor;
        SQLiteDatabase bbdd = inicializar(context);
        cursor = bbdd.rawQuery(select, null);
        while (cursor.moveToNext()){
            String nombre = cursor.getString(0);
            String telefono = cursor.getString(1);
            Contacto contacto = new Contacto(nombre,telefono);
            listaAgenda.add(contacto);
        }
        return listaAgenda;



    }
}
