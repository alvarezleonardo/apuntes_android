package com.ejemplo.album.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ejemplo.album.R;
import com.ejemplo.album.model.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leona on 6/11/2016.
 */

public class AdapterTrack extends RecyclerView.Adapter {

    private List<Track> trackList;
    private Context context;
    private View.OnClickListener listener;

    public AdapterTrack(Context context, View.OnClickListener listener) {
        this.context = context;
        this.trackList = new ArrayList<>();
        this.listener = listener;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View unaView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycledviewtrack, parent, false);
        TrackViewHolder unTackVHolder = new TrackViewHolder(unaView);
        unaView.setOnClickListener(listener);
        return unTackVHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Track track = trackList.get(position);
        TrackViewHolder unTackVHolder = (TrackViewHolder) holder;
        unTackVHolder.bindProduct(track, context);
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public Track getTrackAtPosition(Integer posicionTocada) {
        return trackList.get(posicionTocada);
    }

    private static class TrackViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewTitulo;
        private ImageView imageViewThumbnail;

        public TrackViewHolder(View itemView) {
            super(itemView);
            textViewTitulo = (TextView) itemView.findViewById(R.id.textViewTitulo);
            imageViewThumbnail = (ImageView) itemView.findViewById(R.id.imagenChica);
        }

        public void bindProduct(Track track, Context context){
            textViewTitulo.setText(track.getTitle());
            Glide.with(context).load(track.getPictureThumbnailUrl()).error(R.drawable.auricular).into(imageViewThumbnail);
        }
    }


}
