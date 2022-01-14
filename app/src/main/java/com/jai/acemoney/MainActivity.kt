package com.jai.acemoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.TaskStackBuilder
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBarWithNavController(findNavController(R.id.myNavHostFragment))
    }

    override fun onSupportNavigateUp(): Boolean {

        navController= findNavController(R.id.myNavHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()

    }
}