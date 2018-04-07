package diklat.com.bps.sihaluan.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import diklat.com.bps.sihaluan.R;
/**
 * Created by sabithuraira on 3/2/17.
 */

public class ImageFragment extends Fragment {
    private ImageView img_infografis;
    private String rsc;

    public ImageFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.rsc=this.getArguments().getString("rsc");

        img_infografis=(ImageView) getView().findViewById(R.id.img_infografis);

        Resources r = getResources();
        if(r.getIdentifier(this.rsc, "mipmap", this.getActivity().getPackageName())==0){
            img_infografis.setImageResource(R.mipmap.foto_belum_tersedia);
        }
        else{
            img_infografis.setImageResource(r.getIdentifier(this.rsc, "mipmap", this.getActivity().getPackageName()));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }
}
