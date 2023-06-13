package com.example.truelaptopshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {
    var client: OkHttpClient = OkHttpClient()
    var getURL: String = ""
    var postURL: String = ""
    var TextView: TextView? = null
    var buttonGet: Button? = null
    var buttonPost: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TextView = findViewById(R.id.TextData)
        buttonGet = findViewById(R.id.btnGet)
        buttonPost = findViewById(R.id.btnPost)
        buttonGet!!.setOnClickListener{TextView!!.text = "dasdasd"
        }
    }
}