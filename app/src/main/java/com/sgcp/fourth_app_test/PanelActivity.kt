package com.sgcp.fourth_app_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.add
import androidx.fragment.app.commit

class PanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<PrincipalFragment>(R.id.fcv_main_container)
        }

    }
}