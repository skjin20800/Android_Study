package com.example.tapnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private MyfragMentPagerAdapter myfragMentPagerAdapter;
    private ViewPager vpContainer;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TabLayout은 메뉴.xml 이 없음.
        vpContainer = findViewById(R.id.vp_container);
        tabs = findViewById(R.id.tabs);

        myfragMentPagerAdapter = new MyfragMentPagerAdapter(getSupportFragmentManager(),1);

        myfragMentPagerAdapter.addFragment(new Frag1());
        myfragMentPagerAdapter.addFragment(new Frag2());
        myfragMentPagerAdapter.addFragment(new Frag3());

        vpContainer.setAdapter(myfragMentPagerAdapter);

        // tab이랑 연결되어야 함.
        tabs.setupWithViewPager(vpContainer);

        // tab에 아이템 그리기
        tabs.getTabAt(0).setText("1");
        tabs.getTabAt(1).setIcon(R.drawable.ic_launcher_background);
        tabs.getTabAt(2).setText("마지막");

    }
}