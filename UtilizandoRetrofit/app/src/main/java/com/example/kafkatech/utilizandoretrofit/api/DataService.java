package com.example.kafkatech.utilizandoretrofit.api;

import com.example.kafkatech.utilizandoretrofit.model.Photo;
import com.example.kafkatech.utilizandoretrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("/photos")
    public Call<List<Photo>> recuperarFotos();

    @GET("/posts")
    public Call<List<Post>> recuperarPostagens();


    //format json
    @POST("/posts")
    public Call<Post> salvarUmaPostagem(@Body Post post);

    //other types
    @FormUrlEncoded
    @POST("/posts")
    public Call<Post> salvarUmaPostagem(@Field("userId") String userId,
                                        @Field("title") String title,
                                        @Field("body") String body);

}
