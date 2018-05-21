package com.doplesillo.bdlocal_sqliteopenhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Doplesillo on 13/02/18.
 */

public class Usuario extends SQLiteOpenHelper {
    //Variables para la versión
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "usuarios.db";

    //Sentencias SQL
    private static final String SQL_CREATE = "CREATE TABLE users"
            +"(id integer PRIMARY KEY AUTOINCREMENT,"
            +"name TEXT NOT NULL,"
            +"age INTEGER NOT NULL);";

    public Usuario(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
/*
* Este método se ejecuta sólo la primera vez que la clase es referenciada,
* En ese momento se tiene que crear la (o las tablas)
* */
    sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
/*
* Este método se ejecuta cuando se detecta una migración de BD
* */
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    public  void agregar (String nombre, int edad){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",nombre);
        values.put("age",edad);
        db.insert("users",null,values);
        db.close();
    }

    public Cursor obtenerUsuarios(){
        String[] columnas = {"id","name","age"};
        return getReadableDatabase().query("users",columnas,null,null,null,null,null);
    }
    



     public void actualizar (String nombre, int id){

                SQLiteDatabase db = this.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("nombre",nombre);

                int i = db.update("users",
                        values,
                        " id = ?",
                        new String[] { String.valueOf( id ) });
                db.close();
            }


}
