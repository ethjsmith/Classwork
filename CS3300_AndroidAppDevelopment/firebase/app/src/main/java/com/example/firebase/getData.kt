package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class getData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data)
        var found = false
        var recid:String = ""
        var sname:String = ""
        var sid:String = ""
        var smaj:String = ""
        var s = findViewById<EditText>(R.id.searchtxt)
        var b = findViewById<Button>(R.id.searchbutton)
        var l1 = findViewById<TextView>(R.id.textView)
        var l2 = findViewById<TextView>(R.id.textView2)
        var l3 = findViewById<TextView>(R.id.textView3)
        l1.setText("ID")
        l2.setText("NAME")
        l3.setText("MAJOR")
        var deb = findViewById<Button> (R.id.bdel)
        var ub = findViewById<Button>(R.id.bupdate)
        deb.setOnClickListener {
            var db = FirebaseFirestore.getInstance()
            if (found) {
                db.collection("students").document(recid).delete().addOnCompleteListener {
                    Toast.makeText(this, "Deleted Record LOL", Toast.LENGTH_SHORT).show()
                    l1.setText("ID")
                    l2.setText("NAME")
                    l3.setText("MAJOR")
                }
            }else {
                Toast.makeText(this,"Find a record first",Toast.LENGTH_SHORT).show()
            }
        }
        ub.setOnClickListener {
            if (found) {
                var intent = Intent(this, UpdateActivity::class.java)
                intent.putExtra("recordId", recid)
                intent.putExtra("name", sname)
                intent.putExtra("id", sid)
                intent.putExtra("major", smaj)
                startActivity(intent)
            }else {
                Toast.makeText(this,"Find a record first",Toast.LENGTH_SHORT).show()
            }
        }
        b.setOnClickListener {
            var db = FirebaseFirestore.getInstance() // db conneciton

            db.collection("students").get().addOnCompleteListener {task ->

                if (task.isSuccessful) {
                    found = false
                    for (document in task.result!!){
                        if (document.data["id"]!!.equals(s.text.toString())) {
                            found = true
                            recid = document.id.toString()
                            l1.setText(document.data["id"].toString())
                            l2.setText(document.data["name"].toString())
                            l3.setText(document.data["major"].toString()) // honestly... l o l
                            sname = document.data["name"].toString()
                            sid = document.data["id"].toString()
                            smaj = document.data["major"].toString()
                        }
                    }
                    if (!found) {
                        l1.setText("Record not found LOL sucks to suck")
                    }
                }
            }

        }
    }
}