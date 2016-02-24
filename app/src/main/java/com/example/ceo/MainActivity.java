package com.example.ceo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Btn_Move = (Button) findViewById(R.id.move_mode);
        Btn_Move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MoveModeActivity.class);
                startActivity(intent);
            }
        });
        Button Btn_Test = (Button) findViewById(R.id.test_mode);
        Btn_Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestModeActivity.class);
                startActivity(intent);
            }
        });
        Button Btn_Game = (Button) findViewById(R.id.game_mode);
        Button Btn_Setting = (Button) findViewById(R.id.setting);
        Btn_Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
