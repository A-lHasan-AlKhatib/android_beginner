package com.example.handy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show();
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tx = findViewById(R.id.txt);
                EditText numb1 = findViewById(R.id.num1);
                int num1 = Integer.parseInt(numb1.getText().toString());
                EditText numb2 = findViewById(R.id.num2);
                int num2 = Integer.parseInt(numb2.getText().toString());
                tx.setText(String.valueOf(num1+num2));
            }
        });
    }

    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Starting",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Continuing",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"REEEEEEEEE",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"Freeze",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"Hands in the air",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Bye Bye",Toast.LENGTH_SHORT).show();
    }
}
