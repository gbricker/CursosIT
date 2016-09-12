package com.example.guillermobricker.cursosit.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guillermo Bricker on 11/09/2016.
 */
public class DataBaseManagerCurso extends DataBaseManager {

    private static final String NOMBRE_TABLA = "curso";
    private static final String C_ID = "id";
    private static final String C_NOMBRE = "nombre";
    private static final String C_DIA = "dia";
    private static final String C_MES = "mes";
    private static final String C_ANIO = "anio";
    private static final String C_DESCRIPCION = "descripcion";
    private static final String C_IMG = "imagen";

    //Metodo para crear la tabla
    public static final String CREATE_TABLE = "create table " + NOMBRE_TABLA + " ("
            + C_ID + " integer PRIMARY KEY AUTOINCREMENT, "
            + C_NOMBRE + "text NOT NULL, "
            + C_DIA + "text NOT NULL, "
            + C_MES + "text NOT NULL, "
            + C_ANIO + "text NOT NULL, "
            + C_DESCRIPCION + "text NOT NULL, "
            + C_IMG + "text NOT NULL "
            + ");";

    public DataBaseManagerCurso(Context ctx) {
        super(ctx);
    }

    @Override
    public void cerrar() {
        super.getDb().close();
    }


    private ContentValues gcv(String id, String nom_C, String dia_I, String mes_I, String anio_I, String des_C, String img_uri) {
        ContentValues valores = new ContentValues();

        valores.put(C_ID, id);
        valores.put(C_NOMBRE, nom_C);
        valores.put(C_DIA, dia_I);
        valores.put(C_MES, mes_I);
        valores.put(C_ANIO, anio_I);
        valores.put(C_DESCRIPCION, des_C);
        valores.put(C_IMG, img_uri);

        return valores;
    }


    @Override
    public void insertar(String id, String nom_C, String dia_I, String mes_I, String anio_I, String des_C, String img_uri) {

        //Metodo insertar
        super.getDb().insert(NOMBRE_TABLA, null, gcv(id, nom_C, dia_I, mes_I, anio_I, des_C, img_uri));

    }

    @Override
    public Cursor cargaCursor() {
        String[] columnas = new String[]{C_ID, C_NOMBRE, C_DIA, C_MES, C_ANIO, C_DESCRIPCION, C_IMG};

        return super.getDb().query(NOMBRE_TABLA, columnas, null, null, null, null, null);
    }

    public List<Curso> getCursosList() {
        List<Curso> list = new ArrayList<>();
        Cursor c = cargaCursor();

        while(c.moveToNext()){//Si hay siguiente devuelve true
            Curso curso = new Curso();

            curso.setId(c.getString(0));;
            curso.setNombre_Curso(c.getString(1));
            curso.setDia_Inicio(c.getString(2));
            curso.setMes_Inicio(c.getString(3));
            curso.setAnio_Inicio(c.getString(4));
            curso.setDes_Curso(c.getString(5));
            curso.setImg_Uri(c.getString(6));

            list.add(curso);//Almacena curso en la lista
        }
        return list;
    }
}
