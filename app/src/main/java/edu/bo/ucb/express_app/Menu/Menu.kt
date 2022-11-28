package edu.bo.ucb.express_app.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.bo.ucb.express_app.Galeria.GaleriaAdapter
import edu.bo.ucb.express_app.MainActivity
import edu.bo.ucb.express_app.R

class Menu : AppCompatActivity() {
    lateinit var rvButtons : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        rvButtons = findViewById(R.id.rv_buttons)
        val list = arrayListOf<Int>(
            R.drawable.configuraciones,
            R.drawable.alarmas,
            R.drawable.camara,
            R.drawable.contactos,
            R.drawable.galeria,
            R.drawable.horario,
        )

        val list2= arrayListOf<String>(
            getString(R.string.Configuraciones),
            getString(R.string.Alarmas),
            getString(R.string.Cámara),
            getString(R.string.Contactos),
            getString(R.string.Galeria),
            getString(R.string.Horario)
        )

        val list3= arrayListOf<Intent>(
            Intent(this, MainActivity::class.java) ,
            Intent(this, MainActivity::class.java),
            Intent(this, MainActivity::class.java),
            Intent(this, MainActivity::class.java),
            Intent(this, MainActivity::class.java),
            Intent(this, MainActivity::class.java),
        )

        val gridLayout = GridLayoutManager(this,2)
        gridLayout.orientation = GridLayoutManager.VERTICAL
        rvButtons.layoutManager = gridLayout
        rvButtons.adapter = MenuAdapter(list,list2,list3, applicationContext)

        // CAMBIAR VISTA DE MENU A GALERIA \\
        val galeria = findViewById<View>(R.id.btn_galeria) as Button
        galeria.setOnClickListener {
            startActivity(Intent(this, GaleriaAdapter::class.java))
        }
    }
}