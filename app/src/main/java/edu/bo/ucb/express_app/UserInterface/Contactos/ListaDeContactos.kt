package edu.bo.ucb.express_app.UserInterface.Contactos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import edu.bo.ucb.express_app.R

class ListaDeContactos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_contactos)

        // CAMBIAR VISTA DE LISTA A CONTACTOS \\
        val contactos = findViewById<View>(R.id.btn_contactos) as Button
        contactos.setOnClickListener {
            startActivity(Intent(this, ContactosAdapter::class.java))
        }
    }
}