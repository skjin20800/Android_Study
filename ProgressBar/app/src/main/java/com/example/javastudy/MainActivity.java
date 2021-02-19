package com.example.javastudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgessBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgessBar = findViewById(R.id.progressBar1);

        download();

    }


    private void download(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    //다운로드 완료, 스프링 서버 요청 응답의 결과(json)
                    mProgessBar.setVisibility(View.INVISIBLE);
                }catch (InterruptedException e){
                e.printStackTrace();
                }

            }
        }).start();
    }

}