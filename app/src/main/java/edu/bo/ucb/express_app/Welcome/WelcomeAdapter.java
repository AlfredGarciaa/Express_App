package edu.bo.ucb.express_app.Welcome;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import edu.bo.ucb.express_app.Login.LoginAdapter;
import edu.bo.ucb.express_app.R;

public class WelcomeAdapter extends AppCompatActivity {
    private ImageView imagen;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // CAMBIAR VISTA DE WELCOME A LOG IN \\
        Button login;
        login = (Button)findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeAdapter.this, LoginAdapter.class);
                startActivity(i);
            }
        });

        imagen = findViewById(R.id.imagen_gif);
        String url= "https://www.apple.com/newsroom/images/product/app-store/Apple_App_Store_10th_anniversary_07102018_big.gif.large.gif";

        Uri urlparse = Uri.parse(url);
        Glide.with(getApplicationContext()).load(urlparse).into(imagen);
    }
}
