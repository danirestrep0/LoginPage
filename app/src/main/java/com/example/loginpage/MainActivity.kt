package com.example.wandersync

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Update with your actual package name

class MainActivity : AppCompatActivity() {
    private var usernameEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var loginButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main.xml)

        // Initialize UI elements
        usernameEditText = findViewById<EditText>(R.id.username)
        passwordEditText = findViewById<EditText>(R.id.password)
        loginButton = findViewById<Button>(R.id.loginButton)

        // Set up the login button click listener
        loginButton.setOnClickListener(View.OnClickListener { performLogin() })
    }

    private fun performLogin() {
        // Get input values
        val username = usernameEditText!!.text.toString().trim { it <= ' ' }
        val password = passwordEditText!!.text.toString().trim { it <= ' ' }

        // Basic validation
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both username and password.", Toast.LENGTH_SHORT)
                .show()
            return
        }

        // Dummy authentication (replace with real authentication logic)
        if (username == "user" && password == "pass") {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

            // Proceed to next activity (e.g., HomeActivity)
            val intent = Intent(
                this@MainActivity,
                MainActivity::class.java
            ) // Replace with your actual HomeActivity
            startActivity(intent)
            finish() // Optional: close this activity
        } else {
            Toast.makeText(this, "Invalid username or password.", Toast.LENGTH_SHORT).show()
        }
    }
}
