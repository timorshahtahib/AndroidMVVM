package com.timor.tahib.androidmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.timor.tahib.androidmvvm.Adaptres.MovieListAdapter;
import com.timor.tahib.androidmvvm.model.ModelResponce;
import com.timor.tahib.androidmvvm.model.MovieModel;
import com.timor.tahib.androidmvvm.viewmodel.MovieiListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements MovieListAdapter.ItemListener {
private List<MovieModel> modelList;
private  MovieListAdapter  adapter;

private MovieiListViewModel  viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
          adapter=new MovieListAdapter(this,modelList,this);
        recyclerView.setAdapter(adapter);

        viewModel= ViewModelProviders.of(this).get(MovieiListViewModel.class);
        viewModel.getMovielistObserve().observe(this, new Observer<ModelResponce>() {
            @Override
            public void onChanged(ModelResponce modelResponce) {
                 if (modelResponce!=null){
                     modelList=modelResponce.data;
                     adapter.setMovieModelList(modelResponce.data );
                 }else {
                     Toast.makeText(MainActivity.this, "No result ", Toast.LENGTH_SHORT).show();
                 }
            }
        });
        viewModel.makeApiCall();
    }

    @Override
    public void onMoiveClick(MovieModel movieModel) {

        Toast.makeText(this, ""+movieModel.getTitle(), Toast.LENGTH_SHORT).show();

    }
}