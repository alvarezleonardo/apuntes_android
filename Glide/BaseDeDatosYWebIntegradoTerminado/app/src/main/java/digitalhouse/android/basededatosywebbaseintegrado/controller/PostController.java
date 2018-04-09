package digitalhouse.android.basededatosywebbaseintegrado.controller;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import digitalhouse.android.basededatosywebbaseintegrado.dao.PostDAO;
import digitalhouse.android.basededatosywebbaseintegrado.model.Post;
import digitalhouse.android.basededatosywebbaseintegrado.util.HTTPConnectionManager;
import digitalhouse.android.basededatosywebbaseintegrado.util.ResultListener;

/**
 * Created by digitalhouse on 6/06/16.
 */
public class PostController {

    public void getAllPost(final Context context, final ResultListener<List<Post>> resultListenerFromView) {

        PostDAO postDAO = new PostDAO(context);

        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            postDAO.getAllPostFromInternet(new ResultListener<List<Post>>() {
                @Override
                public void finish(List<Post> resultado) {
                    //QUE HACE EL CONTROLLER CUANDO RECIBE LA LISTA DE POST
                    resultListenerFromView.finish(resultado);
                    Toast.makeText(context, "Internet", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            List<Post> postList = postDAO.getAllPostFromDatabase();
            resultListenerFromView.finish(postList);
            Toast.makeText(context, "Base de datos", Toast.LENGTH_SHORT).show();
        }
    }
}
