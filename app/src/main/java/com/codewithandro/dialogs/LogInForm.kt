package com.codewithandro.dialogs

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LogInForm : AppCompatActivity() {

    private lateinit var email: EditText


    companion object {
        const val KEY = "com.codewithandro.dialogs.LogInForm.KEY"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in_form)

        // Initialize views after setContentView
        email = findViewById(R.id.loginEmail)

        val lastLoginBtn = findViewById<Button>(R.id.lastLoginBtn)
        val signupBtn = findViewById<Button>(R.id.signupBtn)

        loginBtnFun(lastLoginBtn) // Intent function
        signupBtnFun(signupBtn)   // Intent function
    }

    // signupBtnFun function
    private fun signupBtnFun(signupBtn: Button?) {
        signupBtn?.setOnClickListener {
            intent = Intent(applicationContext, RegForm::class.java)
            startActivity(intent)
        }
    }

    // loginBtnFun function
    private fun loginBtnFun(lastLoginBtn: Button) {
        lastLoginBtn.setOnClickListener {
            // Send data from one activity to another
            val messageCombine = "Hi Prajwal \n\n\nWelcome To Water Delivery App\n\n\nWe deliver water at any point of Earth in 30 minutes \n\n\n\n\nYour Email: " + email.text.toString()

            intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(KEY, messageCombine)
            startActivity(intent)

            Toast.makeText(applicationContext, "Logged in Successfully!", Toast.LENGTH_SHORT).show()
        }
    }
}
