// Ethan Smith
// 3300 Android development
// Final exam
package com.example.finalapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class add_movie : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        var mname = findViewById<EditText>(R.id.addMovieName)
        var myear = findViewById<EditText>(R.id.addMovieYear)
        var mrating = findViewById<EditText>(R.id.AddMovieRating)
        var msummary = findViewById<EditText>(R.id.addMovieSummary)
        var db = FirebaseFirestore.getInstance()
        var found = false // checking if the movie is already in the db
        var bsave = findViewById<Button>(R.id.saveMovieButton)
        var bcancel = findViewById<Button>(R.id.cancelAddMovie)

        bcancel.setOnClickListener {
            finish()
        }
        bsave.setOnClickListener {
            // save the movie to the DB :)
            var movie: MutableMap<String, Any?> = HashMap()
            found = false //reset when the button is re-pressed
            var al = arrayListOf<Int>()
            al.add(mrating.text.toString().toInt()) // lol
            movie["Title"] = mname.text.toString()
            movie["Year"] = myear.text.toString()
            movie["Rating"] = al // as an array list we can add new reviews to this field
            movie["Summary"] = msummary.text.toString()
            db.collection("Movies").get().addOnCompleteListener { task ->
                for (document in task.result!!) {
                    println(document.data["Title"].toString() + " =====" + mname.text.toString())
                    if (document.data["Title"].toString() == mname.text.toString()) {
                        print("Found a duplicate :( ")
                        found = true
                    }
                }
                var alert = AlertDialog.Builder(this) // all the alert stuff is set a little lower :)
                if (!found) { // if the movie isn't in the db already, then we can add it :-)
                    db.collection("Movies").add(movie).addOnCompleteListener {
                        alert.setTitle("Movie added")
                        alert.setMessage("Movie was successfully added to the database!")
                        alert.setPositiveButton("great!", {dialogInterface: DialogInterface, i: Int -> finish()})
                        alert.show()
                    }.addOnFailureListener {
                        Toast.makeText(this,"Failed to add movie :( check your DB connection", Toast.LENGTH_SHORT).show()
                    }
                }else {
                    alert.setTitle("Duplicate found")
                    alert.setMessage("This movie is already in the DB, want to modify it, or just go back? ")
                    alert.setPositiveButton("Modify", {dialogInterface: DialogInterface, i: Int -> })
                    alert.setNegativeButton("return to dashboard", {dialogInterface: DialogInterface, i: Int -> finish()})
                    alert.show()
                }
            }

        }
    }
}