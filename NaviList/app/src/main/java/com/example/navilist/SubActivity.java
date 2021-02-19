package com.example.navilist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.navilist.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class SubActivity extends AppCompatActivity {

    private NavigationView nv;
    private ImageView ivback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        ivback = findViewById(R.id.iv_back);
        ivback.setOnClickListener(v -> {
            finish();// 내 stack에서 날린다는 뜻.
        });


        nv = findViewById(R.id.nv);
        NavigationViewHelper.enable(SubActivity.this, nv);
    }
}