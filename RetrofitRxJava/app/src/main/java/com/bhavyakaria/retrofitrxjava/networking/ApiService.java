package com.bhavyakaria.retrofitrxjava.networking;

import com.bhavyakaria.retrofitrxjava.models.ArticleResponseWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/v2/top-headlines")
    Observable<ArticleResponseWrapper> getHeadlines(
            @Query("apiKey") String apiKey,
            @Query("category") String category,
            @Query("country") String country
    );
}
