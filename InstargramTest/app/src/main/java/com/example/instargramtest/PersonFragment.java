package com.example.instargramtest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class PersonFragment extends Fragment {

    private MyfragMentPagerAdapter myfragMentPagerAdapter;
    private ViewPager vpContainer;
    private TabLayout tabs;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Context context = container.getContext();
        MainActivity mainActivity = (MainActivity)context;
        View view = inflater.inflate(R.layout.fragment_person, container, false);

        // TabLayout은 메뉴.xml 이 없음.
        vpContainer = view.findViewById(R.id.vp_container);
        tabs = view.findViewById(R.id.tabs);

        myfragMentPagerAdapter = new MyfragMentPagerAdapter(mainActivity.getSupportFragmentManager(), 1);

        myfragMentPagerAdapter.addFragment(new TabFrag1());
        myfragMentPagerAdapter.addFragment(new TabFragPic1());


        vpContainer.setAdapter(myfragMentPagerAdapter);

        // tab이랑 연결되어야 함.
        tabs.setupWithViewPager(vpContainer);

        // tab에 아이템 그리기
        tabs.getTabAt(0).setIcon(R.drawable.ic_app);
        tabs.getTabAt(1).setIcon(R.drawable.ic_pic1);

        return view;
    }


}
