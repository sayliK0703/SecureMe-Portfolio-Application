package com.example.secureme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    companion object{
        const val KEY2="com.example.SecureMe.userName"
    }
    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        val btnUniqueId=findViewById<TextInputEditText>(R.id.textSignFirstName)
        val btnfullName=findViewById<TextInputEditText>(R.id.textSignLastName)
        val btnEmail=findViewById<TextInputEditText>(R.id.textSignEmail)
        val btnPassword=findViewById<TextInputEditText>(R.id.textSignPass)
        val btnSubmit=findViewById<Button>(R.id.btnSignUpSubmit)
        val login=findViewById<TextView>(R.id.textSignUp)

        login.setOnClickListener {
            intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        btnSubmit.setOnClickListener {
            val UniqueId=btnUniqueId.text.toString()
            val Name=btnfullName.text.toString()
            val email=btnEmail.text.toString()
            val password=btnPassword.text.toString()

            val user=User(UniqueId,Name,email,password)

            database=FirebaseDatabase.getInstance().getReference("user")



            if(UniqueId.isNotEmpty() && Name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() ){
                database.child(UniqueId).setValue(user).addOnSuccessListener {
                    Toast.makeText(this,"Account created Successfully",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
                }

                val intent=Intent(this,portfolio::class.java)
                intent.putExtra(KEY2,Name)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Fill the Information",Toast.LENGTH_SHORT).show()
            }
        }

    }
}