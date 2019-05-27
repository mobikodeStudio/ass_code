package com.example.myapplication.networking;


import com.example.myapplication.model.ArticlePojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticleApi {
    @GET("7.json")
    Call<ArticlePojo> getNewsList(@Query("api-key") String apiKey);
}
