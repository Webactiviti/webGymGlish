package com.example.webgymglish.view;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.example.webgymglish.R;
import com.example.webgymglish.model.FieldSiteWeb;

import java.util.ArrayList;


/**
 * FieldAdapter class
 *
 * Created by Jean-Christophe  on 02/07/2019.
 */
public class FieldAdapter extends RecyclerView.Adapter<FieldAdapter.ViewHolder> {


    private ArrayList<FieldSiteWeb> fieldSiteWebs;


    private OnFieldsListener onFieldsListener;


    public FieldAdapter(ArrayList<FieldSiteWeb> fieldSiteWeb, OnFieldsListener onFieldsListener) {
        this.fieldSiteWebs = fieldSiteWeb;
        this.onFieldsListener = onFieldsListener;
    }


    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_site_web, parent, false);

        return new FieldAdapter.ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final FieldSiteWeb fieldSiteWeb = fieldSiteWebs.get(position);

        holder.ttvTitreWeb.setText(fieldSiteWeb.getDescriptif());
        holder.ttvurl.setText(fieldSiteWeb.getUrl_court());


        holder.root.setOnClickListener(v -> {
            if (onFieldsListener != null) {
                onFieldsListener.onClick(fieldSiteWeb);
            }
        });
    }


    public int getItemCount() {
        return fieldSiteWebs.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

         TextView ttvTitreWeb, ttvurl;
         View root;

        ViewHolder(View itemView) {
            super(itemView);

            ttvTitreWeb=  itemView.findViewById(R.id.ttvTitreWeb);
            ttvurl =  itemView.findViewById(R.id.ttvURL);
            root = itemView.findViewById(R.id.root);
        }
    }

    public interface OnFieldsListener {

        void onClick(FieldSiteWeb fieldSiteWebs);

    }


}
