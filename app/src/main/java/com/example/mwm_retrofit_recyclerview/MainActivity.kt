package com.example.mwm_retrofit_recyclerview

import android.graphics.drawable.ClipDrawable.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mwm_retrofit_recyclerview.model.Team
import com.example.mwm_retrofit_recyclerview.model.TeamsData
import com.example.mwm_retrofit_recyclerview.retrofit.RetrofitInstance
import com.example.mwm_retrofit_recyclerview.retrofit.RetrofitService
import com.example.mwm_retrofit_recyclerview.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
//    lateinit var lstTeams : MutableList<Team>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

//        lstTeams = ArrayList<Team>()

        initRecyclerView()
        createData()
    }

    private fun createData() {

        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.getTeamsListDataObserver().observe(this, Observer<TeamsData?>{
            if (it != null) {

                recyclerViewAdapter.setListData(it.teams as ArrayList<Team>)
                recyclerViewAdapter.notifyDataSetChanged()

            } else {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.makeAPIcall()

//        val item = ArrayList<RecyclerData>()
//
//        item.add(RecyclerData("MU", "22222222222222222222"))
//        item.add(RecyclerData("MC", "22222222222222222222"))
//        item.add(RecyclerData("LP", "22222222222222222222"))
//
//        recyclerViewAdapter.setListData(item)
//        recyclerViewAdapter.notifyDataSetChanged()

//        val retrofitInstance = RetrofitInstance.getRetroInstance().create(RetrofitService::class.java)
//        val call = retrofitInstance.getDataFromAPI
//        call.enqueue(object : Callback<TeamsData?> {
//            override fun onResponse(call: Call<TeamsData?>, response: Response<TeamsData?>) {
//                if (response.isSuccessful){
//                    val teams = response.body()!!.teams
//
////                    for (teams1 in teams){
////                        Log.e(TAG, "onResponse: " + teams1.address)
////                    }
//                    recyclerViewAdapter.setListData(teams as ArrayList<Team>)
////                    lstTeams!!.addAll(teams)
//                    recyclerViewAdapter!!.notifyDataSetChanged()
//                }
//            }
//
//            override fun onFailure(call: Call<TeamsData?>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
//            }
//        })
    }

    private fun initRecyclerView() {
        rcvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

            //val decoration = DividerItemDecoration(applicationContext, VERTICAL)

        }
    }

    companion object {
        private const val TAG = "TeamsFragment"
    }
}