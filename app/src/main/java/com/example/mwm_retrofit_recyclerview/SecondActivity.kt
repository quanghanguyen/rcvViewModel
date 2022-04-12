package com.example.mwm_retrofit_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mwm_retrofit_recyclerview.databinding.ActivitySecondBinding
import com.example.mwm_retrofit_recyclerview.model2.MainSecondModel
import com.example.mwm_retrofit_recyclerview.viewmodel.SecondActivityViewModel

private lateinit var binding: ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.hide()

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

        callData()
    }

    private fun callData() {
        val viewModel2 = ViewModelProviders.of(this).get(SecondActivityViewModel::class.java)
        viewModel2.getMainSeconDataObserver().observe(this, Observer<MainSecondModel?>{
            if (it != null) {
                binding.tv1.text = it.emblemUrl
                binding.tv2.text = it.name
            }
        })

        viewModel2.mainAPICall()
    }
}