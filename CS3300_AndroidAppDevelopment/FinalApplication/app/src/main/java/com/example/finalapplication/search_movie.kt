// Ethan Smith
// 3300 Android development
// Final exam
package com.example.finalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class search_movie : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)

        var searchme = findViewById<EditText>(R.id.seachMovieTextField) // typo :(
        var smb = findViewById<Button>(R.id.submitSearchButton)
        var lista = findViewById<ListView>(R.id.searchResults)
        var ar = arrayListOf<String>()
        var adapt: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,ar)
        var db = FirebaseFirestore.getInstance()

        smb.setOnClickListener {

            db.collection("Movies").get().addOnCompleteListener {task ->
                for (document in task.result!!) {
                    if (document.data["Title"].toString().contains(searchme.text.toString())) {
                        ar.add(document["Title"].toString())
                    }
                    lista.adapter = adapt
                }
            }

        }
        lista.setOnItemClickListener{parent,view,position,id -> // click on a movie to go to the rating page
            var target = parent.getItemAtPosition(position)
            var intent = Intent(this,movie_info::class.java)
            println(target)
            intent.putExtra("Title",target.toString())

            startActivity(intent) // hopefully this works but I don't think it does
        }
    }
}