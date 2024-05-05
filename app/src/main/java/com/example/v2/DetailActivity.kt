package com.example.v2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.v2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var returnButton: Button
    var imageUrl = ""
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        returnButton = findViewById(R.id.returntoRes)
        returnButton.setOnClickListener {
            val intent = Intent(this, ResidentActivity::class.java)
            startActivity(intent)
            finish()
        }

        val bundle = intent.extras
        if (bundle != null) {
            binding.detailDesc.text = bundle.getString("Description")
            binding.detailResident.text = bundle.getString("Resident")
            binding.detailAge.text = bundle.getString("Age")
            binding.detailMedication.text = bundle.getString("Medication")
            imageUrl = bundle.getString("Image")!!
            Glide.with(this).load(bundle.getString("Image"))
                .into(binding.detailImage)
        }
    }
}