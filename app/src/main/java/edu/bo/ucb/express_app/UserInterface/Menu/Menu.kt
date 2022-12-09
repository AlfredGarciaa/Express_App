package edu.bo.ucb.express_app.UserInterface.Menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.bo.ucb.express_app.R
import edu.bo.ucb.express_app.UserInterface.Agradecimientos.Docente
import edu.bo.ucb.express_app.UserInterface.Alarma.AlarmaAdapter
import edu.bo.ucb.express_app.UserInterface.Camara.CamaraAdapter
import edu.bo.ucb.express_app.UserInterface.Contactos.ContactosAdapter
import edu.bo.ucb.express_app.UserInterface.Galeria.GaleriaAdapter
import edu.bo.ucb.express_app.UserInterface.Horario.HorarioAdapter
import edu.bo.ucb.express_app.UserInterface.Login.LoginAdapter
import edu.bo.ucb.express_app.UserInterface.Pokemon.PokemonActivity

class Menu : AppCompatActivity() {
    lateinit var rvButtons : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        rvButtons = findViewById(R.id.rv_buttons)
        val list = arrayListOf<Int>(
            R.drawable.cerrar_sesion,
            R.drawable.alarmas,
            R.drawable.camara,
            R.drawable.contactos,
            R.drawable.galeria,
            R.drawable.horario,
            R.drawable.pokedex,
            R.drawable.correo,
        )

        val list2= arrayListOf<String>(
            getString(R.string.cerrar_sesion),
            getString(R.string.Alarmas),
            getString(R.string.Cámara),
            getString(R.string.Contactos),
            getString(R.string.Galeria),
            getString(R.string.Horario),
            getString(R.string.title_pokemon),
            getString(R.string.title_agradecimiento),
        )

        val list3= arrayListOf<Intent>(
            Intent(this, LoginAdapter::class.java),
            Intent(this, AlarmaAdapter::class.java),
            Intent(this, CamaraAdapter::class.java),
            Intent(this, ContactosAdapter::class.java),
            Intent(this, GaleriaAdapter::class.java),
            Intent(this, HorarioAdapter::class.java),
            Intent(this, PokemonActivity::class.java),
            Intent(this, Docente::class.java),
        )

        val gridLayout = GridLayoutManager(this,2)
        gridLayout.orientation = GridLayoutManager.VERTICAL
        rvButtons.layoutManager = gridLayout
        rvButtons.adapter = MenuAdapter(list,list2,list3, applicationContext)
    }
}