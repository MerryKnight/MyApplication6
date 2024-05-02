package com.example.myapplication6;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public ActionBarDrawerToggle toggle;
    public DrawerLayout drawer;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        imageView = findViewById(R.id.imageView);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Собаки");
        }

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawer, R.string.drawer_open,
                R.string.drawer_close);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
            ActionBar actionBar = getSupportActionBar();
            if (item.getItemId() == R.id.mops)
            {
                imageView.setImageResource(R.drawable.a1);
                assert actionBar != null;
                actionBar.setSubtitle("Мопс");
            }
            else if (item.getItemId() == R.id.german)
            {
                imageView.setImageResource(R.drawable.a2);
                assert actionBar != null;
                actionBar.setSubtitle("Немецкая овчарка");
            }
            else if (item.getItemId() == R.id.shpic)
            {
                imageView.setImageResource(R.drawable.a3);
                assert actionBar != null;
                actionBar.setSubtitle("Шпиц");
            }
            else if (item.getItemId() == R.id.next)
            {
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
            }
            drawer.closeDrawer(GravityCompat.START);
            return true;

        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

}