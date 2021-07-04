package com.example.ageinminutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

         val actionBar = supportActionBar

        actionBar!!.title= "Second Activity"

        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}