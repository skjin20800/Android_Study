package com.example.gridlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridListAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter";
    private final List<Movie> movies;

    GridListAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    public void addItem(Movie movie) {
        movies.add(movie);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        movies.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() { return movies.size(); }
    @Override
    public Object getItem(int position) { return movies.get(position); }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.list_item, parent, false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        ImageView ivPic = view.findViewById(R.id.iv_pic);
        tvTitle.setText(movies.get(position).getTitle());
        ivPic.setImageResource(movies.get(position).getPic());

        return view;
    }
}
