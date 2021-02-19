package com.example.kakotext;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//3번 상속받기
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{

    private static final String TAG = "UserAdapter";

    // 4번 컬렉션 생성
    private final List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    // 5번 addItem.removeItem
    public void addItem(User user){
        users.add(user);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        users.remove(position);
    }


    //7번 getView랑 똑같음.
    // 차이점이 있다면 listView는 화면에 3개가 필요하면 최초 로딩시에 3개를 그려야하니깐 getView가 3번 호출됨
    // 그다음에 스크롤을 해서 2개가 추가되야 될때, 다시 getView를 호출함
    // 하지만 recyclerView는 스크롤을 해서 2개가 추가되야 될때 onBindViewHolder를 호출함.
    // onCreateViewHolder는 해당 Activity 실행시에만 호출 됨.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d(TAG, "onCreateViewHolder: ");

        // 객체생성
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // inflate(해당리소스를, 사이클러뷰 안에, 아직 붙이지않는다) 리턴시에 연결함
        View view = inflater.inflate(R.layout.user_item, parent, false);

        return new MyViewHolder(view);//view가 리스트뷰에 하나 그려짐
    }

    // 데이터가 체인지됨
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.setItem(users.get(position));

    }

    // 6번 컬렉션 크기 알려주기 (화면에 몇개 그려야될지를 알아야 하기 때문)
    @Override
    public int getItemCount() {
        return users.size();
    }

    // 1번 ViewHolder 만들기
    // ViewHolder란 하나의 View를 가지고 있는 Holder이다.
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // 2번 user_item이 가지고 있는 위젯들을 선언

        private ImageView ivPic;
        private TextView tvUsername;
        private TextView tvChatting;
        private TextView tvLastTime;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUsername = itemView.findViewById(R.id.tv_username);
            tvChatting = itemView.findViewById(R.id.tv_chatting);
            tvLastTime = itemView.findViewById(R.id.tv_lastTime);
            ivPic = itemView.findViewById(R.id.iv_pic);
        }

        public void setItem(User user){
            tvUsername.setText(user.getUsername());
            tvChatting.setText(user.getChatting());
            tvLastTime.setText(user.getLastTime());
            ivPic.setImageResource(user.getPic());


        }
    }
}
