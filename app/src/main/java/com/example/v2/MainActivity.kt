package com.example.v2

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.v2.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.collection.LLRBNode.Color


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var myButton: Button
    private lateinit var regButton: Button
    
    private lateinit var forgotbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        myButton = findViewById(R.id.login_btn)
        myButton.setOnClickListener {
            val email = binding.username.text.toString()
            val password = binding.password.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{

                    if(it.isSuccessful){
                        val intent = Intent(this, MainDashboard::class.java)
                        startActivity(intent)
                    } else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else {
                Toast.makeText(this,"Fields Cannot Be Empty" ,Toast.LENGTH_SHORT).show()
            }

        }

        forgotbutton = findViewById(R.id.forgotpassword)

        binding.forgotpassword.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.dialog_forgot, null)
            val useremail = view.findViewById<EditText>(R.id.enteremail)

            builder.setView(view)
            val dialog = builder.create()

            view.findViewById<Button>(R.id.ResetPassword).setOnClickListener{
                compareEmail(useremail)
                dialog.dismiss()
            }
            view.findViewById<Button>(R.id.CancelForgot).setOnClickListener{
                dialog.dismiss()
            }
            if(dialog.window != null){
                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()
        }

        regButton = findViewById(R.id.RegisterButton)
        regButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun compareEmail(email: EditText) {
        val emailString = email.text.toString().trim()

        if (emailString.isEmpty()) {
            // Handle case where email is empty
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailString).matches()) {
            // Handle case where email is not in valid format
            email.error = "Invalid email format"
            return
        }

        firebaseAuth.fetchSignInMethodsForEmail(emailString).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val signInMethods = task.result?.signInMethods ?: emptyList()
                if (signInMethods.isNotEmpty()) {
                    // Email exists in database, proceed with sending password reset email
                    firebaseAuth.sendPasswordResetEmail(emailString).addOnCompleteListener { resetTask ->
                        if (resetTask.isSuccessful) {
                            Toast.makeText(this, "Check Your Email", Toast.LENGTH_SHORT).show()
                        } else {
                            // Handle case where sending password reset email failed
                            Toast.makeText(this, "Failed to send password reset email", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    // Email does not exist in database
                    Toast.makeText(this, "Email not found", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Handle case where fetching sign-in methods failed
                Toast.makeText(this, "Failed to fetch sign-in methods", Toast.LENGTH_SHORT).show()
            }
        }
    }


}