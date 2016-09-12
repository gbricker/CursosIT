package com.example.guillermobricker.cursosit.pantallas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.guillermobricker.cursosit.R;
import com.example.guillermobricker.cursosit.datos.Curso;
import com.example.guillermobricker.cursosit.datos.DataBaseManagerCurso;
import com.example.guillermobricker.cursosit.recyclerview.CursoAdaptador;

import java.util.List;

public class CursosCard extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private DataBaseManagerCurso managerCurso;
    private List<Curso> listaItemCursos;

    Toolbar toolbar;
    Context context= CursosCard.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos_card);
        //Inicializa el toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        //Inicializar el RV con los elementos de la BD
        managerCurso = new DataBaseManagerCurso(this);
        listaItemCursos = managerCurso.getCursosList();
        inicializaRecycler();


    }

    private void inicializaRecycler() {
        //Obtiene recycler
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        //Usar administrador de Linear Layout
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Crear un nuevo adaptador
        adapter = new CursoAdaptador(this, listaItemCursos);
        recyclerView.setAdapter(adapter);
    }


}
