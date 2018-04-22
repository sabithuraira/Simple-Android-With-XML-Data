package diklat.com.bps.sihaluan;

import android.os.Bundle;
import android.view.View;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import diklat.com.bps.sihaluan.fragments.MenuFragment;

public class DataMenuActivity extends AppCompatActivity  {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    //public Boolean is_root=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_bar_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.orange));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (DataMenuActivity.this).finish();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.orange));
        tabLayout.setupWithViewPager(viewPager);

        /*
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
        */
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        MenuFragment ttg_kami=new MenuFragment();
        adapter.addFragment(ttg_kami, "Data Strategis");

        viewPager.setAdapter(adapter);
    }
}
