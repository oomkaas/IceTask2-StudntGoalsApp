package com.example.icetask2_goalsapp.model

data class Goal(
    val id: Int,
    val title: String,
    val description: String,
    var isCompleted: Boolean= false
)