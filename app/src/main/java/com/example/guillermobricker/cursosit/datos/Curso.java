package com.example.guillermobricker.cursosit.datos;

import android.content.ContentValues;

/**
 * Created by Guillermo Bricker on 07/09/2016.
 */
//Entidad Curso
public class Curso {
    private String id;
    private String nombre_Curso;
    private String dia_Inicio;
    private String mes_Inicio;
    private String anio_Inicio;
    private String des_Curso;
    private String img_Uri;

    public Curso(String id, String nombre_curso, String dia_inicio, String mes_inicio, String anio_inicio, String des_curso, String img_Uri) {
        this.id = id;
        this.nombre_Curso = nombre_curso;
        this.dia_Inicio = dia_inicio;
        this.mes_Inicio = mes_inicio;
        this.anio_Inicio = anio_inicio;
        this.des_Curso = des_curso;
        this.img_Uri = img_Uri;
    }

    public String getNombre_Curso() {
        return nombre_Curso;
    }

    public void setNombre_Curso(String nombre_Curso) {
        this.nombre_Curso = nombre_Curso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDia_Inicio() {
        return dia_Inicio;
    }

    public void setDia_Inicio(String dia_Inicio) {
        this.dia_Inicio = dia_Inicio;
    }

    public String getMes_Inicio() {
        return mes_Inicio;
    }

    public void setMes_Inicio(String mes_Inicio) {
        this.mes_Inicio = mes_Inicio;
    }

    public String getAnio_Inicio() {
        return anio_Inicio;
    }

    public void setAnio_Inicio(String anio_Inicio) {
        this.anio_Inicio = anio_Inicio;
    }

    public String getDes_Curso() {
        return des_Curso;
    }

    public void setDes_Curso(String des_Curso) {
        this.des_Curso = des_Curso;
    }

    public String getImg_Uri() {
        return img_Uri;
    }

    public void setImg_Uri(String img_Uri) {
        this.img_Uri = img_Uri;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(CursosContract.CursosEntry.ID, id);
        values.put(CursosContract.CursosEntry.NOMBRE_CURSO, nombre_Curso);
        values.put(CursosContract.CursosEntry.DIA_INICIO, dia_Inicio);
        values.put(CursosContract.CursosEntry.MES_INICIO, mes_Inicio);
        values.put(CursosContract.CursosEntry.ANIO_INICIO, anio_Inicio);
        values.put(CursosContract.CursosEntry.DES_CURSO, des_Curso);
        values.put(CursosContract.CursosEntry.IMG_URI, img_Uri);
        return values;
    }
}
