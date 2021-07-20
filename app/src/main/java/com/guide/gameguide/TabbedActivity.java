package com.guide.gameguide;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class TabbedActivity extends AppCompatActivity {
   TabLayout tabLayout;
   TabItem tabItem1,tabItem2,tabItem3;
   ViewPager viewPager;
    TabbedPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabbed_layout);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout1);
        tabItem1=(TabItem)findViewById(R.id.tabitem1);
        tabItem2=(TabItem)findViewById(R.id.tabitem2);
        tabItem3=(TabItem)findViewById(R.id.tabitem3);
        viewPager=(ViewPager)findViewById(R.id.vpager);

        pageAdapter=new TabbedPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //listen for scroll or page change
    }
}
