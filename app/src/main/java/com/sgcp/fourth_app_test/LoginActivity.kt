package com.sgcp.fourth_app_test

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class LoginActivity : AppCompatActivity() {

    var EXTRA_USER = "EXTRA_USER";
    var EXTRA_ID = "EXTRA_ID";

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

        val reg = ContentValues();
        reg.put("NOMBRE", "Danisable");
        reg.put("PASSWORD", "1234");
        bd.insert("Usuarios", null, reg);


        val fila = bd.rawQuery("SELECT ID, NOMBRE, PASSWORD FROM Usuarios WHERE NOMBRE='${etUsuario.text.toString()}' AND PASSWORD='${etPassword.text.toString()}'", null);

        var id = 0;
        var user = "";
        var pass = "";
        if ( fila.moveToFirst()) {
            id = fila.getString(0).toInt();
            user = fila.getString(1);
            pass = fila.getString(2);
        }
        if( (etUsuario.text.toString() == user) && (etPassword.text.toString() == pass)) {
            val intent = Intent(this, PanelActivity::class.java).apply {
                putExtra(EXTRA_USER, user);
                putExtra(EXTRA_ID, id);
            };
            startActivity(intent);
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos...", Toast.LENGTH_LONG).show();
        }
    }
}