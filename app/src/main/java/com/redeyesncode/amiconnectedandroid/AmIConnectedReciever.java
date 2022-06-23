package com.redeyesncode.amiconnectedandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;
// WILL NOT WORK IN ANDROID 12..

public class AmIConnectedReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("ASHU-->",intent.getAction());
        // we will check if the intent received is of the proper action or not

        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean isConnected = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
            if(isConnected){
                Toast.makeText(context, "Connected !", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Disconnected ! ", Toast.LENGTH_SHORT).show();
            }

        }



    }
}
