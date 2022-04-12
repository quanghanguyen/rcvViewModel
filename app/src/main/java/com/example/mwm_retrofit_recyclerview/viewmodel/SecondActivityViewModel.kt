package com.example.mwm_retrofit_recyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mwm_retrofit_recyclerview.model2.MainSecondModel
import com.example.mwm_retrofit_recyclerview.retrofit.RetrofitInstance
import com.example.mwm_retrofit_recyclerview.retrofit.RetrofitService2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivityViewModel : ViewModel() {

    lateinit var lstSecond : MutableLiveData<MainSecondModel?>

    init {
        lstSecond = MutableLiveData()
    }

    fun getMainSeconDataObserver() : MutableLiveData<MainSecondModel?> {
        return lstSecond
    }

    fun mainAPICall() {
        val mainData = RetrofitInstance.getRetroInstance().create(RetrofitService2::class.java)
        val call2 = mainData.getSecondData

        call2.enqueue(object : Callback<MainSecondModel?> {
            override fun onResponse(
                call: Call<MainSecondModel?>,
                response: Response<MainSecondModel?>
            ) {
                    if (response.isSuccessful){
                        lstSecond.postValue(response.body())
                    } else {
                        lstSecond.postValue(null)
                    }
            }

            override fun onFailure(call: Call<MainSecondModel?>, t: Throwable) {
                lstSecond.postValue(null)
            }
        })
    }

}