package com.example.beritakampus2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UNYberita : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<NewsUNY>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unyberita)

        userRecyclerView = findViewById(R.id.unylist)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf<NewsUNY>()


        dbref = FirebaseDatabase.getInstance().getReference("beritaUNY")
        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (dataSnapShot in snapshot.children){
                        val image = dataSnapShot.getValue(NewsUNY::class.java)
                        userArrayList.add(image!!)
                    }
                    userRecyclerView.adapter = AdapterUNY(userArrayList, this@UNYberita)

                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@UNYberita, error.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }
}