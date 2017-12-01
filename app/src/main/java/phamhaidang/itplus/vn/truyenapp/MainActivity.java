package phamhaidang.itplus.vn.truyenapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import phamhaidang.itplus.vn.truyenapp.Fragment.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager mainpager;
    TabLayout mainmnbottom, mainmntop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();

    }

    private void initView() {
        mainpager = (ViewPager) findViewById(R.id.mainpager);
        mainmnbottom = (TabLayout) findViewById(R.id.mainmnbottom);

        mainmnbottom.addTab(mainmnbottom.newTab().setIcon(R.drawable.mncalendar).setText("Lastest"));
        mainmnbottom.addTab(mainmnbottom.newTab().setIcon(R.drawable.mncategory).setText("Category"));
        mainmnbottom.addTab(mainmnbottom.newTab().setIcon(R.drawable.mnsearch).setText("Search"));
        mainmnbottom.addTab(mainmnbottom.newTab().setIcon(R.drawable.mndownload).setText("Download"));
        mainmnbottom.addTab(mainmnbottom.newTab().setIcon(R.drawable.mnfavorite).setText("Favorite"));

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        pagerAdapter.addFragment(new LastestFragment());
        pagerAdapter.addFragment(new CategoryFragment());
        pagerAdapter.addFragment(new SearchFragment());
        pagerAdapter.addFragment(new DownloadFragment());
        pagerAdapter.addFragment(new FavoriteFragment());

        mainpager.setAdapter(pagerAdapter);
        this.getSupportFragmentManager().beginTransaction().replace(R.id.maintoptab, new LastestToolbar()).commit();

    }

    private void initListener() {
        mainpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainmnbottom));
        mainmnbottom.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mainpager));
        mainmnbottom.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Temp.tabid = tab.getPosition();
                switch (tab.getPosition()) {
                    case 0:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.maintoptab, new LastestToolbar()).commit();
                        Log.d("tab0id:", String.valueOf(tab.getPosition()));
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.maintoptab, new ThreeTabToolbar()).commit();
                        Log.d("tab1id:", String.valueOf(tab.getPosition()));
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.maintoptab, new SearchToolbar()).commit();
                        Log.d("tab2id", String.valueOf(tab.getPosition()));
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.maintoptab, new ThreeTabToolbar()).commit();
                        break;
                    case 4:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.maintoptab, new ThreeTabToolbar()).commit();
                        break;
                    default:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.maintoptab, new ThreeTabToolbar()).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        private final ArrayList<Fragment> fragments = new ArrayList<>();

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment) {
            fragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
