package com.example.secureme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.math.sign

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        supportActionBar?.hide()

        val login=findViewById<Button>(R.id.btnLogin)
        val signUp=findViewById<Button>(R.id.btnSignUp)

        login.setOnClickListener {
            intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        signUp.setOnClickListener {
            intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}