package com.example.mydb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button insert = findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDB db = new MyDB(getBaseContext());
                Employee emp = new Employee("Tamer","tamer@gmail.com");
                boolean result = db.insertEmployee(emp);
                if (result){
                    Toast.makeText(getBaseContext(),"Added successfully",Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getBaseContext(),"ERROR",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}