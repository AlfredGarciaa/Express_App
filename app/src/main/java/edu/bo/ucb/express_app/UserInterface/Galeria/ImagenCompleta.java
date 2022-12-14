package edu.bo.ucb.express_app.UserInterface.Galeria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.bo.ucb.express_app.R;

public class ImagenCompleta extends AppCompatActivity {
    ImageView imageView;
    GaleriaFotosAdapter galeriaFotosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_completa);

        imageView = (ImageView)findViewById(R.id.iv_foto);

        Intent intent = getIntent();
        int posicion = intent.getExtras().getInt("misImagenes");
        galeriaFotosAdapter = new GaleriaFotosAdapter(this);
        imageView.setImageResource(galeriaFotosAdapter.imageArray[posicion]);

        // CAMBIAR VISTA DE IMAGEN COMPLETA A GALERIA \\
        Button menu;
        menu = (Button)findViewById(R.id.btn_menu);

        menu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(ImagenCompleta.this, GaleriaAdapter.class);
                startActivity(i);
            }
        });
    }
}