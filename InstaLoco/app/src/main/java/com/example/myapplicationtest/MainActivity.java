package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


// 메인쓰레드 => onCreate() => UI 쓰레드
//                         => 이벤트 스레드 [               ] 확인
//                         => 이벤트 리스너(OS) []

public class MainActivity extends AppCompatActivity {

    private TextView tvTitle;

    //manifests에서 설정된 자바 파일이 실행될 때까지 가장 먼저 실행되는 함수 onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//그림 그리는 함수 (무엇을? activity_main) =>자바
    }
}