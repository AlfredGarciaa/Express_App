package edu.bo.ucb.express_app.Galeria;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import edu.bo.ucb.express_app.R;

public class GaleriaFotosAdapter extends BaseAdapter {
    private Context mContext;
    public int[] imageArray = {
            R.drawable.matematicas,
            R.drawable.fisica,
            R.drawable.quimica,
            R.drawable.literatura,
            R.drawable.docente1,
            R.drawable.docente2,
            R.drawable.artes_plasticas,
            R.drawable.musica,
            R.drawable.historia,
            R.drawable.educacion_fisica,
            R.drawable.filosofia,
            R.drawable.superacion1,
            R.drawable.trabajo_equipo1,
            R.drawable.superacion2,
            R.drawable.trabajo_equipo2,
            R.drawable.trabajo_equipo3,
    };

    public GaleriaFotosAdapter(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public int getCount() {

        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {

        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(340, 350));

        return imageView;
    }
}