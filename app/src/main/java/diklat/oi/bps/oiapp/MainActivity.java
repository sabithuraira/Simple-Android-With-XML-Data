package diklat.oi.bps.oiapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentPagerAdapter;
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

import diklat.oi.bps.oiapp.fragments.OIListFragment;
import diklat.oi.bps.oiapp.fragments.SimpleFragment;

public class MainActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Bundle bundle_ttg_kami = new Bundle();
        bundle_ttg_kami.putString("caption", "aboutus" );
        OIListFragment ttg_kami=new OIListFragment();
        ttg_kami.setArguments(bundle_ttg_kami);
        adapter.addFragment(ttg_kami, "Tentang Kami");

        Bundle bundle_ttg_oi = new Bundle();
        bundle_ttg_oi.putString("caption", "aboutoi" );
        OIListFragment ttg_oi=new OIListFragment();
        ttg_oi.setArguments(bundle_ttg_oi);
        adapter.addFragment(ttg_oi, "Tentang Ogan Ilir");
        viewPager.setAdapter(adapter);
    }
}