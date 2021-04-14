package com.example.firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var db = FirebaseFirestore.getInstance()

        var idBox = findViewById<EditText>(R.id.editid)
        var nameBox = findViewById<EditText>(R.id.editName)
        var majBox = findViewById<EditText>(R.id.editmajor)
        var btn = findViewById<Button>(R.id.button)
        var sw = findViewById<Button>(R.id.swap)
        sw.setOnClickListener{
            var i = Intent(this,getData::class.java)
            startActivity(i)
        }
        btn.setOnClickListener{
            var student: MutableMap<String, Any?> = HashMap()

            student["id"] = idBox.text.toString()
            student["name"] = nameBox.text.toString()
            student["major"] = majBox.text.toString()
            db.collection("students").add(student)
                .addOnCompleteListener{
                    Toast.makeText(this,"DATA was inserted",Toast.LENGTH_SHORT).show()
                    idBox.setText("")
                    nameBox.setText("")
                    majBox.setText("")
                }

        }

//        val user: MutableMap<String, Any> = HashMap()
//        user["first"] = "Ada"
//        user["last"] = "Lovelace"
//        user["born"] = 1815
//
//        db.collection("users")
//            .add(user)
    }
}