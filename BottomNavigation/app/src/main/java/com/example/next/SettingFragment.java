package com.example.next;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingFragment extends Fragment {

    private static final String TAG = "SettingFragment";
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        MainActivity at = (MainActivity) container.getContext();
        Log.d(TAG, "onCreateView: at: num"+ at.num);
        
        View view = inflater.inflate(R.layout.fragment_setting, container, false);


        return view;
    }
}
