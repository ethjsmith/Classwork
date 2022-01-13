package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        var sn = findViewById<EditText>(R.id.tname)
        var sid = findViewById<EditText>(R.id.tid)
        var sm = findViewById<EditText>(R.id.tmaj)
        var b = findViewById<Button>(R.id.bupd)
        //var l = findViewById<TextView>(R.id.trec)
        //l.setText(intent.getStringExtra("recordId"))

        sn.setText(intent.getStringExtra("name"))
        sid.setText(intent.getStringExtra("id"))
        sm.setText(intent.getStringExtra("major"))

        b.setOnClickListener {
            var db = FirebaseFirestore.getInstance()
            // to update create ashdkjahskd
            // this thing
            var student:MutableMap<String,Any?> = HashMap()
            student["id"] = sid.text.toString()
            student["name"]= sn.text.toString()
            student["major"] = sm.text.toString()

            db.collection("students").document(intent.getStringExtra("recordID").toString()).set(student).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this,"Record updated",Toast.LENGTH_SHORT).show()
                    finish()
                }else {
                    Toast.makeText(this,"ERROR wit da record lol", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}