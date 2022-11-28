package edu.bo.ucb.express_app.Contactos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import edu.bo.ucb.express_app.R

class ContactosAdapter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        // CAMBIAR VISTA DE CONTACTO A LISTA DE CONTACTOS \\
        val lista = findViewById<View>(R.id.addBoton) as Button
        lista.setOnClickListener {
            startActivity(Intent(this, ListaDeContactos::class.java))
        }
    }
}