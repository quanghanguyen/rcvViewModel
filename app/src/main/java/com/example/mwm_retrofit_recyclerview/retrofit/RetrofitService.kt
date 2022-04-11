package com.example.mwm_retrofit_recyclerview.retrofit

import com.example.mwm_retrofit_recyclerview.model.Team
import com.example.mwm_retrofit_recyclerview.model.TeamsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService {

    // https://api.football-data.org/v2/competitions/2021/teams

    @get:GET("v2/competitions/2021/teams")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")
    val getDataFromAPI : Call<TeamsData>

}