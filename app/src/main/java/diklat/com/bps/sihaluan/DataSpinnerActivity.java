package diklat.com.bps.sihaluan;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import diklat.com.bps.sihaluan.fragments.ImageFragment;
import diklat.com.bps.sihaluan.fragments.TableFragment;

public class DataSpinnerActivity extends AppCompatActivity {
    private String[] listDataHeader = {};

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    Spinner bar_spinner_data;

    String data_file;
    String real_text;
    int current_index = 0;
    //0= menu, 1= menu kab, 2=menu kec
    Integer type_data;


    TableFragment tabel_frag=new TableFragment();
    ImageFragment image_frag=new ImageFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_spinner);

        Resources r = getResources();

        listDataHeader = r.getStringArray(R.array.dinas_menu_array);

//        this.getResources().getStringArray(R.array.dinas_menu_array);

        bar_spinner_data = (Spinner) findViewById(R.id.bar_spinner_data);
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        SetToolbar();

        CreateData();
    }

    private void CreateData(){
        String temp_source= (listDataHeader[current_index].toLowerCase()).replace(' ','_');
        data_file = temp_source;
        real_text = listDataHeader[current_index];
        type_data = 0;

        setupViewPager(viewPager);

        if(type_data==0) {
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
        tabLayout.setupWithViewPager(viewPager);
    }

    private void RefreshData(){
        String temp_source= (listDataHeader[current_index].toLowerCase()).replace(' ','_');
        data_file = temp_source;
        tabel_frag.SetArgument(data_file, "json", "dinas");
        tabel_frag.RefreshView();
    }

    private void SetToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (DataSpinnerActivity.this).finish();
            }
        });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.dinas_menu_array, R.layout.top_spinner);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bar_spinner_data.setAdapter(adapter);

        bar_spinner_data.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                current_index = position;
                RefreshData();
            }

            public void onNothingSelected(AdapterView<?> arg0) {}
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Resources r = getResources();

//        Bundle konsep=new Bundle();
        Bundle tabel=new Bundle();
//        Bundle analisis=new Bundle();
//        Bundle image_bundle=new Bundle();

        if(data_file.length()>0){
            if(type_data<2) {
//                int konsepId = r.getIdentifier(data_file, "string", this.getPackageName());
//                konsep.putString("txt_aboutus", r.getString(konsepId));

                if (type_data != 0)
                    tabel.putString("init", "kab_" + data_file);
                else
                    tabel.putString("init", data_file);

//                int analisisId = r.getIdentifier("analisis_" + data_file, "string", this.getPackageName());
//                analisis.putString("txt_aboutus", r.getString(analisisId));
//                image_bundle.putString("rsc","info_"+data_file);
            }
            else{
                tabel.putString("init","kec_"+data_file);
            }
            tabel.putString("type_data", "json");
        }

//        TableFragment tabel_frag=new TableFragment();
        tabel_frag.setArguments(tabel);


        if(type_data<2){
//            SimpleFragment konsep_frag=new SimpleFragment();
//            konsep_frag.setArguments(konsep);

//            SimpleFragment analisis_frag=new SimpleFragment();
//            analisis_frag.setArguments(analisis);

//            adapter.addFragment(konsep_frag, "Konsep Definisi");
            adapter.addFragment(tabel_frag, "Tabel");
//            adapter.addFragment(analisis_frag, "Analisis");

//            if(type_data==0) {
//                ImageFragment image_frag=new ImageFragment();
//                image_frag.setArguments(image_bundle);

//                adapter.addFragment(image_frag, "Infografis");
//            }
        }
        else{
            adapter.addFragment(tabel_frag, "Tabel");
        }

        viewPager.setAdapter(adapter);
    }
}
