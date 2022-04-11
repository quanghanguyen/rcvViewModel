package com.example.mwm_retrofit_recyclerview.model

data class TeamsData(
    val competition: Competition,
    val count: Int,
    val filters: Filters,
    val season: Season,
    val teams: List<Team>
)