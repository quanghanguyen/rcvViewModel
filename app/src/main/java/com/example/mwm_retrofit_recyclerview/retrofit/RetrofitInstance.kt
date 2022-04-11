package com.example.mwm_retrofit_recyclerview.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    // https://api.football-data.org/v2/competitions/2021/teams

    companion object {
        var BASE_URL : String = "https://api.football-data.org/"
        fun getRetroInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}