// Ethan Smith
// 3300 Android development
// Final exam
package com.example.finalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class rate_movie : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_movie)
        var db = FirebaseFirestore.getInstance()
        var mname = findViewById<TextView>(R.id.movieName_RateMovie)
        mname.setText(intent.getStringExtra("Title"))
        var mrating = findViewById<EditText>(R.id.enterRating)

        var submit = findViewById<Button>(R.id.submitRating)
        submit.setOnClickListener {
            // submit the new rating
            println(intent.getStringExtra("Title"))
            var a = arrayListOf<Int>()
            a.add(mrating.text.toString().toInt())
            var id = "o"
           // db.collection("Movies").document(intent.getStringExtra("Title").toString()).get().addOnCompleteListener {task ->
            db.collection("Movies").get().addOnCompleteListener {task->
                println("checking if its in movies :)")
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        if (document.data["Title"]!!.equals(intent.getStringExtra("Title"))) {
                            println("found the guy")
                            id = document.id.toString()
                            println(document.id)
                            println(id)
                            var b = document.data["Rating"]

                            a.addAll(b as Collection<Int>) // cunt
                            db.collection("Movies").document(id).update("Rating",a) // I hope this works :)
                            println("it worked? ")
                            //finish()
                            var z = Intent(this,movie_info::class.java)
                            z.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            z.putExtra("Title",intent.getStringExtra("Title")) // lol 
                            startActivity(z)
                        }
                    }
                } else {
                    Toast.makeText(this,"Error sending the new rating to the database", Toast.LENGTH_SHORT).show()
                }

            }

        }
    }
}