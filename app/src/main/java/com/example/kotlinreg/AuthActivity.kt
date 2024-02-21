package com.example.kotlinreg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin = findViewById<EditText>(R.id.user_login_auth)
        val userPassword = findViewById<EditText>(R.id.user_pass_auth)
        val buttonIn: Button = findViewById(R.id.button_in)
        val linkToReg: TextView = findViewById(R.id.LinkToReg)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonIn.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass: String = userPassword.text.toString().trim()

            if (login == "" || pass == "")
                makeText(this, "Нельзя оставить поле пустым!!", LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val  isAuth = db.getUser(login, pass)

                if (isAuth) {
                    makeText(this, "Пользователь $login авторизован!!", LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPassword.text.clear()

                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                } else
                    makeText(this, "Пользователь $login не существует!!", LENGTH_LONG).show()


            }
        }
    }
}