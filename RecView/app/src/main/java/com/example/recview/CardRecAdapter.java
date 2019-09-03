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
    private OnCardClickListiner listiner;

    CardRecAdapter(ArrayList<Card> cards, OnCardClickListiner listiner) {
        this.cards = cards;
        this.listiner = listiner;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.bind(cards.get(position));
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        Card card;
        ImageView img;
        TextView name, txt, following, posts, followers;

        public CardViewHolder(@NonNull final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.card_img);
            name = itemView.findViewById(R.id.card_name);
            txt = itemView.findViewById(R.id.card_txt);
            following = itemView.findViewById(R.id.card_following);
            followers = itemView.findViewById(R.id.card_followers);
            posts = itemView.findViewById(R.id.card_posts);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listiner.OnCardClick(card);
                }
            });
        }



        private void bind(Card card) {
            this.card = card;
            img.setImageResource(card.getImge());
            name.setText(card.getTxt());
            txt.setText(card.getTxt());
            following.setText(card.getFollowing());
            posts.setText(card.getPost());
            followers.setText(card.getFollowers());

        }

    }
}
