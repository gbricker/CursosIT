package com.example.guillermobricker.cursosit.datos;

import android.net.Uri;
import android.provider.BaseColumns;

import java.util.UUID;

/**
 * Created by Guillermo Bricker on 07/09/2016.
 */
//Esquema de la BD
public class CursosContract {
    public static abstract class CursosEntry implements BaseColumns { //Clase que guarda el nombre de las columnas de la tabla.
        public static final String TABLE_NAME = "curso";

        public static final String ID = "id";
        public static final String NOMBRE_CURSO = "nombre_Curso";
        public static final String DIA_INICIO = "dia_Inicio";
        public static final String MES_INICIO = "mes_Inicio";
        public static final String ANIO_INICIO = "anio_Inicio";
        public static final String DES_CURSO = "des_Curso";
        public static final String IMG_URI = "img_Uri";
    }


}
