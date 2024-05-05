package com.example.v2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.v2.ResidentActivity


class MainDashboard : AppCompatActivity() {

    private lateinit var resButton: Button
    private lateinit var outButton: Button
    private lateinit var expButton: Button
    private lateinit var calButton: Button


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main_dashboard)



            resButton = findViewById(R.id.ResidentButton)
            resButton.setOnClickListener {
                val intent = Intent(this, ResidentActivity::class.java)
                startActivity(intent)
                finish()
            }
            expButton = findViewById(R.id.exportButton)
            expButton.setOnClickListener {
                val intent = Intent(this, MonthlyExport::class.java)
                startActivity(intent)
                finish()
            }
            calButton = findViewById(R.id.CalenderButton)
            calButton.setOnClickListener {
                val intent = Intent(this, MainNotification::class.java)
                startActivity(intent)
                finish()
            }

            outButton = findViewById(R.id.logoutButton)
            outButton.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}