package com.redeyesncode.amiconnectedandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

public class ListenCustomBroadCastActivity extends AppCompatActivity {
    private IntentFilter filter = new IntentFilter();
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if("com.redeyesncode.receiver".equals(intent.getAction())){
                String receivedText = intent.getStringExtra("com.redeyesncode.SECRET_MESSAGE");
                Toast.makeText(context, receivedText + " FROM --> "+getLocalClassName(), Toast.LENGTH_LONG).show();
            }
            if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
                boolean isConnected = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
                if(isConnected){
                    Toast.makeText(context, "Disconnected ! ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Connected !", Toast.LENGTH_SHORT).show();

                }

            }
        }
    };
// even the explicit receiver gets disconnected in android 12 after some time.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_custom_broad_cast);
        filter.addAction("com.redeyesncode.receiver");
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastReceiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}