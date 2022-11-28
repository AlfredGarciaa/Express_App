package edu.bo.ucb.express_app.Contactos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import edu.bo.ucb.express_app.Galeria.GaleriaAdapter
import edu.bo.ucb.express_app.R

class ContactosAdapter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        // CAMBIAR VISTA DE CONTACTOS A LISTA \\
        val lista = findViewById<View>(R.id.btn_lista_contactos) as Button
        lista.setOnClickListener {
            startActivity(Intent(this, ListaDeContactos::class.java))
        }

        // CAMBIAR VISTA DE MENU A CONTACTOS \\
        val galeria = findViewById<View>(R.id.btn_galeria) as Button
        galeria.setOnClickListener {
            startActivity(Intent(this, GaleriaAdapter::class.java))
        }
    }
}