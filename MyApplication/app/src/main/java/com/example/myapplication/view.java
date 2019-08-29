package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class view extends AppCompatActivity {
    Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        Intent intent=getIntent();
        String username=intent.getStringExtra("username");
        String password=intent.getStringExtra("password");
        TextView tx_username=findViewById(R.id.view_tx_username);
        tx_username.setText(username);
        TextView tx_password=findViewById(R.id.view_tx_password);
        tx_password.setText(password);
        btn_back=findViewById(R.id.view_btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("x","hello");
                setResult(1,intent);
                finish();
            }
        });
    }
}
