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

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Cursos.db";
    public static final Context context = null;


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
        System.out.println("Se cargaron");

    }
    private void insertaDatos(SQLiteDatabase sqLiteDatabase) {
        //Curso 1
        datosCurso(sqLiteDatabase, new Curso("C-01", "Fundamentos del Diseño Web", "19", "09", "2016",
                "HTML y CSS a nivel intermedio, Maquetacion y Prototipado Web", "fundamentos_diseño.jpg"));
        datosCurso(sqLiteDatabase, new Curso("C-02", "Fundamentos Progra", "19", "09", "2016",
                "HTML y CSS a nivel intermedio, Maquetacion y Prototipado Web", "fundamentos_diseño.jpg"));
        datosCurso(sqLiteDatabase, new Curso("C-03", "Fundamentos Inge", "19", "09", "2016",
                "HTML y CSS a nivel intermedio, Maquetacion y Prototipado Web", "fundamentos_diseño.jpg"));

    }

    public long datosCurso(SQLiteDatabase db, Curso curso) {
        return db.insert(
                CursosContract.CursosEntry.TABLE_NAME,
                null,
                curso.toContentValues());
    }




    public List<String> recuperaCursos() {
        SQLiteDatabase db = getReadableDatabase();
        List<String> lista_cursos = new ArrayList<String>();
        String table = CursosContract.CursosEntry.TABLE_NAME;
        String[] valores_recuperar = {CursosContract.CursosEntry.NOMBRE_CURSO};

        Cursor c = db.query(table, valores_recuperar, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                String curso = c.getString(1);
                lista_cursos.add(curso);
            } while (c.moveToNext());
        }

        db.close();
        c.close();
        return lista_cursos;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
