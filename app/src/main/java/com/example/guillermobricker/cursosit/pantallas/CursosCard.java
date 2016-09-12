package com.example.guillermobricker.cursosit.pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.guillermobricker.cursosit.R;
import com.example.guillermobricker.cursosit.datos.Curso;
import com.example.guillermobricker.cursosit.datos.DataBaseManagerCurso;
import com.example.guillermobricker.cursosit.recyclerview.CursoAdaptador;

import java.util.List;

public class CursosCard extends AppCompatActivity {

    private DataBaseManagerCurso managerCurso;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<Curso> listaItemCursos;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos_card);
        //Inicializa el toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Inicializar el RV con los elementos de la BD
        managerCurso = new DataBaseManagerCurso(this);
        Insertar();
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

    private void Insertar(){

        managerCurso.insertar(null,"Fundamentos", "19","09","2016","Esta es la descripcion","R.mipmap.img_material");
    }
}
