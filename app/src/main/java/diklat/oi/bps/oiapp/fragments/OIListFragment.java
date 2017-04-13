package diklat.oi.bps.oiapp.fragments;

import android.annotation.SuppressLint;
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

import diklat.oi.bps.oiapp.R;
import diklat.oi.bps.oiapp.components.SimpleAdapter;
import diklat.oi.bps.oiapp.models.SimpleData;

public class OIListFragment extends ListFragment implements OnItemClickListener {
    private List<SimpleData> datas=new ArrayList<SimpleData>();
    private String key_bundle="";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.planets_array, android.R.layout.simple_list_item_1);
        */

        if (getArguments() != null) {
            this.key_bundle=this.getArguments().getString("caption");
        }

        if(this.key_bundle.length()>5){
            Resources r = getResources();
            int titleId = r.getIdentifier(this.key_bundle+"_title_array", "array", this.getActivity().getPackageName());
            int dataId = r.getIdentifier(this.key_bundle+"_data_array", "array", this.getActivity().getPackageName());


            String[] title= r.getStringArray(titleId);
            String[] deskripsi=r.getStringArray(dataId);

            for(int i=0;i<title.length;++i){
                datas.add(new SimpleData(title[i],deskripsi[i]));
            }
        }
        else
        {

        }

        SimpleAdapter adapter=new SimpleAdapter(this.getActivity(), datas);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }
}