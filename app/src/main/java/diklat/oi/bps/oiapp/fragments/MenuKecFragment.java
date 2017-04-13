package diklat.oi.bps.oiapp.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import diklat.oi.bps.oiapp.DataActivity;
import diklat.oi.bps.oiapp.R;
import diklat.oi.bps.oiapp.components.SimpleAdapter;
import diklat.oi.bps.oiapp.models.SimpleData;

public class MenuKecFragment extends ListFragment implements OnItemClickListener {

    ArrayAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.kecamatan_array, android.R.layout.simple_list_item_1);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        //Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        String data= (String)adapter.getItem(position);
        String temp_source=(data.toLowerCase()).replace(' ','_');
        Intent intent = new Intent(getActivity(), DataActivity.class);

        intent.putExtra("real_text", data);
        intent.putExtra("label_str", temp_source);
        intent.putExtra("is_kab",2);
        startActivity(intent);

    }
}