package edu.bo.ucb.express_app.Camara

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import edu.bo.ucb.express_app.Menu.Menu
import edu.bo.ucb.express_app.R
import edu.bo.ucb.express_app.databinding.ActivityCamaraBinding
import kotlinx.android.synthetic.main.activity_camara.*

class CamaraAdapter : AppCompatActivity() {
    private val CAMARA_REQUEST_CODE: Int = 23
    private val PERMISO_CAMARA: Int = 99
    lateinit var binding: ActivityCamaraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCamaraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btn_take_photo.setOnClickListener {
                solicitarPermisos()
            }
        }

        // CAMBIAR VISTA DE CAMARA A MENU \\
        val menu = findViewById<View>(R.id.btn_menu) as Button
        menu.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
    }

    private fun solicitarPermisos() {
        when {
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED -> {
                tomarFoto()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                mostrarMensaje("El permiso fue rechazado previamente, habilitar en los ajustes")
            }
            else -> {
                requestPermissions(arrayOf(Manifest.permission.CAMERA), PERMISO_CAMARA)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISO_CAMARA -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    tomarFoto()
                }
            }
            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
    }

    private fun tomarFoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMARA_REQUEST_CODE)
    }

    fun mostrarMensaje(mensaje: String) {
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            CAMARA_REQUEST_CODE -> {
                if (resultCode != Activity.RESULT_OK) {
                    mostrarMensaje("NO SE TOMO FOTO")
                } else {
                    val bitmap = data?.extras?.get("data") as Bitmap
                    with(binding) {
                        shapeableImageView.setImageBitmap(bitmap)
                    }
                }
            }
        }
    }
}