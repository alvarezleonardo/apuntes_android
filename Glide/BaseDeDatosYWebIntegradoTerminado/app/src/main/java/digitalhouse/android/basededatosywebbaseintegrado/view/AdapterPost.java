package digitalhouse.android.basededatosywebbaseintegrado.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.basededatosywebbaseintegrado.R;
import digitalhouse.android.basededatosywebbaseintegrado.model.Post;

/**
 * Created by andres on 22/06/16.
 */
public class AdapterPost extends RecyclerView.Adapter{

    private List<Post> productList;
    private Context context;

    public AdapterPost(Context context) {

        this.context = context;
        this.productList = new ArrayList<>();
    }

    public void setPostList(List<Post> productList) {
        this.productList = productList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_detalle, parent, false);
        ProductViewHolder unTrackViewHolder = new ProductViewHolder(itemView);
        return unTrackViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Post aProduct = productList.get(position);
        ProductViewHolder unTitularViewHolder = (ProductViewHolder) holder;
        unTitularViewHolder.bindProduct(aProduct, context);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    private static class ProductViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewTitulo;
        private TextView textViewBody;
        private ImageView imageViewThumbnail;

        public ProductViewHolder(View itemView) {
            super(itemView);
            textViewTitulo = (TextView) itemView.findViewById(R.id.textViewTitulo);
            textViewBody = (TextView) itemView.findViewById(R.id.textViewBody);
            imageViewThumbnail = (ImageView) itemView.findViewById(R.id.imageViewThumbnail);
        }

        public void bindProduct(Post aProduct, Context context){
            textViewTitulo.setText(aProduct.getTitle());
            textViewBody.setText(aProduct.getBody());
            //Glide.with(context).load("https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/2000px-User_icon_2.svg.png").error(R.drawable.offlineuser).into(imageViewThumbnail);
        }
    }
}
