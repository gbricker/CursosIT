package com.example.guillermobricker.cursosit.recyclerview;

import android.content.Context;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guillermobricker.cursosit.R;
import com.example.guillermobricker.cursosit.datos.Curso;
import com.example.guillermobricker.cursosit.datos.CursosDBHelper;
import com.example.guillermobricker.cursosit.datos.ListasInformacion;
import com.example.guillermobricker.cursosit.pantallas.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guillermo Bricker on 07/09/2016.
 */
public class CursoAdaptador extends RecyclerView.Adapter<CursoAdaptador.ViewHolder> {

    ListasInformacion li = new ListasInformacion();
    private String[] titles = {"Curso 1", "Curso 2", "Curso 3"};
    private String[] descripcion = {"Descripcion 1", "Descripcion 2", "Descripcion 3"};
    private int[] images = {R.mipmap.img_material, R.mipmap.img_material, R.mipmap.img_material};

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.img_card);
            itemTitle = (TextView) itemView.findViewById(R.id.title_card);
            itemDetail = (TextView) itemView.findViewById(R.id.descrip_card);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_cardview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {



        //viewHolder.itemTitle.setText(li.lista()[i]);
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(descripcion[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {


        return titles.length;
        //return li.lista().length;
    }


}
