package com.example.javastudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;
    private FloatingActionButton fabRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fabRoute = findViewById(R.id.fab_route);
        fabRoute.setOnClickListener(v->{
            //intent사용법 대표2가지
            //1. 현재 내 화면, 이동할 화면
            //2. 현재 내 화면, 내부앱의 이동할 화면(전화번호부, 메모장 등등, 다른어플은안되고 기본 어플만가능)
            //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01022227777"));//전화번호 화면으로 가는것 //ACTION_CALL : 전화를 바로거는것
            //intent = 트럭(현재 내위치, 이동할 위치정보, 이동할 때 가져갈 박스)
            //다른 앱으로 이동 = 트럭(상대방 앱의 키, 데이터)

            User user = new User();
            user.setId(1);
            user.setUsername("cos");
            user.setPassword("1234");

            //Bundle (택배박스)
            //serializable
            //gson 으로 json 변환 putExtra로 넘기고 gson으로 자바 오브젝트

            Intent intent = new Intent(mContext, SubActivity.class);
            intent.putExtra("username", "ssar");
            intent.putExtra("user",user);
//            startActivity(intent);

            // 내가 데이터 요청후 응답시 나의 요청인지 알아보기위해 사용
            startActivityForResult(intent,300); //요청코드 300(임의코드)
        });
    }

    //finish() 될때 콜백되는 함수
    //setResult() 함수의 파라메터가 전달됨.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG,"onActivityResult 실행됨");
        Log.d(TAG, "requestCode "+requestCode);

        if(requestCode == 300){ //서브 액티비티에서 돌아왔다.
            if(resultCode == 1){ //로직 성송
                Toast.makeText(mContext, "인증 성공함"+data.getStringExtra("auth"), Toast.LENGTH_SHORT).show();
            }else{
                // 로직 실패
                Toast.makeText(mContext, "인증 실패", Toast.LENGTH_SHORT).show();
            }
        }
    }
}