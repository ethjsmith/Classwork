// Ethan Smith
// 3300 Android development
// Final exam
package com.example.finalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.w3c.dom.Text

class movie_info : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_info)

        var mname = findViewById<TextView>(R.id.movieName_InfoPage)
        var myear = findViewById<TextView>(R.id.movieYear_InfoPage)
        var mrate = findViewById<TextView>(R.id.movieRating_infoPage)
        var msummary = findViewById<TextView>(R.id.movieSummary_InfoPage)

        var db = FirebaseFirestore.getInstance()


        var brate = findViewById<Button>(R.id.rateButton_InfoPage)
        var bback = findViewById<Button>(R.id.back_movieInfo)

        db.collection("Movies").get().addOnCompleteListener {task->
            println("checking if its in movies :)")
            if (task.isSuccessful) {
                for (document in task.result!!) {
                    if (document.data["Title"]!!.equals(intent.getStringExtra("Title"))) {
                        mname.setText("Movie: " + document.data["Title"].toString())
                        myear.setText("Year: " + document.data["Year"].toString())
                        var rating = document.data["Rating"] as Collection<Int>
                        var z = rating.average()
                        mrate.setText("Average rating: " + z.toString())
                        msummary.setText("Description: " + document.data["Summary"].toString())

                    }
                }
            }
        }


        bback.setOnClickListener {
            var i = Intent(this, dashboard::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) // trying this to redirect to A without breaking all my other back buttons...
            startActivity(i)
        }

        brate.setOnClickListener {
            //submit the rating
            var i2 = Intent(this,rate_movie::class.java)
            i2.putExtra("Title",intent.getStringExtra("Title")) // pass it along lol
            startActivity(i2) // hopefully this works but I don't think it does
        }
    }
}