package edu.bo.ucb.express_app.Camara

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import edu.bo.ucb.express_app.Alarma.AlarmaAdapter
import edu.bo.ucb.express_app.Galeria.GaleriaAdapter
import edu.bo.ucb.express_app.R
import edu.bo.ucb.express_app.databinding.ActivityCamaraBinding

class CamaraAdapter : AppCompatActivity() {
    private lateinit var binding: ActivityCamaraBinding
    val REQUEST_CODE_TAKE_PHOTO = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camara)

        binding = ActivityCamaraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()

        // CAMBIAR VISTA DE CAMARA A ALARMA \\
        val alarma = findViewById<View>(R.id.btn_alarma) as Button
        alarma.setOnClickListener {
            startActivity(Intent(this, AlarmaAdapter::class.java))
        }

        // CAMBIAR VISTA DE CAMARA A GALERIA \\
        val galeria = findViewById<View>(R.id.btn_galeria) as Button
        galeria.setOnClickListener {
            startActivity(Intent(this, GaleriaAdapter::class.java))
        }
    }

    private fun setupListener() {
        binding.btnTakePhoto.setOnClickListener {
            openActivityForResult()
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePicture ->
            takePicture.resolveActivity(packageManager)?.also {
                openActivityForResult()
            }
        }
    }

    fun openActivityForResult() {
        startForResult.launch(Intent(this, CamaraAdapter::class.java))
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // Handle the Intent
            //do stuff here
        }
    }
}