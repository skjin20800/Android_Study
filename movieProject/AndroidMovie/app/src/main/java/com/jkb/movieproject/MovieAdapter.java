package com.jkb.movieproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//3번 상속받기
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{

    private static final String TAG = "MovieAdapter";

    // 4번 컬렉션 생성
    private List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    public void changeItem(List<Movie> movies){

        this.movies = movies;

    }

    // 5번 addItem.removeItem
    public void addItem(Movie movie){
        movies.add(movie);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        movies.remove(position);
        notifyDataSetChanged();
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
        View view = inflater.inflate(R.layout.movie_item, parent, false);

        return new MyViewHolder(view);//view가 리스트뷰에 하나 그려짐
    }

    // 데이터가 체인지됨
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.setItem(movies.get(position));

    }

    // 6번 컬렉션 크기 알려주기 (화면에 몇개 그려야될지를 알아야 하기 때문)
    @Override
    public int getItemCount() {
        return movies.size();
    }

    // 1번 ViewHolder 만들기
    // ViewHolder란 하나의 View를 가지고 있는 Holder이다.
    public class MyViewHolder extends RecyclerView.ViewHolder {

        // 2번 user_item이 가지고 있는 위젯들을 선언
        private TextView tvId;
        private TextView tvTitle;
        private ImageView ivImage;
        private Button btnDelete;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivImage = itemView.findViewById(R.id.iv_url);
            btnDelete = itemView.findViewById(R.id.btn_delete);


            btnDelete.setOnClickListener(v -> {
                Log.d(TAG, "MyViewHolder: 클릭됨"+itemView);
                Integer movieId = Integer.parseInt((String) tvId.getText());
                deletePost(movieId);
                removeItem(getAdapterPosition());
            });


        }



        public void setItem(Movie movie){
            tvId.setText(movie.getId()+"");
            tvTitle.setText(movie.getTitle()+"");
            Glide
                    .with(itemView)//사진을 어디에 넣을지, 여기선 컨텍스트 넣는다
                    .load(movie.getMedium_cover_image())//URL 주소
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background) //사진 없으면 띄울 이미지
                    .into(ivImage); //리스트뷰 아이디

        }

    }

    public void deletePost(int position) {

        MoviePostApi moviePostApi = MoviePostApi.retrofit.create(MoviePostApi.class);
        Call<Void> call = moviePostApi.deletePost(position);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                Log.d(TAG, "onResponse: 삭제실행"+position);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d(TAG, "onResponse: 삭제실패");
            }
        });

    }

}
