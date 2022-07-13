package com.timor.tahib.androidmvvm.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstnace {


    public static String BASE_URL="https://tagcha-katab.ir/PoraanictProject/movie/";

    public static  Retrofit retrofit;

   public  static Retrofit getRetrofitClient(){
       if (retrofit ==null){
           retrofit=new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
       return  retrofit;
   }

}
