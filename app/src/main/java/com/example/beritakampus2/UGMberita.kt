package com.example.beritakampus2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UGMberita : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ugmberita)

        userRecyclerView = findViewById(R.id.ugmlist)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf<News>()


        dbref = FirebaseDatabase.getInstance().getReference("berita")
        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (dataSnapShot in snapshot.children){
                        val image = dataSnapShot.getValue(News::class.java)
                        userArrayList.add(image!!)
                    }
                    userRecyclerView.adapter = MyAdapter(userArrayList, this@UGMberita)

                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@UGMberita, error.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }
}