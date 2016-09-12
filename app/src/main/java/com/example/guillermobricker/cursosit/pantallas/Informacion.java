package com.example.guillermobricker.cursosit.pantallas;

import android.content.Intent;
import android.net.Uri;
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

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class Informacion extends AppCompatActivity {

    TextView txt_Info_Nombre, txt_Info_Descripcion;
    Button btn_Dinamico;

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

        //Diferencia de fechas
        int Y1=Integer.parseInt(item.getAnio_Inicio());
        int M1= Integer.parseInt(item.getMes_Inicio());
        int D1= Integer.parseInt(item.getDia_Inicio());

        //Pone leyenda al boton dinamico de acuerdo a la proximidad de fecha
        if(calcula(D1,M1,Y1)<=7){
            btn_Dinamico.setText("Inscripción");
        }else{
            btn_Dinamico.setText("Proximamente");
        }

        //Accion del boton dinamico
        btn_Dinamico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.it-okcenter.com/calendario/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                //Intent intent = new Intent(Informacion.this, PaginaWeb.class);
                startActivity(intent);
            }
        });

    }



    private int calcula(int diaB, int mesB, int anioB) {


        int diaA, mesA, anioA;

        //Obtiene fecha del sistema
        Calendar calendar = Calendar.getInstance();
        diaA = calendar.get(Calendar.DAY_OF_MONTH);
        mesA = calendar.get(Calendar.MONTH)+1;
        anioA = calendar.get(Calendar.YEAR);

        Calendar fechaA = Calendar.getInstance(), fechaB=Calendar.getInstance();

        fechaA.set(Calendar.YEAR,diaA);
        fechaA.set(Calendar.MONTH,mesA);
        fechaA.set(Calendar.DAY_OF_MONTH,anioA);

        fechaB.set(Calendar.YEAR,anioB);
        fechaB.set(Calendar.MONTH,mesB);
        fechaB.set(Calendar.DAY_OF_MONTH,diaB);

        //Resta la fecha B menos la fecha A
        fechaB.add(Calendar.YEAR,-anioA);
        fechaB.add(Calendar.MONTH,-mesA);
        fechaB.add(Calendar.DAY_OF_MONTH,-diaA);

        int a,b,c;
        a= fechaB.get(Calendar.YEAR);
        b= fechaB.get(Calendar.MONTH);
        c= fechaB.get(Calendar.DAY_OF_MONTH);

        if(anioA==anioB){
            a=0;
        }
        if(mesA==mesB){
            b=0;
        }
        if(diaA==diaB){
            c=0;
        }

        return c;

    }


    private void inicializaComponentes() {


    }


}
