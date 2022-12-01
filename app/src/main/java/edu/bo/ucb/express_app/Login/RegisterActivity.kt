package edu.bo.ucb.express_app.Login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.bo.ucb.express_app.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val tvGoToLogin = findViewById<TextView>(R.id.tv_go_to_login)
        tvGoToLogin.setOnClickListener{
            goToLogin()
        }

        // CAMBIAR VISTA DE SIGN UP A LOGIN \\
        val login = findViewById<View>(R.id.btn_login) as Button
        login.setOnClickListener {
            startActivity(Intent(this, LoginAdapter::class.java))
        }

        // CAMBIAR VISTA DE REGISTRARSE A LOGEO -> AL AÑADIR NUEVO USUARIO \\
        val login_ = findViewById<View>(R.id.btn_login_) as Button
        login_.setOnClickListener {
            startActivity(Intent(this, LoginAdapter::class.java))
        }
    }
    private fun goToLogin(){
        val i = Intent(this, LoginAdapter::class.java)
        startActivity(i)
    }
}