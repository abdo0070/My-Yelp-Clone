package com.abdalla_mmdouh.myyelpcolne

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

public interface YelpApi {
    @GET("businesses/search")
    fun searchRestaurants(
        @Header("Authorization")Authorization:String,
        @Query("term") searchTerm : String,
        @Query("location") location:String ) : Call<YelpSearchResult>
}