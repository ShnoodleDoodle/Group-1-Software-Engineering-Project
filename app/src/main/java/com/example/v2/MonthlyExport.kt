package com.example.v2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.*
import com.google.firebase.auth.FirebaseAuth

class MonthlyExport : AppCompatActivity() {

    private lateinit var backmain: Button
    private lateinit var exportbtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_monthly_export)

        val rootRef = FirebaseDatabase.getInstance().reference
        val caringConnectionRef = rootRef.child("TheCaringConnection")


        exportbtn = findViewById(R.id.topdfbutton)
        exportbtn.setOnClickListener {
            val intent = Intent(this, PDF_View::class.java)
            startActivity(intent)


        }

        backmain = findViewById(R.id.backtodash4Button)
        backmain.setOnClickListener {
            val intent = Intent(this, MainDashboard::class.java)
            startActivity(intent)
            finish()
        }


        val spinner1: Spinner = findViewById(R.id.spinner1)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        val spinner3: Spinner = findViewById(R.id.spinner5)

        // Initialize an empty list to hold resident names
        val residentNames = mutableListOf<String>()

        // Create an ArrayAdapter for the spinner
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, residentNames)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter1

        // Fetch data from Firebase and populate the spinner
        caringConnectionRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Clear existing data
                residentNames.clear()
                // Iterate through each section under "TheCaringConnection"
                for (data in snapshot.children) {
                    // Extract the "resident" value from each section and add it to the list
                    val residentName = data.child("resident").getValue(String::class.java)
                    residentName?.let { residentNames.add(it) }
                }
                // Notify adapter about data changes
                adapter1.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
                Log.e("MonthlyExport", "Failed to read value.", error.toException())
            }
        })


        // Sample data for the spinners

        val data2 = arrayOf("Assisted Living/Personal Care +(2500.00)", "Hospice Care +(1500.00)", "Nursing Facilities +(3000.00)")
        val data3 = arrayOf("Aricept", "Exelon", "Razadyne","Namenda")
        val data4 = arrayOf("Aricept", "Exelon", "Razadyne","Namenda")


        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data2)
        val adapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data3)
        val adapter4 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data4)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner1.adapter = adapter1
        spinner2.adapter = adapter2
        spinner3.adapter = adapter2


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.spinner1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}