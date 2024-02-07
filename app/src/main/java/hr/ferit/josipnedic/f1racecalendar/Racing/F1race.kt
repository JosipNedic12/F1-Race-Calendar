package hr.ferit.josipnedic.f1racecalendar.Racing

import com.google.firebase.Timestamp

data class F1Race(
    val image : String = "",
    val layout : String = "",
    var id: Int = 0,
    val name: String = "",
    val date: String = "",
    val location: String = "",
    val training1Time: Timestamp = Timestamp.now(),
    val training2Time: Timestamp = Timestamp.now(),
    val training3Time: Timestamp = Timestamp.now(),
    val qualyTime: Timestamp = Timestamp.now(),
    val raceTime: Timestamp = Timestamp.now(),
    val results: List<String> = listOf()
)