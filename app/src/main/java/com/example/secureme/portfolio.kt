package com.example.secureme

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class portfolio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portfolio)

        supportActionBar?.hide()

        val linkedIn=findViewById<CardView>(R.id.cardLinkedin)
        val gfg=findViewById<CardView>(R.id.cardGFG)
        val gitHub=findViewById<CardView>(R.id.cardGithub)
        val leetCode=findViewById<CardView>(R.id.cardLeetCode)

        val userText=findViewById<TextView>(R.id.textUserView)

        val loginUserName=intent.getStringExtra(LoginActivity.KEY1)
        val signUpUserName=intent.getStringExtra(SignUpActivity.KEY2)

        if(loginUserName.isNullOrEmpty()){
            userText.text="Heyy, $signUpUserName"
        }else{
            userText.text="Heyy, $loginUserName"
        }

        linkedIn.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("https://www.linkedin.com/")
            startActivity(intent)
        }
        gfg.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW)
            intent.data=Uri.parse("https://www.geeksforgeeks.org/")
            startActivity(intent)
        }
        gitHub.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW)
            intent.data=Uri.parse("https://github.com/")
            startActivity(intent)
        }
        leetCode.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW)
            intent.data=Uri.parse("https://leetcode.com/")
            startActivity(intent)
        }
    }
}