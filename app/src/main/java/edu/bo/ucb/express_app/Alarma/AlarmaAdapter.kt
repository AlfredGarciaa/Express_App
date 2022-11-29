package edu.bo.ucb.express_app.Alarma

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
    }
}