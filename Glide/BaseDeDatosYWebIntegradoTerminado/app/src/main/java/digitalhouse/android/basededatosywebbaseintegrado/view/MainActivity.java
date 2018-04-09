package digitalhouse.android.basededatosywebbaseintegrado.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import digitalhouse.android.basededatosywebbaseintegrado.R;
import digitalhouse.android.basededatosywebbaseintegrado.controller.PostController;
import digitalhouse.android.basededatosywebbaseintegrado.model.Post;
import digitalhouse.android.basededatosywebbaseintegrado.util.ResultListener;

public class MainActivity extends AppCompatActivity {

    //Declaro todas estas variables como globales ya que las voy a usar a lo largo de la clase.
    private RecyclerView recyclerView;
    private AdapterPost adapterPost;
    private PostController postController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Seteo el contexto y obtengo el recyclerView y el SwipeRefreshLayout
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //Seteo el adapter y los elementos del recyclerView
        adapterPost = new AdapterPost(this);
        recyclerView.setAdapter(adapterPost);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        //Instancio el PostController que me va a devolver todos los posts
        postController = new PostController();

        //Este metodo va a pedirle al postcontroller que busque los posts y tambien actualizar el adaptador del recyclerView
        postController.getAllPost(this, new ResultListener<List<Post>>() {
            @Override
            public void finish(List<Post> resultado) {
                adapterPost.setPostList(resultado);
                adapterPost.notifyDataSetChanged();
            }
        });
    }
}
















