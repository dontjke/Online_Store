package com.stepanov.onlinestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stepanov.onlinestore.ui.RegistrationFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, RegistrationFragment.newInstance())
            .commit()
    }
}