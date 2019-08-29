package com.example.hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();


        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        //LayoutInflater inflater =



        Button btn = findViewById(R.id.calc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView sec = findViewById(R.id.txt2);
                TextView fir = findViewById(R.id.txt1);
                double num1 = Double.parseDouble(fir.getText().toString());
                double num2 = Double.parseDouble(sec.getText().toString());
                double area = num1 * num2;
                double par = num1 + num2;
                TextView t1 = findViewById(R.id.areaView);
                t1.setText(String.valueOf(area));
                TextView t2 = findViewById(R.id.perView);
                t2.setText(String.valueOf(par));
            }
        });

        RadioButton reRa = findViewById(R.id.recRaid);
        reRa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    TextView sec = findViewById(R.id.txt2);
                    sec.setVisibility(View.VISIBLE);
                    TextView fir = findViewById(R.id.txt1);
                    fir.setHint("1st value");

                    Button btn = findViewById(R.id.calc);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            TextView sec = findViewById(R.id.txt2);
                            TextView fir = findViewById(R.id.txt1);
                            double num1 = Double.parseDouble(fir.getText().toString());
                            double num2 = Double.parseDouble(sec.getText().toString());
                            double area = num1 * num2;
                            double par = num1 + num2;
                            TextView t1 = findViewById(R.id.areaView);
                            t1.setText(String.valueOf(area));
                            TextView t2 = findViewById(R.id.perView);
                            t2.setText(String.valueOf(par));
                        }
                    });
                } else {
                    TextView sec = findViewById(R.id.txt2);
                    sec.setVisibility(View.INVISIBLE);
                    TextView fir = findViewById(R.id.txt1);
                    fir.setHint("Enter the diameter");
                    Button btn = findViewById(R.id.calc);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            TextView fir = findViewById(R.id.txt1);
                            double num1 = Double.parseDouble(fir.getText().toString());
                            double area = num1 * num1 * Math.PI;
                            double par = 2 * num1 * Math.PI;
                            TextView t1 = findViewById(R.id.areaView);
                            TextView t2 = findViewById(R.id.perView);
                            t1.setText(String.valueOf(area));
                            t2.setText(String.valueOf(par));
                        }
                    });
                }
            }
        });
    }
}