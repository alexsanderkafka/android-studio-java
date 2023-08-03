package com.example.kafkatech.utilizandoretrofit.api;

import com.example.kafkatech.utilizandoretrofit.model.Photo;
import com.example.kafkatech.utilizandoretrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("/photos")
    public Call<List<Photo>> recuperarFotos();

    @GET("/posts")
    public Call<List<Post>> recuperarPostagens();
}
