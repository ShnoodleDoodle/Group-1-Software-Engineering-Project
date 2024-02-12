package com.example.projectElderWatch

import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.elderwatch.R
import com.example.elderwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the main activity layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        // Find NavigationView and TextViews in the header
        val navView = binding.navView
        val textViewUsername =
            navView.getHeaderView(0).findViewById<TextView>(R.id.textViewUsername)
        val textViewEmail = navView.getHeaderView(0).findViewById<TextView>(R.id.textViewEmail)

        // Assume currentUser is the object representing the logged-in user
        val currentUser = User(1, "Josh.Cotrau", "password123", 1, "Josh.Cotrau@example.com")

        // Update TextViews with user information
        textViewUsername.text = currentUser.username
        textViewEmail.text = currentUser.email

        // Set up navigation
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
