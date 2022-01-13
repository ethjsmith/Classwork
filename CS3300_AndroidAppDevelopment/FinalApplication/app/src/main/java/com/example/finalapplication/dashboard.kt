// Ethan Smith
// 3300 Android development
// Final exam
package com.example.finalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class dashboard : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var uname = findViewById<TextView>(R.id.dashboardUsername)
        uname.setText(auth.currentUser?.displayName.toString())


        var seemovies = findViewById<Button>(R.id.allMoviesButton)
        var addmovie = findViewById<Button>(R.id.addMovieButton)
        var logout = findViewById<Button>(R.id.logOutButton)
        var findmovie = findViewById<Button>(R.id.searchMoviesButton)


        logout.setOnClickListener { // takes you back to the login page
            finish()
        }
        seemovies.setOnClickListener { // see all the movies
            startActivity(Intent(this,see_all::class.java))
        }
        addmovie.setOnClickListener { // add a new movie
            startActivity(Intent(this,add_movie::class.java))
        }
        findmovie.setOnClickListener { // find  a specific movie
            startActivity(Intent(this,search_movie::class.java))
        }

    }
}