package com.example.guillermobricker.cursosit.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guillermobricker.cursosit.R;
import com.example.guillermobricker.cursosit.datos.Curso;

import java.util.List;

/**
 * Created by Guillermo Bricker on 07/09/2016.
 */
public class CursoAdaptador extends RecyclerView.Adapter<CursoAdaptador.ViewHolder> {

    private final Context mainContext;
    private final List<Curso> items;

    public CursoAdaptador(Context mainContext, List<Curso> items) {
        this.mainContext = mainContext;
        this.items = items;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        //Campos de los items
        protected ImageView itemImage;
        protected TextView itemTitle;
        protected TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemImage = (ImageView) itemView.findViewById(R.id.img_card);
            this.itemTitle = (TextView) itemView.findViewById(R.id.title_card);
            this.itemDetail = (TextView) itemView.findViewById(R.id.descripcion_card);

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

        Curso item = items.get(i);
        viewHolder.itemView.setTag(item);
        viewHolder.itemTitle.setText(item.getNombre_Curso());
        viewHolder.itemDetail.setText(item.getDes_Curso());
        viewHolder.itemImage.setImageResource(Integer.parseInt(item.getImg_Uri()));

        // private int[] images = {R.mipmap.img_material, R.mipmap.img_material, R.mipmap.img_material};
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
