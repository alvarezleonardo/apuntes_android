package com.example.leonardo.momadh.dao;

import android.content.Context;

import com.example.leonardo.momadh.model.Artists;
import com.example.leonardo.momadh.model.ContainerFirebase;
import com.example.leonardo.momadh.model.Paints;
import com.example.leonardo.momadh.model.ResultListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leona on 28/11/2016.
 */

public class DAOartist {

    private ResultListener<List<Paints>> resultListener;

    public DAOartist(ResultListener<List<Paints>> resultListener) {
        this.resultListener = resultListener;
    }

    public void readFromDatabase(Context context){


        FirebaseDatabase mDatabase;
        mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference dataBaseReference = mDatabase.getReference();

        // Si quiero leer el toda la info. deberia eliminar el child de la datareference

        dataBaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ContainerFirebase dataBase = dataSnapshot.getValue(ContainerFirebase.class);
                List<Paints> unListPinturas = new ArrayList<Paints>();

                for (Artists unArtist: dataBase.getArtists()) {
                    for (Paints unaPintura: unArtist.getPaints()) {
                        unaPintura.setArtists(unArtist);
                        unListPinturas.add(unaPintura);
                    }
                }

                resultListener.finish(unListPinturas);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
