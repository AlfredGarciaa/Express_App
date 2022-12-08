package edu.bo.ucb.express_app.UserInterface.Alarma

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.bo.ucb.express_app.UserInterface.Menu.Menu
import edu.bo.ucb.express_app.R
import kotlinx.android.synthetic.main.activity_alarma.*

class AlarmaAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarma)

        // CAMBIAR A VISTA DE MATERIAS \\
        rateMeTextView.setOnClickListener {
            var dialog = CustomDialogFragment()

            dialog.show(supportFragmentManager, "customDialog")
        }

        // CAMBIAR VISTA DE ALARMA A MENU \\
        val menu = findViewById<View>(R.id.btn_menu) as Button
        menu.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
    }
}