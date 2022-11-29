package edu.bo.ucb.express_app.Alarma

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.bo.ucb.express_app.Camara.CamaraAdapter
import edu.bo.ucb.express_app.Horario.HorarioAdapter
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

        // CAMBIAR VISTA DE ALARMA A HORARIO \\
        val horario = findViewById<View>(R.id.btn_horario) as Button
        horario.setOnClickListener {
            startActivity(Intent(this, HorarioAdapter::class.java))
        }

        // CAMBIAR VISTA DE ALARMA A CAMARA \\
        val camara = findViewById<View>(R.id.btn_camara) as Button
        camara.setOnClickListener {
            startActivity(Intent(this, CamaraAdapter::class.java))
        }
    }
}