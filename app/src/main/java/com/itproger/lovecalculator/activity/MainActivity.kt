package com.itproger.lovecalculator.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.itproger.lovecalculator.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.findNavController()
    }
}