package edu.bo.ucb.express_app.Login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.bo.ucb.express_app.Menu.Menu
import edu.bo.ucb.express_app.R
import edu.bo.ucb.express_app.Welcome.WelcomeAdapter

class LoginAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvGoToRegister = findViewById<TextView>(R.id.tv_go_to_register)
        tvGoToRegister.setOnClickListener{
            goToRegister()
        }

        // CAMBIAR VISTA DE LOGIN A WELCOME \\
        val welcome = findViewById<View>(R.id.btn_welcome) as Button
        welcome.setOnClickListener {
            startActivity(Intent(this, WelcomeAdapter::class.java))
        }

        // CAMBIAR VISTA DE LOGIN A MENU \\
        val menu = findViewById<View>(R.id.btn_menu) as Button
        menu.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
    }
    private fun goToRegister(){
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
    }
}