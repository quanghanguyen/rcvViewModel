package com.example.mwm_retrofit_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mwm_retrofit_recyclerview.model.Team
import com.example.mwm_retrofit_recyclerview.model.TeamsData
import kotlinx.android.synthetic.main.list_teams.view.*
import java.util.ArrayList

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items = ArrayList<Team>()

    fun setListData(data : ArrayList<Team>) {
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_teams, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val tvTeams = view.tvTeams
        val civTeams = view.civTeams

        fun bind(data : Team) {

            tvTeams.text = data.name
            Glide.with(civTeams)
                .load(data.crestUrl)
                .into(civTeams)

        }
    }
}