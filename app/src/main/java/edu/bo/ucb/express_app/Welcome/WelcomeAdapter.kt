package edu.bo.ucb.express_app.Welcome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.bo.ucb.express_app.Login.LoginAdapter
import edu.bo.ucb.express_app.R

class WelcomeAdapter : AppCompatActivity() {
    val loginButton:Button
        get() = findViewById(R.id.Login)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        loginButton.setOnClickListener{
            startActivity(Intent(this,LoginAdapter::class.java))
        }
    }
}