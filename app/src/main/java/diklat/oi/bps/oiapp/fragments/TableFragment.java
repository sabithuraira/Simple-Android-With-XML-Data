package diklat.oi.bps.oiapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
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

public class TableFragment extends Fragment {

    String data="";
    Integer total_tabel=0;
    //TableLayout tbl_layout;
    LinearLayout rel_layout;

    public TableFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*
        GridView gridview = (GridView) getView().findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this.getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        */
        rel_layout = (LinearLayout) getView().findViewById(R.id.rel_layout);

        if (getArguments() != null) {
            this.data=this.getArguments().getString("init");

            Resources r = getResources();

            if(r.getIdentifier("data_title_"+this.data, "array", this.getActivity().getPackageName())==0){
                int current_index=1;

                while(r.getIdentifier("data_title_"+this.data+Integer.toString(current_index), "array", this.getActivity().getPackageName())!=0){
                    int titleId = r.getIdentifier("data_title_"+this.data+Integer.toString(current_index), "array", this.getActivity().getPackageName());
                    int dataId = r.getIdentifier("data_array_"+this.data+Integer.toString(current_index), "array", this.getActivity().getPackageName());

                    this.createTable(r.getStringArray(titleId),r.getStringArray(dataId));

                    ++current_index;
                }

            }
            else{
                int titleId = r.getIdentifier("data_title_"+this.data, "array", this.getActivity().getPackageName());
                int dataId = r.getIdentifier("data_array_"+this.data, "array", this.getActivity().getPackageName());

                this.createTable(r.getStringArray(titleId),r.getStringArray(dataId));
            }
        }
    }

    private void createTable(String[] title, String[] data){
        Integer total_var=0;
        total_var=title.length;

        TableLayout tbl_layout= new TableLayout(this.getActivity());
        //LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //lp.setMargins(5, 0, 5, 0);

        tbl_layout.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT ));
        tbl_layout.setStretchAllColumns(true);


        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = total_var-2;

        TableRow title_table = new TableRow(this.getActivity());


        TextView tv_title = new TextView(this.getActivity());
        tv_title.setTypeface(null, Typeface.BOLD);
        tv_title.setPadding(5,5,5,5);
        tv_title.setText(title[0]);
        //title_table.addView(tv_title);
        title_table.addView(tv_title, 0, params);


        //newRow2.addView(newButton, 1, params);
        tbl_layout.addView(title_table);


        TableRow tbrow0 = new TableRow(this.getActivity());
        for(int i=1;i<total_var-1;++i){
            TextView tv0 = new TextView(this.getActivity());
            tv0.setBackgroundResource(R.drawable.cell_shape);
            tv0.setTypeface(null, Typeface.BOLD);
            tv0.setPadding(5,5,5,5);
            tv0.setText(title[i]);
            tbrow0.addView(tv0);
        }
        tbl_layout.addView(tbrow0);

        for (int i = 0; i < data.length; i++) {
            TableRow tbrow = new TableRow(this.getActivity());

            String[] explode_data=data[i].split(";");

            for(int j=0;j<total_var-2;++j){
                TextView tv1 = new TextView(this.getActivity());

                tv1.setBackgroundResource(R.drawable.cell_shape);
                tv1.setPadding(5,5,5,5);
                tv1.setText(explode_data[j]);
                tv1.setGravity(Gravity.CENTER);
                tbrow.addView(tv1);
            }
            tbl_layout.addView(tbrow);
        }


        TableRow title_footer = new TableRow(this.getActivity());

        TextView tv_footer = new TextView(this.getActivity());
        tv_footer.setTypeface(null, Typeface.ITALIC);
        tv_footer.setPadding(5,5,5,5);
        tv_footer.setText(title[total_var-1]);
        //title_footer.addView(tv_footer);
        title_footer.addView(tv_footer,0, params);

        tbl_layout.addView(title_footer);

        rel_layout.addView(tbl_layout);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_table, container, false);
    }
}
