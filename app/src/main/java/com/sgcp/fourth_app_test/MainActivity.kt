package com.sgcp.fourth_app_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCall: ImageButton = findViewById(R.id.btn_call);
        btnCall.setOnClickListener{
            Toast.makeText(this,"Llamando...", Toast.LENGTH_LONG).show();
        }
    }
}