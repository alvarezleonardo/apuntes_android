package com.example.leonardo.momadh.controller;

import android.content.Context;

import com.example.leonardo.momadh.dao.DAOartist;
import com.example.leonardo.momadh.model.Artists;
import com.example.leonardo.momadh.model.Paints;
import com.example.leonardo.momadh.model.ResultListener;
import com.example.leonardo.momadh.view.ListadoActivity;

import java.util.List;

/**
 * Created by leona on 29/11/2016.
 */

public class ArtistControler {
    public static void getAllArtist(Context context, ResultListener<List<Paints>> resultListener) {
        DAOartist daoArtist = new DAOartist(resultListener);
        daoArtist.readFromDatabase(context);
    }
}
