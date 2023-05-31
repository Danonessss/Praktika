package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static public int countmoney = 0;
    static public int money = 1;
    Button next_day, Improve;
    static public TextView textmoney;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next_day = (Button) findViewById(R.id.next_day);
        Improve = (Button) findViewById(R.id.Improve);
        textmoney = (TextView) findViewById(R.id.money);
        load_save();
        Next_day();
    }
    void Next_day () {
        next_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countmoney += money ;
                textmoney.setText(countmoney + "");
            }
        });
        Improve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Improve.class);
                startActivity(intent);
                save();
            }
        });
    }
    void save() {
        preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("money", countmoney);
        editor.commit();
    }
    void load_save() {
        preferences = getPreferences(MODE_PRIVATE);
        countmoney = preferences.getInt("money", 0);
        textmoney.setText(countmoney + "");
    }
}