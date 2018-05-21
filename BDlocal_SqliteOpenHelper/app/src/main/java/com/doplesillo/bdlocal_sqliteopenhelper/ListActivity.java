package com.doplesillo.bdlocal_sqliteopenhelper;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView lstUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lstUsuarios = findViewById(R.id.lstUsuarios);
        //Instancia de base de datos
        Usuario usuariosDB = new Usuario(this,"usuarios",null ,1);
        //Obtener tabla usuarios a travez del metodo obtenerUsuarios()
        Cursor usuarios = usuariosDB.obtenerUsuarios();
        //Leer Cursor
        ArrayList<String> nombresUsuarios = new ArrayList<>();
        ArrayList<Integer> edadesUsuarios = new ArrayList<>();

        usuarios.moveToFirst();
        while (!usuarios.isAfterLast()){
            nombresUsuarios.add(usuarios.getString(usuarios.getColumnIndex("name")));
            edadesUsuarios.add(usuarios.getInt(usuarios.getColumnIndex("age")));
            usuarios.moveToNext();
        }

        //Construir adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresUsuarios);
        lstUsuarios.setAdapter(adapter);


    }


}
