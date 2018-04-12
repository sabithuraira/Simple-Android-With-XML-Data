package diklat.com.bps.sihaluan.fragments;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import diklat.com.bps.sihaluan.R;
import diklat.com.bps.sihaluan.helpers.JsonGetter;
import diklat.com.bps.sihaluan.models.TitleIsi;
import diklat.com.bps.sihaluan.models.TitleTable;

/**
 * Created by sabithuraira on 3/2/17.
 */

public class TableFragment extends Fragment {
    String data="";
    String type_data = "xml";
    String category_data = "dinas";
    Integer total_tabel=0;
    //TableLayout tbl_layout;
    LinearLayout rel_layout;

    public TableFragment(){}

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
            SetArgument(this.getArguments().getString("init", "pemerintahan"), this.getArguments().getString("type_data", "xml"), this.getArguments().getString("category_data", "dinas"));
        }
        RefreshView();
    }

    public void SetArgument(String init, String type_data, String category_data){
        this.data = init;
        this.type_data = type_data;
        this.category_data = category_data;
    }

    public void RefreshView(){
        rel_layout.removeAllViews();
        if(type_data=="json"){
            JsonGetter jGet = new JsonGetter(this.getActivity());

            TitleTable[] titleTables= {};
            TitleIsi[] titleIsis = {};

            if(category_data=="dinas") {
                titleTables = jGet.getDinasTitle(this.data);
                titleIsis = jGet.getDinasIsi(this.data);
            }
            else{
                titleTables = jGet.getStatDasarTitle(this.data);
                titleIsis = jGet.getStatDasarIsi(this.data);
            }


            if (titleTables != null) {
                for (int i = 0; i < titleTables.length; ++i) {
                    this.createTableFromJson(titleTables[i], titleIsis[i]);
                }
            }
        }
        else{
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

    private void createTableFromJson(TitleTable title, TitleIsi isi){
        Integer total_var=0;
        String[] headers = title.getHeader();
        String[] data = isi.getData();
        total_var=title.getHeader().length;

        ScrollView scrollView=new ScrollView(this.getActivity());
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT ));


        HorizontalScrollView hscrollView=new HorizontalScrollView(this.getActivity());
        hscrollView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT ));

        TableLayout tbl_layout= new TableLayout(this.getActivity());

        tbl_layout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT ));
        tbl_layout.setStretchAllColumns(true);


        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = total_var;

        TableRow title_table = new TableRow(this.getActivity());


        TextView tv_title = new TextView(this.getActivity());
        tv_title.setTypeface(null, Typeface.BOLD);
        tv_title.setPadding(5,5,5,5);
        tv_title.setText(title.getTitle());
        //title_table.addView(tv_title);
        title_table.addView(tv_title, 0, params);


        //newRow2.addView(newButton, 1, params);
        tbl_layout.addView(title_table);


        TableRow tbrow0 = new TableRow(this.getActivity());
        for(int i=0;i<total_var;++i){
            TextView tv0 = new TextView(this.getActivity());
            tv0.setBackgroundResource(R.drawable.cell_shape);
            tv0.setTypeface(null, Typeface.BOLD);
            tv0.setPadding(10,5,10,5);
            tv0.setGravity(Gravity.CENTER);
            tv0.setText(headers[i]);
            tbrow0.addView(tv0);
        }
        tbl_layout.addView(tbrow0);

        for (int i = 0; i < data.length; i++) {
            TableRow tbrow = new TableRow(this.getActivity());

            String[] explode_data=data[i].split(";");

            for(int j=0;j<total_var;++j){
                TextView tv1 = new TextView(this.getActivity());

                tv1.setBackgroundResource(R.drawable.cell_shape);
                tv1.setPadding(10,5,10,5);
                if(explode_data.length<=j){
                    tv1.setText("");
                }
                else{
                    tv1.setText(explode_data[j]);
                }
                tv1.setGravity(Gravity.CENTER);
                tbrow.addView(tv1);
            }
            tbl_layout.addView(tbrow);
        }


//        TableRow title_footer = new TableRow(this.getActivity());

//        TextView tv_footer = new TextView(this.getActivity());
//        tv_footer.setTypeface(null, Typeface.ITALIC);
//        tv_footer.setPadding(5,5,5,5);
//        tv_footer.setText(title[total_var-1]);
//        //title_footer.addView(tv_footer);
//        title_footer.addView(tv_footer,0, params);

//        tbl_layout.addView(title_footer);

        hscrollView.addView(tbl_layout);
        scrollView.addView(hscrollView);
        rel_layout.addView(scrollView);
    }

    private void createTable(String[] title, String[] data){
        Integer total_var=0;
        total_var=title.length;

        ScrollView scrollView=new ScrollView(this.getActivity());
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT ));


        HorizontalScrollView hscrollView=new HorizontalScrollView(this.getActivity());
        hscrollView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT ));

        TableLayout tbl_layout= new TableLayout(this.getActivity());

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
            tv0.setPadding(10,5,10,5);
            tv0.setGravity(Gravity.CENTER);
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
                tv1.setPadding(10,5,10,5);
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

        hscrollView.addView(tbl_layout);
        scrollView.addView(hscrollView);
        rel_layout.addView(scrollView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_table, container, false);
    }
}
