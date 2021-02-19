package com.example.kakotext;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BubbleFragment extends Fragment {
    private RecyclerView rvUserList;
    private UserAdapter userAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bubble, container, false);
        Context context = container.getContext();
        MainActivity at = (MainActivity) context;




        //리사이클러뷰
        List<User> users = new ArrayList<>();
        for (int i=1; i<50; i++){
            users.add(new User(i,R.drawable.iu, "아이유","안녕하세요",i+"시간전"));
        }

        LinearLayoutManager manager = new LinearLayoutManager(at, RecyclerView.VERTICAL,false);
        rvUserList = view.findViewById(R.id.rv_user_list);
        rvUserList.setLayoutManager(manager);

        userAdapter = new UserAdapter(users);
        rvUserList.setAdapter(userAdapter);



        return view;
    }




}
