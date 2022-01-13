// Ethan Smith
// 3300 Android development
// Final exam
package com.example.finalapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class signup : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var semail = findViewById<EditText>(R.id.signupEmail)
        var spass = findViewById<EditText>(R.id.signupPassword)
        var suser = findViewById<EditText>(R.id.signupUserName)

        var bsignup = findViewById<Button>(R.id.signupButton)
        var bback = findViewById<Button>(R.id.backToLoginButton)

        bback.setOnClickListener {
            finish() // this should take you back to the main page :)
        }
        bsignup.setOnClickListener {
            // verify data.
            var email_is_valid = android.util.Patterns.EMAIL_ADDRESS.matcher(semail.text.toString()).matches()
            var plow=false
            var pup=false
            var pnum=false
            for (i in 0 until spass.text.toString().length) {
                if (spass.text.toString()[i].isUpperCase()){
                    pup = true
                }
                if (spass.text.toString()[i].isLowerCase()){
                    plow = true
                }
                if (spass.text.toString()[i].isDigit()){
                    pnum = true
                }
            }
            if (email_is_valid && plow && pup && pnum) { // password is complex enough, and email is valid, so we create a new user.
                auth.createUserWithEmailAndPassword(semail.text.toString(),spass.text.toString())
                    .addOnCompleteListener {
                    if (it.isSuccessful){
                        var user = auth.currentUser
                        user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(suser.text.toString()).build()) //sets the username, separately from the email and password.
                        // this one was confusing to figure out, because I've never done it before ...
                        Toast.makeText(this,"New user created successfully",Toast.LENGTH_SHORT).show()
                        finish() // takes you back
                    }else {
                        println(" " + spass.text.toString() + ", " +  semail.text.toString() +", "+ suser.text.toString())
                        Toast.makeText(this,"Error with creating user :( ", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Error with some part of the user data, make a password with at least an upper case, lower case, and number, and make sure your email is valid",Toast.LENGTH_LONG).show()
            }
        }

    }
}