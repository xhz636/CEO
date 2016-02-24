package com.example.ceo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingActivity extends Activity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText ET_Black_R;
    private EditText ET_Black_G;
    private EditText ET_Black_B;
    private Button Btn_Black;
    private View View_Black;
    private EditText ET_White_R;
    private EditText ET_White_G;
    private EditText ET_White_B;
    private Button Btn_White;
    private View View_White;
    private EditText ET_Red_R;
    private EditText ET_Red_G;
    private EditText ET_Red_B;
    private Button Btn_Red;
    private View View_Red;
    private EditText ET_Blue_R;
    private EditText ET_Blue_G;
    private EditText ET_Blue_B;
    private Button Btn_Blue;
    private View View_Blue;
    private EditText ET_Yellow_R;
    private EditText ET_Yellow_G;
    private EditText ET_Yellow_B;
    private Button Btn_Yellow;
    private View View_Yellow;
    private EditText ET_Green_R;
    private EditText ET_Green_G;
    private EditText ET_Green_B;
    private Button Btn_Green;
    private View View_Green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        SettingView();
        LoadSetting();
        CreateButton();
    }

    void SettingView() {
        ET_Black_R = (EditText) findViewById(R.id.black_r);
        ET_Black_G = (EditText) findViewById(R.id.black_g);
        ET_Black_B = (EditText) findViewById(R.id.black_b);
        Btn_Black = (Button) findViewById(R.id.black_check);
        View_Black = findViewById(R.id.view_black);
        ET_White_R = (EditText) findViewById(R.id.white_r);
        ET_White_G = (EditText) findViewById(R.id.white_g);
        ET_White_B = (EditText) findViewById(R.id.white_b);
        Btn_White = (Button) findViewById(R.id.white_check);
        View_White = findViewById(R.id.view_white);
        ET_Red_R = (EditText) findViewById(R.id.red_r);
        ET_Red_G = (EditText) findViewById(R.id.red_g);
        ET_Red_B = (EditText) findViewById(R.id.red_b);
        Btn_Red = (Button) findViewById(R.id.red_check);
        View_Red = findViewById(R.id.view_red);
        ET_Blue_R = (EditText) findViewById(R.id.blue_r);
        ET_Blue_G = (EditText) findViewById(R.id.blue_g);
        ET_Blue_B = (EditText) findViewById(R.id.blue_b);
        Btn_Blue = (Button) findViewById(R.id.blue_check);
        View_Blue = findViewById(R.id.view_blue);
        ET_Yellow_R = (EditText) findViewById(R.id.yellow_r);
        ET_Yellow_G = (EditText) findViewById(R.id.yellow_g);
        ET_Yellow_B = (EditText) findViewById(R.id.yellow_b);
        Btn_Yellow = (Button) findViewById(R.id.yellow_check);
        View_Yellow = findViewById(R.id.view_yellow);
        ET_Green_R = (EditText) findViewById(R.id.green_r);
        ET_Green_G = (EditText) findViewById(R.id.green_g);
        ET_Green_B = (EditText) findViewById(R.id.green_b);
        Btn_Green = (Button) findViewById(R.id.green_check);
        View_Green = findViewById(R.id.view_green);
    }

    void LoadSetting() {
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        Integer Color_R, Color_G, Color_B;
        Color_R = pref.getInt("Black_R", 0);
        Color_G = pref.getInt("Black_G", 0);
        Color_B = pref.getInt("Black_B", 0);
        ET_Black_R.setText(Color_R.toString());
        ET_Black_G.setText(Color_G.toString());
        ET_Black_B.setText(Color_B.toString());
        View_Black.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
        Color_R = pref.getInt("White_R", 200);
        Color_G = pref.getInt("White_G", 200);
        Color_B = pref.getInt("White_B", 200);
        ET_White_R.setText(Color_R.toString());
        ET_White_G.setText(Color_G.toString());
        ET_White_B.setText(Color_B.toString());
        View_White.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
        Color_R = pref.getInt("Red_R", 150);
        Color_G = pref.getInt("Red_G", 5);
        Color_B = pref.getInt("Red_B", 35);
        ET_Red_R.setText(Color_R.toString());
        ET_Red_G.setText(Color_G.toString());
        ET_Red_B.setText(Color_B.toString());
        View_Red.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
        Color_R = pref.getInt("Blue_R", 10);
        Color_G = pref.getInt("Blue_G", 75);
        Color_B = pref.getInt("Blue_B", 145);
        ET_Blue_R.setText(Color_R.toString());
        ET_Blue_G.setText(Color_G.toString());
        ET_Blue_B.setText(Color_B.toString());
        View_Blue.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
        Color_R = pref.getInt("Yellow_R", 195);
        Color_G = pref.getInt("Yellow_G", 170);
        Color_B = pref.getInt("Yellow_B", 90);
        ET_Yellow_R.setText(Color_R.toString());
        ET_Yellow_G.setText(Color_G.toString());
        ET_Yellow_B.setText(Color_B.toString());
        View_Yellow.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
        Color_R = pref.getInt("Green_R", 0);
        Color_G = pref.getInt("Green_G", 175);
        Color_B = pref.getInt("Green_B", 115);
        ET_Green_R.setText(Color_R.toString());
        ET_Green_G.setText(Color_G.toString());
        ET_Green_B.setText(Color_B.toString());
        View_Green.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
    }

    void CreateButton() {
        Btn_Black = (Button) findViewById(R.id.black_check);
        Btn_Black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = pref.edit();
                Integer Color_R, Color_G, Color_B;
                Color_R = Integer.parseInt(ET_Black_R.getText().toString());
                Color_G = Integer.parseInt(ET_Black_G.getText().toString());
                Color_B = Integer.parseInt(ET_Black_B.getText().toString());
                editor.putInt("Black_R", Color_R);
                editor.putInt("Black_G", Color_G);
                editor.putInt("Black_B", Color_B);
                View_Black.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
                editor.commit();
            }
        });
        Btn_White = (Button) findViewById(R.id.white_check);
        Btn_White.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = pref.edit();
                Integer Color_R, Color_G, Color_B;
                Color_R = Integer.parseInt(ET_White_R.getText().toString());
                Color_G = Integer.parseInt(ET_White_G.getText().toString());
                Color_B = Integer.parseInt(ET_White_B.getText().toString());
                editor.putInt("White_R", Color_R);
                editor.putInt("White_G", Color_G);
                editor.putInt("White_B", Color_B);
                View_White.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
                editor.commit();
            }
        });
        Btn_Red = (Button) findViewById(R.id.red_check);
        Btn_Red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = pref.edit();
                Integer Color_R, Color_G, Color_B;
                Color_R = Integer.parseInt(ET_Red_R.getText().toString());
                Color_G = Integer.parseInt(ET_Red_G.getText().toString());
                Color_B = Integer.parseInt(ET_Red_B.getText().toString());
                editor.putInt("Red_R", Color_R);
                editor.putInt("Red_G", Color_G);
                editor.putInt("Red_B", Color_B);
                View_Red.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
                editor.commit();
            }
        });
        Btn_Blue = (Button) findViewById(R.id.blue_check);
        Btn_Blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = pref.edit();
                Integer Color_R, Color_G, Color_B;
                Color_R = Integer.parseInt(ET_Blue_R.getText().toString());
                Color_G = Integer.parseInt(ET_Blue_G.getText().toString());
                Color_B = Integer.parseInt(ET_Blue_B.getText().toString());
                editor.putInt("Blue_R", Color_R);
                editor.putInt("Blue_G", Color_G);
                editor.putInt("Blue_B", Color_B);
                View_Blue.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
                editor.commit();
            }
        });
        Btn_Yellow = (Button) findViewById(R.id.yellow_check);
        Btn_Yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = pref.edit();
                Integer Color_R, Color_G, Color_B;
                Color_R = Integer.parseInt(ET_Yellow_R.getText().toString());
                Color_G = Integer.parseInt(ET_Yellow_G.getText().toString());
                Color_B = Integer.parseInt(ET_Yellow_B.getText().toString());
                editor.putInt("Yellow_R", Color_R);
                editor.putInt("Yellow_G", Color_G);
                editor.putInt("Yellow_B", Color_B);
                View_Yellow.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
                editor.commit();
            }
        });
        Btn_Green = (Button) findViewById(R.id.green_check);
        Btn_Green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = pref.edit();
                Integer Color_R, Color_G, Color_B;
                Color_R = Integer.parseInt(ET_Green_R.getText().toString());
                Color_G = Integer.parseInt(ET_Green_G.getText().toString());
                Color_B = Integer.parseInt(ET_Green_B.getText().toString());
                editor.putInt("Green_R", Color_R);
                editor.putInt("Green_G", Color_G);
                editor.putInt("Green_B", Color_B);
                View_Green.setBackgroundColor(Color.rgb(Color_R, Color_G, Color_B));
                editor.commit();
            }
        });
    }
}
