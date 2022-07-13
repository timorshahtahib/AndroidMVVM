package com.timor.tahib.androidmvvm.Adaptres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.timor.tahib.androidmvvm.R;
import com.timor.tahib.androidmvvm.model.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHoldre> {

    public Context context;
    public List<MovieModel> movieModelList;
    public  ItemListener itemListener;

    public MovieListAdapter(Context context, List<MovieModel> movieModelList,ItemListener itemListener) {
        this.context = context;
        this.movieModelList = movieModelList;
        this.itemListener=itemListener;
    }

    public void setMovieModelList(List<MovieModel> movieModelList) {
        this.movieModelList = movieModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHoldre onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHoldre(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoldre holder, int position) {

        MovieModel movieModel=movieModelList.get(position);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemListener.onMoiveClick(movieModel);
            }
        });
        holder.txt_title.setText(movieModel.getTitle());

        Glide.with(context).load(movieModel.getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        if (movieModelList != null) {
            return movieModelList.size();
        }
        return 0;
    }

    public class MyViewHoldre extends RecyclerView.ViewHolder {
        TextView txt_title;
        ImageView imageView;

        public MyViewHoldre(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }


    public interface ItemListener {

        public void onMoiveClick(MovieModel movieModel);
    }
}
