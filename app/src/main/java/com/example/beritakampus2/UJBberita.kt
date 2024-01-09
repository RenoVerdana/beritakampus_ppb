package com.example.beritakampus2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UJBberita : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<NewsUJB>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ujbberita)

        userRecyclerView = findViewById(R.id.ujblist)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf<NewsUJB>()


        dbref = FirebaseDatabase.getInstance().getReference("beritaUJB")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val image = userSnapshot.getValue(NewsUJB::class.java)
                        userArrayList.add(image!!)
                    }
                    userRecyclerView.adapter = AdapterUJB(userArrayList, this@UJBberita)
                }
            }
                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@UJBberita, error.toString(), Toast.LENGTH_SHORT).show()
                }
            })
    }
}