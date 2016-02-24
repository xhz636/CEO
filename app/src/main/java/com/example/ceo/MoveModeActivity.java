package com.example.ceo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoveModeActivity extends Activity{

    private Button Move_Up;
    private Button Move_Down;
    private Button Move_Left;
    private Button Move_Right;
    private BlueToothControl BT_Control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_mode);
        InitBlueTooth();
        CreateButton();
    }

    void InitBlueTooth() {
        BT_Control = new BlueToothControl(this);
        BT_Control.connect();
    }

    void CreateButton() {
        Move_Up = (Button) findViewById(R.id.move_up);
        Move_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_Control.sendMsg("U");
            }
        });
        Move_Down = (Button) findViewById(R.id.move_down);
        Move_Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_Control.sendMsg("D");
            }
        });
        Move_Left = (Button) findViewById(R.id.move_left);
        Move_Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_Control.sendMsg("L");
            }
        });
        Move_Right = (Button) findViewById(R.id.move_right);
        Move_Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_Control.sendMsg("R");
            }
        });
    }
}
