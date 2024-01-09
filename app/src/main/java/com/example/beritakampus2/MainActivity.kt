package com.example.beritakampus2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Application
import android.content.Intent
import android.widget.ImageView
import com.google.firebase.FirebaseApp

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}


class MainActivity : AppCompatActivity() {

    private lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Pindah halaman melalui logo ujb ke berita
        img = findViewById(R.id.img_ujb)

        img.setOnClickListener{ startActivity(Intent(this, UJBberita::class.java))
        }

        //Pindah halaman melalui logo ugm ke berita
        img = findViewById(R.id.img_ugm)

        img.setOnClickListener { startActivity(Intent(this, UGMberita::class.java))
        }

        //Pindah halaman melalui logo uny ke berita
        img = findViewById(R.id.img_uny)

        img.setOnClickListener { startActivity(Intent(this, UNYberita::class.java))
        }
    }
}