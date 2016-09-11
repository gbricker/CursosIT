package com.example.guillermobricker.cursosit.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Guillermo Bricker on 07/09/2016.
 */
public class CursosDBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Cursos.db";


    public CursosDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Crear tabla
        sqLiteDatabase.execSQL("CREATE TABLE " + CursosContract.CursosEntry.TABLE_NAME + " ("
                + CursosContract.CursosEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CursosContract.CursosEntry.ID + " TEXT NOT NULL,"
                + CursosContract.CursosEntry.NOMBRE_CURSO + " TEXT NOT NULL,"
                + CursosContract.CursosEntry.DIA_INICIO + " INTEGER NOT NULL,"
                + CursosContract.CursosEntry.MES_INICIO + " INTEGER NOT NULL,"
                + CursosContract.CursosEntry.ANIO_INICIO + " INTEGER NOT NULL,"
                + CursosContract.CursosEntry.DES_CURSO + " TEXT NOT NULL,"
                + CursosContract.CursosEntry.IMG_URI + " TEXT, UNIQUE (" + CursosContract.CursosEntry.ID + "))");

        //Metodo insertar datos
        insertaDatos(sqLiteDatabase);

    }



    private void insertaDatos(SQLiteDatabase sqLiteDatabase) {
        //Curso 1
        datosCurso(sqLiteDatabase, new Curso("C-01", "Fundamentos del Diseño Web", "19", "09", "2016",
                "HTML y CSS a nivel intermedio, Maquetacion y Prototipado Web", "fundamentos_diseño.jpg"));

    }

    public long datosCurso(SQLiteDatabase db, Curso curso) {
        return db.insert(
                CursosContract.CursosEntry.TABLE_NAME,
                null,
                curso.toContentValues());
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
