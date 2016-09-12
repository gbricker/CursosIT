package com.example.guillermobricker.cursosit.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guillermo Bricker on 07/09/2016.
 */
public class CursosDBHelper extends SQLiteOpenHelper {

    public static int DB_VERSION = 1;
    public static final String DB_NAME = "cursos.db";

    private static final String NOMBRE_TABLA = "curso";
    private static final String C_ID = "id";
    private static final String C_NOMBRE = "nombre";
    private static final String C_DIA = "dia";
    private static final String C_MES = "mes";
    private static final String C_ANIO = "anio";
    private static final String C_DESCRIPCION = "descripcion";


    public CursosDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //Crear tabla
        db.execSQL(DataBaseManagerCurso.CREATE_TABLE);
        //Insertar Datos
        db.insert(NOMBRE_TABLA,null,gcv(null, "Fundamentos del Diseño Web", "19","09","2016","HTML y CSS a nivel intermedio, Maquetacion y Prototipado Web"));
        db.insert(NOMBRE_TABLA,null,gcv(null,"Linux Administrator", "26","09","2016","Instalacion y configuracion de Linux, Manejo de redes TCP/IP"));
        db.insert(NOMBRE_TABLA,null,gcv(null, "Programador de Apps Móviles Jr.", "03","10","2016","Manejo adecuado de herramientas de Android Studio"));
        db.insert(NOMBRE_TABLA,null,gcv(null,"Curso Online: Introducción a Apps Móviles", "19","10","2016","Operacion de los servicios Android"));



    }

    private ContentValues gcv(String id, String nom_C, String dia_I, String mes_I, String anio_I, String des_C) {
        ContentValues valores = new ContentValues();

        valores.put(C_ID, id);
        valores.put(C_NOMBRE, nom_C);
        valores.put(C_DIA, dia_I);
        valores.put(C_MES, mes_I);
        valores.put(C_ANIO, anio_I);
        valores.put(C_DESCRIPCION, des_C);

        return valores;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + DB_NAME);

        onCreate(db);

    }
}
