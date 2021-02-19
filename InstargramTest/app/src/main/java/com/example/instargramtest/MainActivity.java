package com.example.instargramtest;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbarMain;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //툴바
        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain); // 기존툴바를 새로만든 툴바로 바꾼다.


        //person



        //바텀 네비게이션
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //최초화면
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        //클릭시 화면전환환
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.bt_add:
                    selectedFragment = new AddFragment();
                    break;
                case R.id.bt_favorite:
                    selectedFragment = new FavoriteFragment();
                    break;
                case R.id.bt_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.bt_person:
                    selectedFragment = new PersonFragment();
                    break;
                case R.id.bt_search:
                    selectedFragment = new SearchFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        });

    }



}
