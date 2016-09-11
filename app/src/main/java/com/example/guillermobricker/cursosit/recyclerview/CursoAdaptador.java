package com.example.guillermobricker.cursosit.recyclerview;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guillermobricker.cursosit.R;
import com.example.guillermobricker.cursosit.datos.Curso;
import com.example.guillermobricker.cursosit.pantallas.MainActivity;

import java.util.ArrayList;

/**
 * Created by Guillermo Bricker on 07/09/2016.
 */
public class CursoAdaptador extends RecyclerView.Adapter<CursoAdaptador.ViewHolder> {


    private String[] titles = {"Curso 1", "Curso 2", "Curso 3"};
    private String[] descripcion = {"Descripcion 1", "Descripcion 2", "Descripcion 3"};
    private int[] images = {R.mipmap.img_material, R.mipmap.img_material, R.mipmap.img_material};

    class ViewHolder extends RecyclerView.ViewHolder {
        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.img_card);
            itemTitle = (TextView) itemView.findViewById(R.id.title_card);
            itemDetail = (TextView) itemView.findViewById(R.id.descrip_card);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Snackbar.make(view,"Click en el item"+position,Snackbar.LENGTH_LONG).setAction("Action",null).show();

                }
            });
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_cardview,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(descripcion[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }




}
