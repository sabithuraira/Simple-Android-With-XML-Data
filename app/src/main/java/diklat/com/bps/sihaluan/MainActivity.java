package diklat.com.bps.sihaluan;


import android.support.v7.widget.Toolbar;
import android.view.View;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import diklat.com.bps.sihaluan.fragments.OIListFragment;

public class MainActivity extends AppCompatActivity { //BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (MainActivity.this).finish();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        Bundle bundle_ttg_simanis = new Bundle();
        bundle_ttg_simanis.putString("caption", "aboutsimanis" );
        OIListFragment ttg_simanis=new OIListFragment();
        ttg_simanis.setArguments(bundle_ttg_simanis);
        adapter.addFragment(ttg_simanis, "SIHALUAN OKUT");

        Bundle bundle_ttg_kami = new Bundle();
        bundle_ttg_kami.putString("caption", "aboutus" );
        OIListFragment ttg_kami=new OIListFragment();
        ttg_kami.setArguments(bundle_ttg_kami);
        adapter.addFragment(ttg_kami, "Tentang Kami");

        Bundle bundle_ttg_oi = new Bundle();
        bundle_ttg_oi.putString("caption", "aboutoi" );
        OIListFragment ttg_oi=new OIListFragment();
        ttg_oi.setArguments(bundle_ttg_oi);
        adapter.addFragment(ttg_oi, "Tentang OKU Timur");
        viewPager.setAdapter(adapter);
    }
}
