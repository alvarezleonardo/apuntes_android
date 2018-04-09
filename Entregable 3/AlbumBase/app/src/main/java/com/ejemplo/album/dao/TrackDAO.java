package com.ejemplo.album.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

import com.ejemplo.album.model.Contenedor_track;
import com.ejemplo.album.model.Track;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import util.HTTPConnectionManager;
import util.ResultListener;

/**
 * Created by leona on 5/11/2016.
 */

public class TrackDAO extends SQLiteOpenHelper {

    private static final String DATABASENAME = "TrackDB";
    private static final Integer DATABASEVERSION = 1;

    private static final String TABLETRACK = "Track";
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String ALBUMID = "albumId";
    private static final String URLPICTURE = "urlPicture";
    private static final String URLPICTURETH = "urlPictureTh";


    public TrackDAO(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLETRACK + "("
                + ID + " INTEGER PRIMARY KEY, "
                + TITLE + " TEXT, "
                + ALBUMID + " INTEGER, "
                + URLPICTURE + " TEXT, "
                + URLPICTURETH + " TEXT )";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void AgregarTrack (Track track){

        if(ExisteTrack(track) == true) {
            SQLiteDatabase dbLite = getWritableDatabase();
            ContentValues row = new ContentValues();

            row.put(ID, track.getId());
            row.put(ALBUMID, track.getAlbumId());
            row.put(TITLE, track.getTitle());
            row.put(URLPICTURE, track.getPictureUrl());
            row.put(URLPICTURETH, track.getPictureThumbnailUrl());

            dbLite.insert(TABLETRACK, null, row);

            dbLite.close();
        }
    }

    public Boolean ExisteTrack(Track unTrack){
        Boolean existe = true;
        SQLiteDatabase database = getReadableDatabase();
        List<Track> trackList = new ArrayList<>();
        String select = "SELECT * FROM " + TABLETRACK + " where id = " + unTrack.getId();
        Cursor cursor = database.rawQuery(select, null);
        if(cursor.getCount()==0){
            existe = false;
        }

        return existe;
    }

    public List<Track> getAllTrackFromDatabase(){
        List<Track> trackList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();

        String select = "SELECT * FROM " + TABLETRACK;

        Cursor cursor = database.rawQuery(select, null);

        while(cursor.moveToNext()){
            Track track = new Track();
            track.setId(cursor.getInt(cursor.getColumnIndex(ID)));
            track.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
            track.setAlbumId(cursor.getInt(cursor.getColumnIndex(ALBUMID)));
            track.setPictureUrl(cursor.getString(cursor.getColumnIndex(URLPICTURE)));
            track.setPictureThumbnailUrl(cursor.getString(cursor.getColumnIndex(URLPICTURETH)));
            trackList.add(track);
        }

        cursor.close();
        database.close();
        return trackList;
    }


    public void getTrackFromInternet(ResultListener<List<Track>> resultListenerFromController) {

        GetAsyncTrack task = new GetAsyncTrack(resultListenerFromController);
        task.execute();
    }

     private class GetAsyncTrack extends AsyncTask<String, Void, List<Track>> {

        private ResultListener listenerFromCrontroller;

        public GetAsyncTrack(ResultListener listenerFromCrontroller) {
            this.listenerFromCrontroller = listenerFromCrontroller;
        }

        @Override
        protected List<Track> doInBackground(String... strings) {
            HTTPConnectionManager connectionManager = new HTTPConnectionManager();

            Contenedor_track trackContainer = null;
            try {
                InputStream input = connectionManager.getRequestStream("https://api.myjson.com/bins/25hip");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
                Gson gson = new Gson();
                trackContainer = gson.fromJson(bufferedReader, Contenedor_track.class);

            } catch (Exception e) {
                e.printStackTrace();
            }

            addAllTracksToDatabase(trackContainer.getResults());
            return trackContainer.getResults();
        }


        @Override
        protected void onPostExecute(List<Track> tracks) {
            //ESTA FUNCION SE EJECUTA CUANDO TERMINO LA TAREA EN SEGUNDO PLANO
            listenerFromCrontroller.finish(tracks);
        }
    }

    private void addAllTracksToDatabase(List<Track> tracks) {
        for(Track track : tracks){
            AgregarTrack(track);
        }
    }
}
