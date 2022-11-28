package edu.bo.ucb.express_app.Galeria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import edu.bo.ucb.express_app.R;

public class GaleriaAdapter extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        gridView = (GridView)findViewById(R.id.gv_imagenes);
        gridView.setAdapter(new GaleriaFotosAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ImagenCompleta.class);
                intent.putExtra("misImagenes", position);
                startActivity(intent);
            }
        });
    }
}
