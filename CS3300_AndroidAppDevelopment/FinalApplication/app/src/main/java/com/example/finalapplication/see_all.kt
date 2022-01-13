// Ethan Smith
// 3300 Android development
// Final exam
package com.example.finalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class see_all : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all)

        var arlist = arrayListOf<String>()
        var list = findViewById<ListView>(R.id.seeAllList)
        var db = FirebaseFirestore.getInstance()
        var adapt: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,arlist)

        db.collection("Movies").get().addOnCompleteListener {task ->
            if (task.isSuccessful) {
                for (document in task.result!!) {
                    arlist.add(document.data["Title"].toString())
                }
                list.adapter = adapt
            }
        }


        var theonlything = findViewById<Button>(R.id.BackFromAllMovies)
        theonlything.setOnClickListener {
            finish() // good stuff 
        }

        list.setOnItemClickListener{parent,view,position,id -> // click on a movie to go to the rating page
            var target = parent.getItemAtPosition(position)
            var intent = Intent(this,movie_info::class.java)
            println(target)
            intent.putExtra("Title",target.toString())

            startActivity(intent) // hopefully this works but I don't think it does
        }
    }
}