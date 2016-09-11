package com.example.guillermobricker.cursosit.datos;

import android.content.Context;

/**
 * Created by Guillermo Bricker on 11/09/2016.
 */
public class ListasInformacion {

    Context context;

    public String[] lista() {

            CursosDBHelper cursosDBHelper = new CursosDBHelper(context);
            String[] listacursos = new String[cursosDBHelper.recuperaCursos().size()];

            listacursos = cursosDBHelper.recuperaCursos().toArray(listacursos);

            for (String s : listacursos)
                System.out.println(s);
            return listacursos;

    }

}
