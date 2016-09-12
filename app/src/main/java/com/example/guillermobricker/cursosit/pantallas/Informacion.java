package com.example.guillermobricker.cursosit.pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guillermobricker.cursosit.PaginaWeb;
import com.example.guillermobricker.cursosit.R;
import com.example.guillermobricker.cursosit.datos.Curso;
import com.example.guillermobricker.cursosit.datos.DataBaseManagerCurso;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class Informacion extends AppCompatActivity {

    TextView txt_Info_Nombre, txt_Info_Descripcion;
    Button btn_Dinamico;
    private int actual_D, actual_M, actual_Y;
    private List<Curso> items;
    private DataBaseManagerCurso managerCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        inicializaComponentes();
        txt_Info_Nombre = (TextView) findViewById(R.id.txt_Info_Nombre);
        txt_Info_Descripcion = (TextView) findViewById(R.id.txt_Info_Descripcion);
        btn_Dinamico = (Button) findViewById(R.id.btn_Dinamico);
        //Obtene el ID del curso a mostrar
        String nc = getIntent().getStringExtra("Numero");
        //Lee informacion
        managerCurso = new DataBaseManagerCurso(this);
        //getCursoList crea una lista con el apartir del curso buscado por ID
        items =  managerCurso.getCursoList(nc);
        Curso item= items.get(0);
        txt_Info_Nombre.setText(item.getNombre_Curso());
        txt_Info_Descripcion.setText(item.getDes_Curso());

        //Obtener fecha actual del sistema
        Calendar calendar = Calendar.getInstance();
        actual_D = calendar.get(Calendar.DAY_OF_MONTH);
        actual_M = calendar.get(Calendar.MONTH);
        actual_Y = calendar.get(Calendar.YEAR);


        //Diferencia de fechas
        int Y1=Integer.parseInt(item.getAnio_Inicio());
        int M1= Integer.parseInt(item.getMes_Inicio());
        int D1= Integer.parseInt(item.getDia_Inicio());

        java.util.GregorianCalendar date=new java.util.GregorianCalendar(Y1,M1,D1);
        java.util.GregorianCalendar date2=new java.util.GregorianCalendar(actual_Y,actual_M,actual_D);
        long difms=date2.getTimeInMillis() - date.getTimeInMillis();
        long difd=difms / (1000 * 60 * 60 * 24);

        Toast.makeText(this,"La fecha de hoy es_ "+ date,Toast.LENGTH_LONG).show();
        Toast.makeText(this,"La fecha del curso es: "+ date2,Toast.LENGTH_LONG).show();
        Toast.makeText(this,"La diferencia de dias es: "+ difd,Toast.LENGTH_LONG).show();


        if(difd<=7){
            btn_Dinamico.setText("Inscripción");
        }else{
            btn_Dinamico.setText("Proximamente");
        }


        btn_Dinamico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Informacion.this, PaginaWeb.class);
                startActivity(intent);
            }
        });

    }


    private void texto_BotonDinamico(int id) {



    }


    private void inicializaComponentes() {


    }


}
