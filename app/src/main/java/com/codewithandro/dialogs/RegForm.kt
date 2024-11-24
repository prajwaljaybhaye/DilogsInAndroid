package com.codewithandro.dialogs

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegForm : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reg_form)

        val redBtn = findViewById<AppCompatButton>(R.id.redBtn)
        val signupBtn = findViewById<Button>(R.id.signupBtn)

        //loginBtnFun function
        redBtn.setOnClickListener{
            intent=Intent(applicationContext,LogInForm::class.java)
            startActivity(intent)
        }

        signupBtnFun(signupBtn);//intent function
    }

    //signupBtnFun function

    private fun signupBtnFun(signupBtn: Button?) {

        signupBtn?.setOnClickListener{
            Toast.makeText(applicationContext,"Registration Sucessfull!",Toast.LENGTH_SHORT).show()
        }

    }




    }
