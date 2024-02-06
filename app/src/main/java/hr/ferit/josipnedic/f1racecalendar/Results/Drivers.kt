package hr.ferit.josipnedic.f1racecalendar.Results

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DriversViewModel: ViewModel() {
    val db = Firebase.firestore
    val driversData = mutableStateListOf<Driver>()
    init {
        fetchDatabaseData()
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
}