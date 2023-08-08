package com.itproger.lovecalculator.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.itproger.lovecalculator.R
import com.itproger.lovecalculator.sharepreferences.preferences.Preference
import dagger.hilt.android.AndroidEntryPoint
import java.util.prefs.Preferences
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var preference: Preference
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

    }
}