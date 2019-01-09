package com.dc.weidu.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dc.weidu.R;
import com.dc.weidu.fragment.FragmentAdress;
import com.dc.weidu.fragment.FragmentLieBiao;
import com.dc.weidu.fragment.FragmentMe;
import com.dc.weidu.fragment.FragmentShopping;
import com.dc.weidu.fragment.FragmentShouye;

public class DifferentActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    pager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    pager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    pager.setCurrentItem(2);
                    return true;
                case R.id.navigation_adress:
                    pager.setCurrentItem(3);
                    return true;
                case R.id.navigation_me:
                    pager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different);
        pager = findViewById(R.id.pager);
        mTextMessage = (TextView) findViewById(R.id.message);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i){
                    case 0:
                        return new FragmentShouye();
                    case 1:
                        return new FragmentLieBiao();
                    case 2:
                        return new FragmentShopping();
                    case 3:
                        return new FragmentAdress();
                    case 4:
                        return new FragmentMe();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_dashboard);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_notifications);
                        break;
                    case 3:
                        navigation.setSelectedItemId(R.id.navigation_adress);
                        break;
                    case 4:
                        navigation.setSelectedItemId(R.id.navigation_me);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

}
