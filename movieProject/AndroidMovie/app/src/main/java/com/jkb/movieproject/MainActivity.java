package com.jkb.movieproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.jkb.movieproject.viewmodel.PostViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private RecyclerView rvUserList;
    private MovieAdapter movieAdapter;
    private List<Movie> movies;
    private PostViewModel postViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.데이터초기화();

        postViewModel.구독().observe(this, movies -> {
            movieAdapter.notifyDataSetChanged();
            Log.d(TAG, "onCreate: 데이터 변경됨");
        });

        download();


        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvUserList = findViewById(R.id.rv_user_list);
        rvUserList.setLayoutManager(manager);

        movieAdapter = new MovieAdapter(postViewModel.영화리스트출력());

        rvUserList.setAdapter(movieAdapter);

    }

    private void download(){
        MoviePostApi moviePostApi = MoviePostApi.retrofit.create(MoviePostApi.class);
        Call<List<Movie>> call = moviePostApi.getPosts();


        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movies = response.body();

                postViewModel.영화리스트넣기(movies);
                movieAdapter.changeItem(postViewModel.영화리스트출력());
                movieAdapter.notifyDataSetChanged();

                Log.d(TAG, "onResponse: 성공" + movies);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d(TAG, "onFailure: 실패");
            }

        });

    }




}