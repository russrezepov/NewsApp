package com.russrezepov.newsapp;

import com.russrezepov.newsapp.Model.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top_headlines")
    Call<Headlines> getHeadlines (
        @Query("country") String country,
        @Query("apiKey") String apiKey

    );
}
