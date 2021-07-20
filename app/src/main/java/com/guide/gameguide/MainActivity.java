package com.guide.gameguide;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import com.guide.gameguide.ui.TabbedFragment;
import com.guide.gameguide.ui.attachments.AttachmentsList;
import com.guide.gameguide.ui.comparison.ComparisonWeapon;
import com.guide.gameguide.ui.consumables.ConsumablesItems;
import com.guide.gameguide.ui.gundetail.GunAdapter;
import com.guide.gameguide.ui.gundetail.GunType;
import com.guide.gameguide.ui.gundetail.Gun_Detail;
import com.guide.gameguide.ui.vehicles.VehiclesList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    AdView mAdView;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView= findViewById(R.id.bottom_navigator);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new TabbedFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                Fragment fragment=null;

                switch (item.getItemId()){
                    case R.id.bar_Armory:
                        fragment= new TabbedFragment();
                        break;
                    case R.id.bar_maps:
                        fragment= new Maps();
                        break;
                    case R.id.bar_vehicles:
                        fragment= new AttachmentsList();
                        break;
                    case R.id.bar_consumables:
                        fragment= new ComparisonWeapon();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                return true;
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                mAdView = findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //Layout drawer = findViewById(R.id.drawer_layout);
        //NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //mAppBarConfiguration = new AppBarConfiguration.Builder(
          //      R.id.nav_GunType, R.id.nav_home,R.id.nav_Title1,R.id.nav_Vehicles,R.id.nav_Consumables,R.id.nav_comparison)
            //    .setDrawerLayout(drawer)
              //  .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
       // NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
       // NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        GunAdapter.onBackPressed();
        getFragmentManager().popBackStackImmediate();
//        Log.e("onbackpressed",  String.valueOf(getSupportFragmentManager().getBackStackEntryCount()));
//        Fragment myfrag = new Gun_Detail("a");
//        myfrag.getChildFragmentManager().beginTransaction().replace(R.id.gundet,myfrag).commit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.gundet,myfrag).commit();

    }
}