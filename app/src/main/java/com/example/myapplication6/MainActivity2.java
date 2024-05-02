package com.example.myapplication6;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Activity 2");
        ImageView imageView = findViewById(R.id.imageView);
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            BottomNavigationView bottomNavigationView =
                    findViewById(R.id.bottom_navigation);
            bottomNavigationView.setItemIconTintList(getResources().getColorStateList(R.color.white));
            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.navig) {
                    actionBar.setTitle("Навигатор");
                    imageView.setImageResource(R.drawable.a4);
                } else if (item.getItemId() == R.id.basket) {
                    actionBar.setTitle("Баскетбол");
                    imageView.setImageResource(R.drawable.a6);
                } else if (item.getItemId() == R.id.mountain) {
                    actionBar.setTitle("Горы");
                    imageView.setImageResource(R.drawable.a5);
                }
                return false;
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}