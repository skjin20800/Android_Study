package com.example.navilist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;

import com.example.navilist.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private DrawerLayout drawer;

    private NavigationView nv;

    private ImageView ivMenu, ivPerson;
    private Toolbar toolbarMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain); // 기존툴바를 새로만든 툴바로 바꾼다.

        ivPerson = findViewById(R.id.iv_person);
        ivPerson.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            startActivity(intent);
        });



        drawer = findViewById(R.id.drawer);
        ivMenu = findViewById(R.id.iv_menu);

        ivMenu.setOnClickListener(v -> {
            drawer.openDrawer(GravityCompat.START);
        });

        nv = findViewById(R.id.nv);
        NavigationViewHelper.enable(MainActivity.this,nv);

    }
}