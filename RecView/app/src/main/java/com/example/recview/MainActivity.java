package com.example.recview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rv);
        ArrayList<Card> cards = new ArrayList<>();
        Card c = new Card("kid","Waaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'",
                "12","1","120",R.drawable.kid);
        cards.add(c);

        c = new Card("bike","trn trn trn trn",
                "200","37","33",R.drawable.bike);
        cards.add(c);

        c = new Card("Android","0111010100110011110001010101",
                "1","12311","199",R.drawable.android);
        cards.add(c);

        c = new Card("Cake","happy birthday to you",
                "25","15","12",R.drawable.cake);
        cards.add(c);

        CardRecAdapter adapter = new CardRecAdapter(cards);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }
}
