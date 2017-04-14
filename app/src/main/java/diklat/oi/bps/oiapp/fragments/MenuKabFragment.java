package diklat.oi.bps.oiapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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
import diklat.oi.bps.oiapp.R;
import diklat.oi.bps.oiapp.components.ExpendableAdapter;
import diklat.oi.bps.oiapp.components.ImageAdapter;
/**
 * Created by sabithuraira on 3/2/17.
 */

public class MenuKabFragment extends Fragment {
    private String[] listDataHeader={
            "Pemerintahan", "Penduduk", "Pendidikan", "Kesehatan", "Pertanian", "Industri dan Pertambangan"
    };

    private GridView gridview;

    public MenuKabFragment(){}

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
                String temp_source=(listDataHeader[position].toLowerCase()).replace(' ','_');
                Intent intent = new Intent(getActivity(), DataActivity.class);
                intent.putExtra("real_text", listDataHeader[position]);
                intent.putExtra("label_str", temp_source);
                intent.putExtra("is_kab",1);
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    /*
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;

    private String[] listDataHeader={
            "Pemerintahan", "Penduduk", "Pendidikan", "Kesehatan", "Pertanian", "Industri dan Pertambangan"
    };

    private String[][] listDataChild={
            {"Wilayah"},
            {"Jumlah Penduduk", "Kepadatan Penduduk", "Rasio Jenis Kelamin"},
            {"Jumlah Sekolah", "Jumlah Guru","Jumlah Murid"},
            {"Sarana Kesehatan", "Tenaga Kesehatan", "KB"},
            {"Tanaman Pangan", "Perkebunan", "Peternakan", "Perikanan"},
            {"Industri"},
    };

    public MenuKabFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        expListView = (ExpandableListView) getView().findViewById(R.id.expList);
        listAdapter = new ExpendableAdapter(this.getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String temp_source=(listDataChild[groupPosition][childPosition].toLowerCase()).replace(' ','_');
                Intent intent = new Intent(getActivity(), DataActivity.class);

                intent.putExtra("real_text", listDataChild[groupPosition][childPosition]);
                intent.putExtra("label_str", temp_source);
                intent.putExtra("is_kab",1);
                startActivity(intent);

                return false;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_kab, container, false);
    }
    */
}
