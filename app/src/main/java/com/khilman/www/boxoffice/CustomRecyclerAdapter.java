package com.khilman.www.boxoffice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khilman.www.boxoffice.Responses.ResultsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by root on 10/29/17.
 */

class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {
    Context context;
    List<ResultsItem> data_movie;

    public CustomRecyclerAdapter(Context context, List<ResultsItem> data_movie) {
        this.context = context;
        this.data_movie = data_movie;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // ubah widget
        holder.movie_title.setText(data_movie.get(position).getTitle());
        holder.movie_desc.setText(data_movie.get(position).getOverview());

        String image_server = "http://image.tmdb.org/t/p/w185/" + data_movie.get(position).getPosterPath();

        Picasso.with(context).load(image_server).into(holder.poster_image);
    }

    @Override
    public int getItemCount() {
        return data_movie.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView poster_image;
        TextView movie_title, movie_desc;
        public MyViewHolder(View itemView) {
            super(itemView);
            poster_image = (ImageView) itemView.findViewById(R.id.poster_movie);
            movie_title = (TextView) itemView.findViewById(R.id.title_movie);
            movie_desc = (TextView) itemView.findViewById(R.id.desc_movie);

        }
    }
}
