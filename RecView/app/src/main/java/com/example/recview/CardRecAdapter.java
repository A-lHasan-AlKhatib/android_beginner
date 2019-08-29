package com.example.recview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardRecAdapter extends RecyclerView.Adapter<CardRecAdapter.CardViewHolder> {

    private ArrayList<Card> cards;

    CardRecAdapter(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.img.setImageResource(card.getImge());
        holder.name.setText(card.getName());
        holder.txt.setText(card.getTxt());
        holder.following.setText(card.getFollowing());
        holder.followers.setText(card.getFollowers());
        holder.posts.setText(card.getPost());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name,txt,following,posts,followers;

        CardViewHolder(@NonNull View itemView) {
            super(itemView);
            img =itemView.findViewById(R.id.card_img);
            name = itemView.findViewById(R.id.card_name);
            txt = itemView.findViewById(R.id.card_txt);
            following = itemView.findViewById(R.id.card_following);
            followers = itemView.findViewById(R.id.card_followers);
            posts = itemView.findViewById(R.id.card_posts);

        }
    }
}
