package com.example.instargramtest;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * PagerAdapter는 양옆에 page를 미리 뛰어둠.
 * FragmentPagerAdapter는 한번 뜬 객체는 지우지 않음.
 * FragmentStatePagerAdapter는 화면에서 보이지 않으면 날림
 */


public class MyfragMentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();

    public MyfragMentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public void addFragment(Fragment fragment){
        mFragments.add(fragment);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
