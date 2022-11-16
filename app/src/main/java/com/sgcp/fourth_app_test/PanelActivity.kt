package com.sgcp.fourth_app_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit

class PanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)

        val user = intent.getStringExtra("EXTRA_USER");
        val id = intent.getIntExtra("EXTRA_ID", 0);

        val fmanager = supportFragmentManager;
        val fmanagerTrans = fmanager.beginTransaction();
        val fragment = PrincipalFragment();

        val dataBundle = Bundle();
        dataBundle.putString("USER", user);
        dataBundle.putInt("ID", id);
        fragment.arguments = dataBundle;
        fmanagerTrans.add(R.id.fcv_main_container, fragment).commit();

//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            add<PrincipalFragment>(R.id.fcv_main_container)
//        }
    }
}