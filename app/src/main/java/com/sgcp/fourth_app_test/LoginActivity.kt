package com.sgcp.fourth_app_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        val admin = BaseDatosAPP(this, "bd", null, 1 );
        val bd = admin.writableDatabase;
        val fila = bd.rawQuery("SELECT NOMBRE, PASSWORD FROM Usuarios WHERE NOMBRE='${etUsuario.text.toString()}' AND PASSWORD='${etPassword.text.toString()}'", null);

        var user = "";
        var pass = "";
        if ( fila.moveToFirst()) {
            user = fila.getString(0);
            pass = fila.getString(1);
        }
        if( (etUsuario.text.toString() == user) && (etPassword.text.toString() == pass)) {
            Toast.makeText(this, "Iniciando sesión...", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos...", Toast.LENGTH_LONG).show();
        }
    }
}