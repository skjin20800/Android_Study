package com.jkb.movieproject;

import java.util.List;

import lombok.experimental.Delegate;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface MoviePostApi {


    @GET("list")
    Call<List<Movie>> getPosts(); // Call은 에러발생시 컨트롤 가능

    @DELETE("{id}")
    Call<Void> deletePost(@Path("id") int id);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.56.1:8000/api/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}