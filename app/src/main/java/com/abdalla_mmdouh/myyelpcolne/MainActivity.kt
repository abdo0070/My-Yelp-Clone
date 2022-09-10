package com.abdalla_mmdouh.myyelpcolne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    companion object{
        private const val BASE_URL = "https://api.yelp.com/v3/"
        private const val TAG = "MainActivity"
        private const val API_KEY = "wOTXVyWPC9FzWcflo_9rcMf0czLgeNhG9Bjcz5-mjxYABLShM8tmSITSsPFa2ovtMrot2qztiNo6mvVhtl1z-Ayi34AJU4e7426gdsYQ_2q4smV7ihtzkMKM-mMaY3Yx"
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var restaurants = mutableListOf<YelpSearchResult>()
       val adapter = RestaurantsAdapter(this,restaurants)
        rvRestaurants.layoutManager = LinearLayoutManager(this)
        rvRestaurants.adapter = adapter
        // API
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory((GsonConverterFactory.create())).build()
        val yelpServer = retrofit.create(YelpApi::class.java)
        yelpServer.searchRestaurants("Bearer $API_KEY","Avocado Toast","New York")
            .enqueue(object : Callback<YelpSearchResult>{
                override fun onResponse(call: Call<YelpSearchResult>, response: Response<YelpSearchResult>) {
                    // Update The List
                   val body = response.body()
                    if (body == null){
                        Log.w(TAG , "Failed to load the restaurants ...")
                        return
                    }
                    restaurants.addAll(body.restaurant)
                    adapter.notifyDataSetChanged()
                }
            override fun onFailure(call: Call<YelpSearchResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
            })
    }
}
