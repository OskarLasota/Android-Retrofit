package com.example.retrofit.Models.api;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET
    Call<ApiResult> getImages(@Url String url);


    //jsonplaceholder.typicode.com/posts
    @GET("posts")
    Call<List<ApiResult>> getPosts(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );

    @GET("posts")
    Call<List<ApiResult>> getPosts(@QueryMap Map<String, String> parameters);

    @GET("posts/{id}/comments")
    Call<List<ApiResult>> getComments(@Path("id")Integer postid);

    @GET
    Call<List<ApiResult>> getComments(@Url String url);

}
