package digitalhouse.android.basededatosywebbaseintegrado.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.basededatosywebbaseintegrado.model.Post;
import digitalhouse.android.basededatosywebbaseintegrado.model.PostContainer;
import digitalhouse.android.basededatosywebbaseintegrado.util.HTTPConnectionManager;
import digitalhouse.android.basededatosywebbaseintegrado.util.ResultListener;


/**
 * Created by digitalhouse on 6/06/16.
 */
public class PostDAO extends SQLiteOpenHelper{

    //CONSTANTES PARA LOS NOMBRES DE LA BD Y LOS CAMPOS
    private static final String DATABASENAME = "PostDB";
    private static final Integer DATABASEVERSION = 1;

    //TABLA PERSONA CON SUS CAMPOS
    private static final String TABLEPOST = "Post";
    private static final String ID = "ID";
    private static final String TITLE = "title";
    private static final String BODY = "Body";

    //EL CONSTRUCTOR CREA LA BASE DE DATOS
    public PostDAO(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        //CREA LA ESTRUCTURA DE LA BASE DE DATOS, ES DECIR LA/LAS TABLA/S

        String createTable = "CREATE TABLE " + TABLEPOST + "("
                + ID + " INTEGER PRIMARY KEY, "
                + TITLE + " TEXT, "
                + BODY + " TEXT " + ")";

        database.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //CONSTRUIR UN METODO QUE AGREGUE UN POST A LA BASE DE DATOS
    public void addPostToDatabase(Post post){

        //PIDE UNA CONEXION DE ESCRITURA A LA BD
        SQLiteDatabase database = getWritableDatabase();

        //GENERA LA FILA DE LA TABLA
        ContentValues row = new ContentValues();

        //Obtengo los datos y los cargo en el row
        row.put(ID, post.getID());
        row.put(TITLE, post.getTitle());
        row.put(BODY, post.getBody());

        //INSERTA EN LA DATABASE EN LA TABLA POST LA FILA CREADA
        database.insert(TABLEPOST, null, row);

        database.close();

    }


    public List<Post> getAllPostFromDatabase(){

        SQLiteDatabase database = getReadableDatabase();

        List<Post> postList = new ArrayList<>();

        String select = "SELECT * FROM " + TABLEPOST;

        Cursor cursor = database.rawQuery(select, null);

        //MIENTRAS HAYA FILAS PARA LEER
        while(cursor.moveToNext()){

            //LEER AL POST
            Post post = new Post();
            post.setID(cursor.getString(cursor.getColumnIndex(ID)));
            post.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
            post.setBody(cursor.getString(cursor.getColumnIndex(BODY)));

            postList.add(post);
        }

        cursor.close();
        database.close();
        return postList;
    }

    //// CONEXION A INTERNET - NECESITA TAREA ASINCRONA


    public void getAllPostFromInternet(ResultListener<List<Post>> resultListenerFromController) {

        RetrievePostTask task = new RetrievePostTask(resultListenerFromController);
        task.execute();
    }

    //ESTA CLASE ES UNA CLASE QUE ME PERMITE GENERAR UNA TAREA ASINCRONICA. ES DECIR, ESTA TAREA SE EJECUTARA
// INDEPENDIENTEMENTE DE LO QUE ESTE HACIENDO COMO ACTIVIDAD PRINCIPAL
    private class RetrievePostTask extends AsyncTask<String, Void, List<Post>> {

        private ResultListener listenerFromCrontroller;

        public RetrievePostTask(ResultListener listenerFromCrontroller) {
            this.listenerFromCrontroller = listenerFromCrontroller;
        }

        @Override
        protected List<Post> doInBackground(String... strings) {
            HTTPConnectionManager connectionManager = new HTTPConnectionManager();

            PostContainer postContainer = null;
            try {
                InputStream input = connectionManager.getRequestStream("https://api.myjson.com/bins/2haa3");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
                Gson gson = new Gson();
                postContainer = gson.fromJson(bufferedReader, PostContainer.class);

            } catch (Exception e) {
                e.printStackTrace();
            }

            //AGREGAMOS LOS POST A LA BASE DE DATOS
            addAllPostsToDatabase(postContainer.getResults());
            return postContainer.getResults();
        }


        @Override
        protected void onPostExecute(List<Post> posts) {
            //ESTA FUNCION SE EJECUTA CUANDO TERMINO LA TAREA EN SEGUNDO PLANO
            listenerFromCrontroller.finish(posts);
        }
    }

    private void addAllPostsToDatabase(List<Post> posts) {
        for(Post post : posts){
            addPostToDatabase(post);
        }
    }
}




















