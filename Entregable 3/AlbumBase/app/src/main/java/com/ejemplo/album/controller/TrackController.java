package com.ejemplo.album.controller;

import android.content.Context;
import android.widget.Toast;

import com.ejemplo.album.dao.TrackDAO;
import com.ejemplo.album.model.Track;
import com.ejemplo.album.view.MainActivity;

import java.util.List;

import util.HTTPConnectionManager;
import util.ResultListener;

/**
 * Created by leona on 5/11/2016.
 */

public class TrackController {
    public List<Track> GetTrack(){
        return null;
    }

    public void getAllTrack(final Context context, final ResultListener<List<Track>> resultListenerFromView) {
        TrackDAO trackDAO = new TrackDAO(context);

        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            trackDAO.getTrackFromInternet(new ResultListener<List<Track>>() {
                @Override
                public void finish(List<Track> resultado) {
                    //QUE HACE EL CONTROLLER CUANDO RECIBE LA LISTA DE POST
                    resultListenerFromView.finish(resultado);

                }
            });
        }
        else{
            List<Track> postList = trackDAO.getAllTrackFromDatabase();
            resultListenerFromView.finish(postList);

        }
    }
}
