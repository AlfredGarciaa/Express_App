package edu.bo.ucb.express_app.Welcome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.bo.ucb.express_app.Login.LoginAdapter
import edu.bo.ucb.express_app.Login.RegisterActivity
import edu.bo.ucb.express_app.R

class WelcomeAdapter : AppCompatActivity() {
    val loginButton:Button
        get() = findViewById(R.id.Login)
    val signUp:TextView
        get() = findViewById(R.id.signUp)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        loginButton.setOnClickListener{
            startActivity(Intent(this,LoginAdapter::class.java))
        }
        signUp.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}