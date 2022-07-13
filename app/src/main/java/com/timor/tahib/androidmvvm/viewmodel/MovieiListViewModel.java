package com.timor.tahib.androidmvvm.viewmodel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.timor.tahib.androidmvvm.model.ModelResponce;
import com.timor.tahib.androidmvvm.network.APIService;
import com.timor.tahib.androidmvvm.network.RetrofitInstnace;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieiListViewModel extends ViewModel {


    private MutableLiveData<ModelResponce> movielist;

    public MovieiListViewModel() {

        movielist = new MutableLiveData<ModelResponce>();
    }

    public MutableLiveData<ModelResponce> getMovielistObserve() {
        return movielist;
    }

    public void makeApiCall() {

        APIService apiService = RetrofitInstnace.getRetrofitClient().create(APIService.class);
        Call<ModelResponce> call = apiService.getmovie();
        call.enqueue(new Callback<ModelResponce>() {
            @Override
            public void onResponse(Call<ModelResponce> call, Response<ModelResponce> response) {
                movielist.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ModelResponce> call, Throwable t) {
                movielist.postValue(null);

            }
        });

    }
}
