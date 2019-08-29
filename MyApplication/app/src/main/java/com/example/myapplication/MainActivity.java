package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_num1,et_num2;
    TextView tx_result;
    Button btn_sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style_calc);
        et_num1=findViewById(R.id.calc_et1);
        et_num2=findViewById(R.id.calc_et2);
        btn_sum=findViewById(R.id.calc_btn);
        tx_result=findViewById(R.id.calc_tx);

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int firstNum=Integer.parseInt(et_num1.getText().toString());
                int secoundtNum=Integer.parseInt(et_num2.getText().toString());
                int sum=firstNum+secoundtNum;
                tx_result.setText(String.valueOf(sum));
            }
        });
    }
}
