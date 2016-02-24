package com.example.ceo;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

public class BlueToothControl {

    private Activity ControlActivity;
    private BluetoothAdapter BT_Adapter;
    private BluetoothSocket BT_Socket;
    private OutputStream OStream;
    private InputStream IStream;

    public BlueToothControl(Activity activity_in) {
        ControlActivity = activity_in;
    }

    public boolean connect() {
        BT_Adapter = BluetoothAdapter.getDefaultAdapter();
        if(BT_Adapter == null)
            return false;
        if(!BT_Adapter.isEnabled())
        {
            Intent BT_Intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            ControlActivity.startActivity(BT_Intent);
        }
        Set<BluetoothDevice> BT_Device = BT_Adapter.getBondedDevices();
        return true;
    }

    public boolean sendMsg(String Msg) {
        return true;
    }
}
