package com.example.postretrofitcallapi.api;

import static com.example.postretrofitcallapi.utils.Config.BASE_URL;

import com.example.postretrofitcallapi.model.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd-HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
// https://jsonplaceholder.typicode.com/posts

    @POST("posts")
    Call<Post> sendPost(@Body Post post);

}
