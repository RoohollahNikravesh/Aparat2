package com.example.aparat2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aparat2.R;
import com.example.aparat2.models.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {
    List<Video>videoList;
    Context context;
    public VideosAdapter(Context context, List<Video>videoList){
        this.context=context;
        this.videoList=videoList;
    }
    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.video_row,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  VideosAdapter.ViewHolder holder, int position) {
Video video=videoList.get(position);
holder.txt_card.setText(video.getTitle());
        Picasso.get().load(video.getIcon()).into(holder.img_card);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView img_card;
        AppCompatTextView txt_card;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            img_card=itemView.findViewById(R.id.img_card_newVideo);
            txt_card=itemView.findViewById(R.id.txt_card_title);
        }
    }


}
