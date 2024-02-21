package com.example.kotlinreg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin = findViewById<EditText>(R.id.user_login)
        val userEmail = findViewById<EditText>(R.id.user_email)
        val userPassword = findViewById<EditText>(R.id.user_pass)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.LinkToAuth)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity2::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val mail = userEmail.text.toString().trim()
            val pasw = userPassword.text.toString().trim()

            if (login == "" || mail == "" || pasw == "")
                Toast.makeText(this, "Нельзя оставить поле пустым!!", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, mail, pasw)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен!!", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
            }
        }
    }
}