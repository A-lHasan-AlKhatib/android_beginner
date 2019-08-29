package com.example.logs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button log = findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView user = findViewById(R.id.use);
                TextView pass = findViewById(R.id.pass);
                Intent intent = new Intent(getBaseContext(),Page.class);
                intent.putExtra("user",user.getText().toString());
                intent.putExtra("pass",pass.getText().toString());
                startActivityForResult(intent,1);
            }
        });
        Button reg = findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),Reg.class);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            Toast.makeText(this,"back",Toast.LENGTH_SHORT).show();
        } else if (requestCode == 2) {
            if (resultCode == 3)
                Toast.makeText(this,"Canceled",Toast.LENGTH_SHORT).show();
            else if (resultCode == 2){
                Bundle ex = data.getExtras();
                if(ex != null){
                    TextView user = findViewById(R.id.use);
                    TextView pass = findViewById(R.id.pass);
                    user.setText(ex.getString("user"));
                    pass.setText(ex.getString("pass"));
                } else{
                    TextView use = findViewById(R.id.use);
                    use.setText("NULL");

                }


            }
        }
        }
    }
