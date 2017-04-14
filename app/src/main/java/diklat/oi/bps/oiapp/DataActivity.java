package diklat.oi.bps.oiapp;

import android.app.ActionBar;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import diklat.oi.bps.oiapp.fragments.ImageFragment;
import diklat.oi.bps.oiapp.fragments.SimpleFragment;
import diklat.oi.bps.oiapp.fragments.TableFragment;


public class DataActivity extends AppCompatActivity   {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    String data_file;
    String real_text;
    //0= menu, 1= menu kab, 2=menu kec
    Integer type_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        data_file=getIntent().getStringExtra("label_str");
        real_text=getIntent().getStringExtra("real_text");
        type_data=getIntent().getIntExtra("is_kab",0);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(real_text);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (DataActivity.this).finish();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Resources r = getResources();

        Bundle konsep=new Bundle();
        Bundle tabel=new Bundle();
        Bundle analisis=new Bundle();
        Bundle image_bundle=new Bundle();

        if(data_file.length()>0){
            if(type_data<2) {
                int konsepId = r.getIdentifier(data_file, "string", this.getPackageName());
                konsep.putString("txt_aboutus", r.getString(konsepId));

                if (type_data != 0)
                    tabel.putString("init", "kab_" + data_file);
                else
                    tabel.putString("init", data_file);

                int analisisId = r.getIdentifier("analisis_" + data_file, "string", this.getPackageName());
                analisis.putString("txt_aboutus", r.getString(analisisId));
                image_bundle.putString("rsc","info_"+data_file);
            }
            else{
                tabel.putString("init","kec_"+data_file);
            }
        }

        TableFragment tabel_frag=new TableFragment();
        tabel_frag.setArguments(tabel);

        if(type_data<2){
            SimpleFragment konsep_frag=new SimpleFragment();
            konsep_frag.setArguments(konsep);

            SimpleFragment analisis_frag=new SimpleFragment();
            analisis_frag.setArguments(analisis);

            adapter.addFragment(konsep_frag, "Konsep Definisi");
            adapter.addFragment(tabel_frag, "Tabel");
            adapter.addFragment(analisis_frag, "Analisis");

            if(type_data==0) {
                ImageFragment image_frag=new ImageFragment();
                image_frag.setArguments(image_bundle);

                adapter.addFragment(image_frag, "Infografis");
            }
        }
        else{
            adapter.addFragment(tabel_frag, "Tabel");
        }

        viewPager.setAdapter(adapter);
    }

    /*
    private MenuItem mSpinnerItem1 = null;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.aboutus_title_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.main, menu);
        mSpinnerItem1 = menu.findItem(R.id.spinner);
        View view1 = mSpinnerItem1.getActionView();
        if (view1 instanceof Spinner)
        {
            final Spinner spinner = (Spinner) view1;
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                }
            });
        }

        //View view1 = spinner getActionView();
        //spinner.setOnItemSelectedListener(onItemSelectedListener); // set the listener, to perform actions based on item selection
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }
    */
}
