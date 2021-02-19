package com.example.kakotext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbarMain;


    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //툴바변경
        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain); // 기존툴바를 새로만든 툴바로 바꾼다.








    //바텀 네비게이션
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //최초화면
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PersonFragment()).commit();


        //클릭시 화면전환
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.bottom_person:
                    selectedFragment = new PersonFragment();
                    break;
                case R.id.bottom_bubble:
                    selectedFragment = new BubbleFragment();
                    break;
                case R.id.bottom_sharp:
                    selectedFragment = new SharpFragment();
                    break;
                case R.id.bottom_menu:
                    selectedFragment = new MenuFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });


    }

}