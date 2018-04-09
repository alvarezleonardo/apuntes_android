package com.example.leonardo.momadh.view;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leonardo.momadh.R;
import com.example.leonardo.momadh.model.Paints;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leona on 29/11/2016.
 */

public class AdapterRecycled extends RecyclerView.Adapter {

    private List<Paints> paintsList;
    private Context context;
    private View.OnClickListener listener;


    public void setPaintsList(List<Paints> paintsList) {
        this.paintsList = paintsList;
    }

    public AdapterRecycled(Context context, View.OnClickListener listener) {
        this.paintsList = new ArrayList<>();
        this.context = context;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View unaView = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_recycled, parent, false);
        AdapterViewHolder unVHolder = new AdapterViewHolder(unaView);
        unaView.setOnClickListener(listener);
        return unVHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Paints paints = paintsList.get(position);
        AdapterViewHolder unHolder = (AdapterViewHolder) holder;
        unHolder.bindProduct(paints, context);
    }

    @Override
    public int getItemCount() {
        return paintsList.size();
    }

    public Paints getPaintAtPosition(Integer posicionNocada){
        return paintsList.get(posicionNocada);
    }

    private static class AdapterViewHolder extends RecyclerView.ViewHolder{
        private FirebaseStorage storage = FirebaseStorage.getInstance();

        private TextView textViewArtista;
        private TextView textViewPintura;
        private ImageView imagenPaint;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            textViewArtista = (TextView) itemView.findViewById(R.id.nameArtist);
            textViewPintura = (TextView) itemView.findViewById(R.id.nameArtistImage);
            imagenPaint = (ImageView) itemView.findViewById(R.id.imagenArtist);
        }

        public void bindProduct(Paints paints, Context context){
            textViewArtista.setText(paints.getArtists().getName());
            textViewPintura.setText(paints.getName());

            StorageReference storageRef = storage.getReferenceFromUrl("gs://momadh-58d56.appspot.com");
            StorageReference imagesRef = storageRef.child(paints.getImage());
            try {

                final File localFile = File.createTempFile("images", "png");
                imagesRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                        imagenPaint.setImageBitmap(bitmap);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        //Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }



}
