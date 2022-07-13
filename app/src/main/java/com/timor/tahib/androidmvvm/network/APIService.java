package com.timor.tahib.androidmvvm.network;

import com.timor.tahib.androidmvvm.model.ModelResponce;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("moview.json")
    Call<ModelResponce> getmovie();
}
