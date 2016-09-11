package com.example.guillermobricker.cursosit.datos;

import android.content.Context;

/**
 * Created by Guillermo Bricker on 11/09/2016.
 */
public class ListasInformacion {

    Context context;

    public String[] lista() {
        CursosDBHelper cursosDBHelper = new CursosDBHelper(context);
        String[] arreglo = cursosDBHelper.recuperaCursos().toArray(new String[cursosDBHelper.recuperaCursos().size()]);
        return arreglo;


    }

}
