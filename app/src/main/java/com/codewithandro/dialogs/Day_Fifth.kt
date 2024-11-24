package com.codewithandro.dialogs

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Day_Fifth : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_day_fifth)

        val login = findViewById<Button>(R.id.startLoginBtn)
        val signup = findViewById<Button>(R.id.startSignupBtn)

        loginBtnFun(login); //intent function
        signupBtnFun(signup);//intent function
    }

    //signupBtnFun function

    private fun signupBtnFun(signupBtn: Button?) {

        signupBtn?.setOnClickListener{
            intent=Intent(applicationContext,RegForm::class.java)
            startActivity(intent)
        }

    }

    //loginBtnFun function

    private fun loginBtnFun(loginBtn: Button?) {

        loginBtn?.setOnClickListener{
            intent= Intent(applicationContext,LogInForm::class.java)
            startActivity(intent)
        }
    }
}