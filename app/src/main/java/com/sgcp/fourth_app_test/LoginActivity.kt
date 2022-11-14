package com.sgcp.fourth_app_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsuario: EditText = findViewById(R.id.et_user);
        val etPassword: EditText = findViewById(R.id.et_pass);
        val btnIniciar: Button = findViewById(R.id.btn_iniciar_sesion);

    }

    fun iniciarSesion(view: View) {
        val etUsuario: EditText = findViewById(R.id.et_user);
        val etPassword: EditText = findViewById(R.id.et_pass);

        if( (etUsuario.text.toString() == "Sleyther") && (etPassword.text.toString() == "1234")) {
            Toast.makeText(this, "Iniciando sesión...", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "usuario o contraseña incorrectos...", Toast.LENGTH_LONG).show();
        }
    }
}