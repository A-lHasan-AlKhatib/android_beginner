package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login_page extends AppCompatActivity {

    Button btn_login,btn_register;
    EditText et_username,et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        btn_login=findViewById(R.id.login_btn_login);
        btn_register=findViewById(R.id.login_btn_register);
        et_username=findViewById(R.id.login_et_username);
        et_password=findViewById(R.id.login_et_password);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),register.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode==1) {
//            Intent intent = getIntent();
//            String username = intent.getStringExtra("username");
//            String password = intent.getStringExtra("password");
//            et_username.setText(username);
//            et_password.setText(password);
//        }
    }
}
