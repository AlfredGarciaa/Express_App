package edu.bo.ucb.express_app.UserInterface.Menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.bo.ucb.express_app.R
import edu.bo.ucb.express_app.UserInterface.Alarma.AlarmaAdapter
import edu.bo.ucb.express_app.UserInterface.Camara.CamaraAdapter
import edu.bo.ucb.express_app.UserInterface.Contactos.ContactosAdapter
import edu.bo.ucb.express_app.UserInterface.Galeria.GaleriaAdapter
import edu.bo.ucb.express_app.UserInterface.Horario.HorarioAdapter
import edu.bo.ucb.express_app.UserInterface.Retrofit

class Menu : AppCompatActivity() {
    lateinit var rvButtons : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        rvButtons = findViewById(R.id.rv_buttons)
        val list = arrayListOf<Int>(
            R.drawable.retrofit,
            R.drawable.alarmas,
            R.drawable.camara,
            R.drawable.contactos,
            R.drawable.galeria,
            R.drawable.horario,
        )

        val list2= arrayListOf<String>(
            getString(R.string.Retrofit),
            getString(R.string.Alarmas),
            getString(R.string.Cámara),
            getString(R.string.Contactos),
            getString(R.string.Galeria),
            getString(R.string.Horario),
        )

        val list3= arrayListOf<Intent>(
            Intent(this, Retrofit::class.java),
            Intent(this, AlarmaAdapter::class.java),
            Intent(this, CamaraAdapter::class.java),
            Intent(this, ContactosAdapter::class.java),
            Intent(this, GaleriaAdapter::class.java),
            Intent(this, HorarioAdapter::class.java),
        )

        val gridLayout = GridLayoutManager(this,2)
        gridLayout.orientation = GridLayoutManager.VERTICAL
        rvButtons.layoutManager = gridLayout
        rvButtons.adapter = MenuAdapter(list,list2,list3, applicationContext)
    }
}