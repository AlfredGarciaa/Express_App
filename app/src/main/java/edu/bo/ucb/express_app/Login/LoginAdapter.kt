package edu.bo.ucb.express_app.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import edu.bo.ucb.express_app.Menu.Menu
import edu.bo.ucb.express_app.R

class LoginAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvGoToRegister = findViewById<TextView>(R.id.tv_go_to_register)
        tvGoToRegister.setOnClickListener{
            goToRegister()
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