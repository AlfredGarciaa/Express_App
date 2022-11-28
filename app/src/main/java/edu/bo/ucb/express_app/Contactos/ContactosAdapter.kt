package edu.bo.ucb.express_app.Contactos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import edu.bo.ucb.express_app.Horario.HorarioAdapter
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
        val horario = findViewById<View>(R.id.btn_horario) as Button
        horario.setOnClickListener {
            startActivity(Intent(this, HorarioAdapter::class.java))
        }
    }
}