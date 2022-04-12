package com.example.mwm_retrofit_recyclerview.retrofit

import com.example.mwm_retrofit_recyclerview.model2.MainSecondModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService2 {

    // https://api.football-data.org/v2/competitions/2021

    @get:GET("v2/competitions/2021")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")
    val getSecondData : Call<MainSecondModel>

}