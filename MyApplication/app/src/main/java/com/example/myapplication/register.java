package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity {
    EditText et_username,et_password,et_repassword;
    Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        et_username=findViewById(R.id.register_et_username);
        et_password=findViewById(R.id.register_et_password);
        et_repassword=findViewById(R.id.register_et_repassword);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("username",et_username.getText());
                intent.putExtra("password",et_password.getText());
                setResult(1,intent);
                finish();
            }
        });
    }
}
