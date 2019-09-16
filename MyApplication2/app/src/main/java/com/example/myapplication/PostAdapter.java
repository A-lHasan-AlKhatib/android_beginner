package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHodler> {

    private ArrayList<Post> posts;

    public PostAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout,null,false);
        return new PostViewHodler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHodler holder, int position) {
        Post post = posts.get(position);
        holder.id.setText(String.valueOf(post.getId()));
        holder.userId.setText(String.valueOf(post.getUserId()));
        holder.title.setText(post.getTitle());
        holder.body.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHodler extends RecyclerView.ViewHolder {

        TextView id, userId, title, body;

        public PostViewHodler(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.post_id);
            userId = itemView.findViewById(R.id.post_user_id);
            title = itemView.findViewById(R.id.post_title);
            body = itemView.findViewById(R.id.post_body);

        }
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
}