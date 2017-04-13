package diklat.oi.bps.oiapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import diklat.oi.bps.oiapp.fragments.MenuFragment;
import diklat.oi.bps.oiapp.fragments.OIListFragment;
import diklat.oi.bps.oiapp.fragments.SimpleFragment;

public class DataMenuActivity extends AppCompatActivity  {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    public Boolean is_root=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_bar_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((DataMenuActivity.this).is_root) {
                    (DataMenuActivity.this).finish();
                }
                else{
                    (DataMenuActivity.this).is_root=true;
                    Fragment frg = null;
                    frg = (getSupportFragmentManager().getFragments()).get(0);
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.detach(frg);
                    ft.attach(frg);
                    ft.commit();
                }

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        MenuFragment ttg_kami=new MenuFragment();
        adapter.addFragment(ttg_kami, "Data Strategis");

        viewPager.setAdapter(adapter);
    }
}
