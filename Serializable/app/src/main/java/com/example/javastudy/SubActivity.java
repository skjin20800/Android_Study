package com.example.javastudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SubActivity extends AppCompatActivity {

    private static final String TAG = "SubActivity";
    private FloatingActionButton fabPop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");


        Log.d(TAG, "username"+username);
        Log.d(TAG, "user"+intent.getSerializableExtra("user"));

        fabPop = findViewById(R.id.fab_pop);
        fabPop.setOnClickListener(v -> {
            //인증이 성공함
            Intent subIntent = new Intent(); //종료될때 ActivitiResult함수로 돌아감
            subIntent.putExtra("auth", "ok");
            setResult(1, subIntent); // setResult(성공코드값,데이터)
            finish();// 내 stack에서 날린다는 뜻, 여기선 MainActivity로 간다.
        });
    }
}