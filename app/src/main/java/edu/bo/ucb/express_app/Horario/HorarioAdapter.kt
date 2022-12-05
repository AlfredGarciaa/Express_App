package edu.bo.ucb.express_app.Horario

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.bo.ucb.express_app.R

class HorarioAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horario)

        // CAMBIAR VISTA DE HORARIO A MENU \\
        val menu = findViewById<View>(R.id.btn_menu) as Button
        menu.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
    }

    //Método para mostrar y ocultar el menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> {
                Toast.makeText(this, "Buscar",Toast.LENGTH_SHORT).show()

                return true
            }
            R.id.action_share -> {
                Toast.makeText(this, "Compartir",Toast.LENGTH_SHORT).show()

                return true
            }
            R.id.item1->{
                Toast.makeText(this, "Ajustes",Toast.LENGTH_SHORT).show()

                return true
            }
            R.id.item2->{
                Toast.makeText(this, "Administrar horario",Toast.LENGTH_SHORT).show()

                return true
            }
            R.id.item3->{
                Toast.makeText(this, "Eliminar",Toast.LENGTH_SHORT).show()

                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}