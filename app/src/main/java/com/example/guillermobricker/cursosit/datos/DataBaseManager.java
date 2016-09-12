package com.example.guillermobricker.cursosit.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by Guillermo Bricker on 11/09/2016.
 */
public abstract class DataBaseManager {
    private CursosDBHelper helper;
    private SQLiteDatabase db;

    //Constructor
    public DataBaseManager(Context ctx) {
        helper = new CursosDBHelper(ctx);
        db = helper.getWritableDatabase();
    }

    //Metodo para cerrar la BD
    public void cerrar(){
        db.close();
    }


    abstract public Cursor cargaCursor();
    abstract public Cursor leer_ID (String id);




    //Getters y Setters
    public CursosDBHelper getHelper() {
        return helper;
    }

    public void setHelper(CursosDBHelper helper) {
        this.helper = helper;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }


}
