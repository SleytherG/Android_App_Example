package com.sgcp.fourth_app_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Switch
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val swEncendido: Switch = findViewById(R.id.sw_encender);
        swEncendido.setOnCheckedChangeListener({ _ , isChecked ->
            val texto = if ( isChecked ) "Encendido" else "Apagado";
            swEncendido.text = texto;
        })
    }
}