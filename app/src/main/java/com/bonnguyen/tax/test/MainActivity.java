package com.bonnguyen.tax.test;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bonnguyen.tax.test.car.CarFragment;
import com.bonnguyen.tax.test.motorcycle.MotorcycleFragment;
import com.bonnguyen.tax.test.van.VanFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    VehiclesPagerAdapter mVehiclesPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.tabanim_toolbar);
        setSupportActionBar(mToolbar);

        mVehiclesPagerAdapter = new VehiclesPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mVehiclesPagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public class VehiclesPagerAdapter extends FragmentStatePagerAdapter {
        public VehiclesPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new VanFragment();
                case 1:
                    return new CarFragment();
                case 2:
                    return new MotorcycleFragment();
                default:
                    return new VanFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Van";
                case 1:
                    return "Car";
                case 2:
                    return "Motorcycle";
                default:
                    return "Van";
            }
        }
    }
}
