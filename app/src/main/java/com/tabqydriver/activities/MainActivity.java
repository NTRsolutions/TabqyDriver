package com.tabqydriver.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tabqydriver.R;
import com.tabqydriver.fragments.Account;
import com.tabqydriver.fragments.ChangePassword;
import com.tabqydriver.fragments.Earn;
import com.tabqydriver.fragments.History;
import com.tabqydriver.fragments.Home;
import com.tabqydriver.fragments.Order;
import com.tabqydriver.fragments.OrderDetails;

public class MainActivity extends AppCompatActivity  {


    private FrameLayout frameLayout;
    private NavigationView navigationView;
//    private BottomNavigationView bottomNavigationView;
    private float lastTranslate = 0.0f;
    public static DrawerLayout drawer;

    private TextView mTextMessage;

   /* private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new Home()).addToBackStack(Home.class.getName()).commit();
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_earn:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new Earn()).addToBackStack(Earn.class.getName()).commit();
                    //mTextMessage.setText(R.string.title_earn);
                    return true;
                case R.id.navigation_history:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new History()).addToBackStack(History.class.getName()).commit();
                    //mTextMessage.setText(R.string.title_history);
                    return true;
                case R.id.navigation_account:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new Account()).addToBackStack(Account.class.getName()).commit();
                    //mTextMessage.setText(R.string.title_account);
                    return true;
            }
            return true;
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*
        //mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
*/


//        bottomNavigationView = findViewById(R.id.navigation);
        frameLayout = findViewById(R.id.content);

        navigationView = findViewById(R.id.nav_view);

//        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Toast.makeText(MainActivity.this, "aa", Toast.LENGTH_SHORT).show();


                return true;
            }
        });



/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,  R.string.navigation_drawer_open,
                R.string.navigation_drawer_close){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (navigationView.getWidth() * slideOffset);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
                    frameLayout.setTranslationX(moveFactor);
                    //drawer_icon_iv.setTranslationX(moveFactor);
                }
                else
                {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate,moveFactor, 0.0f,0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    frameLayout.startAnimation(anim);
                    //drawer_icon_iv.startAnimation(anim);
                    lastTranslate = moveFactor;
                }
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        getSupportFragmentManager().beginTransaction().replace(R.id.content,new Home())
                .addToBackStack(Home.class.getName()).commit();
    }

    @Override
    public void onBackPressed() {
        finish();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   /* @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Toast.makeText(getApplicationContext(), "keep calm", Toast.LENGTH_SHORT).show();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.left_nav_padlock) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content,new ChangePassword())
                    .addToBackStack(ChangePassword.class.getName()).commit();
        } else if (id == R.id.left_nav_earn) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content,new Earn())
                    .addToBackStack(Earn.class.getName()).commit();
        } else if (id == R.id.left_nav_logout) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
