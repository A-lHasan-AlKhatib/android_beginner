package com.example.logs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Reg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        Button back = findViewById(R.id.back);
        final Intent intent = getIntent();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(3,intent);
                finish();
            }
        });
        Button reg = findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView use = findViewById(R.id.user);
                TextView pass = findViewById(R.id.pass);
                Intent in = new Intent(getBaseContext(),MainActivity.class);
                in.putExtra("user",use.getText().toString());
                in.putExtra("pass",pass.getText().toString());
                setResult(2,in);
                finish();
            }
        });
    }
}
