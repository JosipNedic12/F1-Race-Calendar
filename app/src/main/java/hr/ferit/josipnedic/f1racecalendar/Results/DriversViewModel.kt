package hr.ferit.josipnedic.f1racecalendar.Results

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import hr.ferit.josipnedic.f1racecalendar.Racing.F1Race

class DriversViewModel: ViewModel() {
    val db = Firebase.firestore
    val driversData = mutableStateListOf<Driver>()
    val racesData = mutableStateListOf<F1Race>()

    init {
        fetchDatabaseData()
        fetchRaceDatabaseData()
    }

    private fun fetchDatabaseData() {
        db.collection("Drivers")
            .get()
            .addOnSuccessListener { result ->
                this.fillDriver(result)
            }
    }

    private fun fillDriver(result: QuerySnapshot) {
        Log.d("FirestoreSuccess", "${result.documents.count()}")

        for (data in result.documents) {
            Log.d("FirestoreSuccess!!", "${data.id}")

            val driver = data.toObject(Driver::class.java)
            if (driver != null) {
                driver.id = data.id
                driversData.add(driver)
            }
        }
    }

    private fun fetchRaceDatabaseData() {
        db.collection("Races")
            .orderBy("id")
            .get()
            .addOnSuccessListener { result ->
                this.fillRace(result)
            }
    }

    private fun fillRace(result: QuerySnapshot) {
        Log.d("FirestoreSuccess", "${result.documents.count()}")

        for (data in result.documents) {
            Log.d("FirestoreSuccess!!", "${data.id}")

            val race = data.toObject(F1Race::class.java)
            if (race != null) {
                race.id = data.id.toInt() - 1
                racesData.add(race)
            }
        }
    }

    fun saveRaceResultToFirestore(raceId: String, raceResult: List<String>) {
        val db = Firebase.firestore
        val raceResultsCollection = db.collection("Races")
        val raceResultDocument = raceResultsCollection.document(raceId)
        raceResultDocument
            .update("results", raceResult)
            .addOnSuccessListener {
                // Race result array updated successfully
                println("Race result array updated successfully")
            }
            .addOnFailureListener { e ->
                // Error updating race result array
                println("Error updating race result array: $e")
            }
    }
}

