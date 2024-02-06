package hr.ferit.josipnedic.f1racecalendar.Racing

import androidx.annotation.DrawableRes

data class F1Race(
    @DrawableRes val image : Int,
    @DrawableRes val layout : Int,
    val id: Int,
    val name: String,
    val date: String,
    val location: String = "Bahrein",
    val training1Time: String,
    val training2Time: String,
    val training3Time: String,
    val qualyTime: String,
    val raceTime: String
)