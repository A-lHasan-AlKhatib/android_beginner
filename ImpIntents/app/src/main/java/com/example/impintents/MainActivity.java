package com.example.impintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button call = findViewById(R.id.call);
        Intent intent = getIntent();
        if(intent != null){
            ImageView img = findViewById(R.id.img);
            Uri uri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
            img.setImageURI(uri);
        }
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num = findViewById(R.id.numb);
                int numb = Integer.parseInt(num.getText().toString());
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+numb));
                startActivity(intent);
            }
        });
    }
}