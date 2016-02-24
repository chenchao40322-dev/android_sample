package com.android.cc.cc_android.viewPager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;


import com.android.cc.cc_android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchao on 16/1/3.
 */
public class CCViewPagerActivity extends AppCompatActivity {

    MyAdapter mAdapter = new MyAdapter(getSupportFragmentManager());
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewpager_layout);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);

        viewPager.setAdapter(mAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
    }

    public  static  class MyAdapter extends FragmentStatePagerAdapter {
        List<Fragment> mFragments = new ArrayList<>();

        public MyAdapter(FragmentManager fm) {
            super(fm);
            mFragments.add(new ListFragment());
            mFragments.add(new ListFragment());
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "test1";
            } else {
                return "test2";
            }
        }

        @Override
        public Fragment getItem(int position) {
            if (position < mFragments.size()) {
                return mFragments.get(position);
            }

            return null;
        }
    }

}
