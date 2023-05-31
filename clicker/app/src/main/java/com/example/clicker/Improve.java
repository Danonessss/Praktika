package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Improve extends AppCompatActivity {
    Button laptop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);
        laptop = (Button) findViewById(R.id.laptop);
        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.countmoney >= 100) {
                    MainActivity.money += 1;
                    MainActivity.countmoney -= 100;
                    MainActivity.textmoney.setText(MainActivity.countmoney + "");
                }
            }
        });
    }
}