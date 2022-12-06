package edu.bo.ucb.express_app.Login

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import edu.bo.ucb.express_app.Menu.Menu
import edu.bo.ucb.express_app.R
import edu.bo.ucb.express_app.Welcome.WelcomeAdapter
import kotlinx.android.synthetic.main.activity_login.*

class LoginAdapter : AppCompatActivity() {

    protected lateinit var vv_fondo: VideoView
    protected lateinit var mMediaPlayer: MediaPlayer
    protected var mCurrentVideoPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        vv_fondo = findViewById<VideoView>(R.id.vv_fondo)
        val uri = Uri.parse("android.resource://"
                +packageName
                +"/"
                +R.raw.cascada)

        vv_fondo.setVideoURI(uri)
        vv_fondo.start()
        vv_fondo.setOnPreparedListener { mp ->
            mMediaPlayer = mp
            mMediaPlayer.isLooping = true
            if (mCurrentVideoPosition != 0) {
                mMediaPlayer.seekTo(mCurrentVideoPosition)

                mMediaPlayer.start()
            }
        }

        // Setup \\
        setup()

        // CAMBIAR VISTA DE LOGIN A WELCOME \\
        val welcome = findViewById<View>(R.id.btn_welcome) as Button
        welcome.setOnClickListener {
            startActivity(Intent(this, WelcomeAdapter::class.java))
        }

        /*
        // CAMBIAR VISTA DE LOGIN A MENU -> AL LOGEARSE \\
        val menu = findViewById<View>(R.id.btn_menu) as Button
        menu.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
        */
    }

    private fun setup() {
        btn_register.setOnClickListener {
            if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    emailEditText.text.toString(), passwordEditText.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showMenu(it.result?.user?.email ?: "")
                    } else {
                        showAlert()
                    }
                }
            }
        }
        btn_acceder.setOnClickListener {
            if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    emailEditText.text.toString(), passwordEditText.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val menu = findViewById<View>(R.id.btn_menu) as Button
                        menu.setOnClickListener {
                            startActivity(Intent(this, Menu::class.java))
                        }
                    } else {
                        showAlert()
                    }
                }
            }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showMenu(email: String) {
        val menuIntent = Intent(this, Menu::class.java).apply {
            putExtra("email", email)
        }
        startActivity(menuIntent)
    }

    override fun onPause() {
        super.onPause()
        mCurrentVideoPosition = mMediaPlayer.currentPosition
        vv_fondo.pause()
    }

    override fun onResume() {
        super.onResume()
        vv_fondo.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMediaPlayer.release()
        //mMediaPlayer = null
    }
}