package edu.bo.ucb.express_app.UserInterface.Agradecimientos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.bo.ucb.express_app.R
import edu.bo.ucb.express_app.UserInterface.Menu.Menu

class Docente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_docente)

        // CAMBIAR VISTA DE AGRADECIMIENTO A MENU \\
        val menu = findViewById<View>(R.id.btn_menu) as Button
        menu.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
    }
}