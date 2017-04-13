package diklat.oi.bps.oiapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import diklat.oi.bps.oiapp.DataActivity;
import diklat.oi.bps.oiapp.DataMenuActivity;
import diklat.oi.bps.oiapp.R;
import diklat.oi.bps.oiapp.components.ExpendableAdapter;
import diklat.oi.bps.oiapp.components.ImageAdapter;
/**
 * Created by sabithuraira on 3/2/17.
 */

public class MenuFragment extends Fragment {

    private Integer parent_position=0;
    private String[] listDataHeader={
            "Pemerintahan", "Penduduk", "Ketenagakerjaan", "Kemiskinan", "IPM",
            "Pendidikan", "Kesehatan", "Pertanian", "Industri dan Pertambangan",
            "Infrastruktur", "PDRB"
    };

    private String[][] listDataChild={
            {"Wilayah", "PNS", "DPRD"},
            {"Jumlah Penduduk", "Kepadatan Penduduk", "Rasio Jenis Kelamin"},
            {"Angkatan Kerja", "Pengangguran"},
            {"Kemiskinan", "Garis Kemiskinan"},
            {"IPM", "Angka Harapan Hidup", "Lama Sekolah", "Pengeluaran"},
            {"Jumlah Sekolah", "Jumlah Guru","Jumlah Murid", "APS","APM","APK"},
            {"Sarana Kesehatan", "Tenaga Kesehatan", "KB"},
            {"Tanaman Pangan", "Perkebunan", "Peternakan", "Perikanan"},
            {"Industri", "Pertambangan"},
            {"Jalan"},
            {"PDRB", "PDRB ADHB", "PDRB ADHK", "PDRB Lapangan Usaha", "PDRB Pengeluaran", "Pertumbuhan Ekonomi", "Distribusi Persentase"}
    };

    private GridView gridview;

    public MenuFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gridview = (GridView) getView().findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this.getActivity(), this.listDataHeader));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                DataMenuActivity activity = (DataMenuActivity) getActivity();

                if(activity.is_root){
                    activity.is_root=false;
                    (MenuFragment.this).parent_position=position;
                    (MenuFragment.this).gridview.setAdapter(new ImageAdapter(getActivity(), (MenuFragment.this).listDataChild[position]));
                }
                else{
                    String temp_source=(listDataChild[parent_position][position].toLowerCase()).replace(' ','_');
                    Intent intent = new Intent(getActivity(), DataActivity.class);
                    intent.putExtra("real_text", listDataChild[parent_position][position]);
                    intent.putExtra("label_str", temp_source);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }
}