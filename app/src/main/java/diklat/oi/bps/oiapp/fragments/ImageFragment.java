package diklat.oi.bps.oiapp.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import diklat.oi.bps.oiapp.R;
/**
 * Created by sabithuraira on 3/2/17.
 */

public class ImageFragment extends Fragment {
    private ImageView img_infografis;

    public ImageFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        img_infografis=(ImageView) getView().findViewById(R.id.img_infografis);
        img_infografis.setImageResource(R.mipmap.info_pariwisata);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }
}
