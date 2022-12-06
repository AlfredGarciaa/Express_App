package edu.bo.ucb.express_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import edu.bo.ucb.express_app.Welcome.WelcomeAdapter

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // CAMBIAR DE SPLASH SCREEN A WELCOME \\
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, WelcomeAdapter::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}