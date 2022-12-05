package edu.bo.ucb.express_app.Contactos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.bo.ucb.express_app.Menu.Menu
import edu.bo.ucb.express_app.R

class ContactosAdapter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        // CAMBIAR VISTA DE CONTACTOS A MENU \\
        val menu = findViewById<View>(R.id.btn_menu) as Button
        menu.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }

        // CAMBIAR VISTA DE CONTACTOS A LISTA DE CONTACTOS \\
        val lista = findViewById<View>(R.id.btn_lista_contactos) as Button
        lista.setOnClickListener {
            startActivity(Intent(this, ListaDeContactos::class.java))
        }
    }
}