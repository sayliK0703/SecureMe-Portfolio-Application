package com.example.secureme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {
    companion object {
       const val KEY1="com.example.SecureMe.userName"
    }
    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()
        val signUp=findViewById<TextView>(R.id.textSignUp)
        val btnLogin=findViewById<Button>(R.id.btnLoginPage)

        val userId=findViewById<TextInputEditText>(R.id.textLoginUser)
        val pass=findViewById<TextInputEditText>(R.id.textLoginPass)

        signUp.setOnClickListener {
            intent= Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val uniqueId=userId.text.toString()
            val passKey=pass.text.toString()

            if(uniqueId.isNotEmpty() && passKey.isNotEmpty()){
                dataRes(uniqueId,passKey)
            }else if(uniqueId.isEmpty()){
                Toast.makeText(this,"Enter your User Id",Toast.LENGTH_SHORT).show()
            }else if(passKey.isEmpty()){
                Toast.makeText(this, "Enter your Password", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun dataRes(uniqueId: String, passKey: String) {
        database=FirebaseDatabase.getInstance().getReference("user")

        database.child(uniqueId).get().addOnSuccessListener {
            if(it.exists()){
                val password=it.child("password").value
                val userName=it.child("lastName").value

                if(passKey.equals(password.toString())){
                    val intent=Intent(this,portfolio::class.java)
                    intent.putExtra(KEY1,userName.toString())
                    startActivity(intent)
                    Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Account not Exist", Toast.LENGTH_SHORT).show()
            }
        }
    }
}