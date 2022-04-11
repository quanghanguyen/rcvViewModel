package com.example.mwm_retrofit_recyclerview.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwm_retrofit_recyclerview.model.Team
import com.example.mwm_retrofit_recyclerview.model.TeamsData
import com.example.mwm_retrofit_recyclerview.retrofit.RetrofitInstance
import com.example.mwm_retrofit_recyclerview.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivityViewModel : ViewModel() {

    lateinit var lstTeams : MutableLiveData<TeamsData?>

    init {
        lstTeams = MutableLiveData()
    }

    fun getTeamsListDataObserver() : MutableLiveData<TeamsData?>{
        return lstTeams
    }

    fun makeAPIcall() {
        val retrofitInstance = RetrofitInstance.getRetroInstance().create(RetrofitService::class.java)
        val call = retrofitInstance.getDataFromAPI
        call.enqueue(object : Callback<TeamsData?> {
            override fun onResponse(call: Call<TeamsData?>, response: Response<TeamsData?>) {
                if (response.isSuccessful){
//                    val teams = response.body()!!.teams

//                    for (teams1 in teams){
//                        Log.e(TAG, "onResponse: " + teams1.address)
//                    }
                    //recyclerViewAdapter.setListData(teams as ArrayList<Team>)
//                    lstTeams!!.addAll(teams)
                    //recyclerViewAdapter!!.notifyDataSetChanged()

                    lstTeams.postValue(response.body())
                } else {
                    lstTeams.postValue(null)
                }
            }

            override fun onFailure(call: Call<TeamsData?>, t: Throwable) {
                //Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                lstTeams.postValue(null)
            }
        })
    }

}