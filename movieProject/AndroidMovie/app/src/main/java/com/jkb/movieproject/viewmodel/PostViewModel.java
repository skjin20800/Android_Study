package com.jkb.movieproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.jkb.movieproject.Movie;

import java.util.ArrayList;
import java.util.List;


public class PostViewModel extends ViewModel {

    // LiveData 변경법
    // 1. 서버의 DB에 Data 변경요청, 2. 변경된 데이터 다운, 3. UI 적용
    // MutableLiveData 변경법
    // 1. 데이터 변경, 2 UI 적용  -> 서버의 DB의 Data값은 변동없다
    // 공통점 : 데이터변경시 UI 자동변경


    private MutableLiveData<List<Movie>> mtPosts = new MutableLiveData<>();

    public MutableLiveData<List<Movie>> 구독(){
        return mtPosts;
    }

    //1
    public void 포스트한건추가(Movie movie){
        List<Movie> movies = mtPosts.getValue();
        movies.add(movie);
        mtPosts.setValue(movies);
    }

    //2
    public void 포스트변경(){
        List<Movie> movies = mtPosts.getValue();
        movies.get(0).setTitle("테스트");
        mtPosts.setValue(movies);
    }

    public void 영화리스트넣기(List<Movie> movie){
        mtPosts.setValue(movie);
    }

    public List<Movie> 영화리스트출력(){
        return mtPosts.getValue();
    }

    public void 데이터초기화(){
        List<Movie> movies = new ArrayList<>();
        mtPosts.setValue(movies);
    }
}
