package com.example.guillermobricker.cursosit.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guillermo Bricker on 07/09/2016.
 */
public class CursosDBHelper extends SQLiteOpenHelper {

    public static int DB_VERSION = 1;
    public static final String DB_NAME = "cursos.db";

    public CursosDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //Crear tabla
        db.execSQL(DataBaseManagerCurso.CREATE_TABLE);

        //Metodo insertar datos
        //       insertaDatos(sqLiteDatabase);
        //System.out.println("Se cargaron");

    }
    /*private void insertaDatos(SQLiteDatabase sqLiteDatabase) {
        //Curso 1
        datosCurso(sqLiteDatabase, new Curso("C-01", "Fundamentos del Diseño Web", "19", "09", "2016",
                "HTML y CSS a nivel intermedio, Maquetacion y Prototipado Web", "fundamentos_diseño.jpg"));
        datosCurso(sqLiteDatabase, new Curso("C-02", "Fundamentos Progra", "19", "09", "2016",
                "HTML y CSS a nivel intermedio, Maquetacion y Prototipado Web", "fundamentos_diseño.jpg"));
        datosCurso(sqLiteDatabase, new Curso("C-03", "Fundamentos Inge", "19", "09", "2016",
                "HTML y CSS a nivel intermedio, Maquetacion y Prototipado Web", "fundamentos_diseño.jpg"));

    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + DB_NAME);

        onCreate(db);

    }
}
