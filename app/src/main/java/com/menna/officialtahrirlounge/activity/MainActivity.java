package com.menna.officialtahrirlounge.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.menna.officialtahrirlounge.Fragment.AboutUsFragment;
import com.menna.officialtahrirlounge.Fragment.ContactFragment;
import com.menna.officialtahrirlounge.Fragment.EventsFragment;
import com.menna.officialtahrirlounge.Fragment.GalleryFragment;
import com.menna.officialtahrirlounge.Fragment.HomeFragment;
import com.menna.officialtahrirlounge.Fragment.PartnerFragment;
import com.menna.officialtahrirlounge.Fragment.TeamFragment;
import com.menna.officialtahrirlounge.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



   ViewPager viewPager;
    int [] imgs;
    int count=1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment fragment = new HomeFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, fragment)

                .commit();

        int count = getFragmentManager().getBackStackEntryCount();
        if(count>0){
            for (int i = 0; i <count; i++) {
                getFragmentManager().popBackStack();
            }
        }

        //***************Nav Bar****************************
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



/*
        HomeFragment fragment = new HomeFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .commit();
*/

        //*************************************************************************

        //************recycle card*******************************************
/*
        recyclerView = (RecyclerView) findViewById(R.id.rec_view);
        layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setAdapter(recyclerAdapter);*/
//*************************************************************


        //************************auto slider ***************************************
/*
        viewPager =(ViewPager)findViewById(R.id.viewpager);
        imgs= new int[]{R.drawable.in, R.drawable.intr, R.drawable.intro};
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this,imgs);
        viewPager.setAdapter(viewPagerAdapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),10000,5000);

*/



    }


   /* public  class MyTimerTask extends TimerTask
    {


        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(imgs.length!=0)
                    {
                        if(count<imgs.length)
                        viewPager.setCurrentItem(count++);
                        else
                            {
                            count = 0;
                            viewPager.setCurrentItem(count++);
                            }
                    }


                }
            });
        }}
    */


    @Override
    public void onBackPressed()
    {



    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home)
        {
            HomeFragment fragment = new HomeFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();
        }
        else if (id == R.id.nav_about)
        {
            AboutUsFragment fragment = new AboutUsFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();

        }
        else if (id == R.id.nav_event)
        {
            EventsFragment fragment = new EventsFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();

        }
        else if (id == R.id.nav_gallary)
        {

            GalleryFragment fragment = new GalleryFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();

        } else if (id == R.id.nav_contact)
        {
            ContactFragment fragment = new ContactFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();

        } else if (id == R.id.nav_team)
        {

            TeamFragment fragment = new TeamFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();
        }
        else if(id==R.id.nav_partner)
        {
            PartnerFragment fragment = new PartnerFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();

        }
        else if(id==R.id.nav_facebook)

        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/TahrirLounge/"));
            startActivity(intent);

        }
        else if(id==R.id.nav_youtube)

        {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/Tahrirlounge"));
            startActivity(intent);
        }
        else if(id==R.id.nav_twitter)

        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/tahrirlounge"));
            startActivity(intent);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
