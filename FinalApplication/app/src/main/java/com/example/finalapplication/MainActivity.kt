// Ethan Smith
// 3300 Android development
// Final exam
package com.example.finalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name = findViewById<EditText>(R.id.logInEmail)
        var lpass = findViewById<EditText>(R.id.loginPassword)
        var lb = findViewById<Button>(R.id.logInButton)
        var rb = findViewById<Button>(R.id.signupPageButton)
        // what this one  needs to do

        // button to log in user
        lb.setOnClickListener {
            auth.signInWithEmailAndPassword(name.text.toString(),lpass.text.toString()).addOnCompleteListener {
                if (it.isSuccessful) {
                    // start the dashboard activity
                    startActivity(Intent(this,dashboard::class.java))
                }else {
                    Toast.makeText(this,"Error logging in, check that your credentials are correct", Toast.LENGTH_SHORT).show()
                }
            }
        }
        // button to redirect to create user/registration view.
        rb.setOnClickListener {
            startActivity(Intent(this,signup::class.java))
        }

    }
}