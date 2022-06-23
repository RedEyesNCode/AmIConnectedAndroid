package com.redeyesncode.amiconnectedandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AmIConnectedReciever connectivityReceiver;
// So in order to implement a simple Implicit Broadcast reciever we need to
    // 1. Create a class of the broadcast and overide onReceive method of it
    // 2. Declare it in the manifest file and also mention the action of our receiver will listen to
    // We are statically telling the receiver to listen for this event that's why it is called as the implicit broadcast receiver

    // STATIC --> DECLARED IN MANIFEST (CONSUMES BATTERY UNSAFE , WILL RUN EVEN IF THE APP IS CLOSED)
    // DYNAMIC --> DECLARED AT RUNTIME (CONSUMES LESS BATTERY SAFE, WILL NOT RUN IF THE APP IS CLOSED)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialzeReceiver();
        // FOR Some reason the manifest declared broadcast receiver are not working in android 12.
        // will look into it.

        // The reason behind this is from android 7.0 (n) The implicit receiver which are declared in the
        // Manifest file are depcrecated so we are left with only dynamic reciever which i have described below.


        setContentView(R.layout.activity_main);
    }

    // On start and onStop will run our receiver only when our app is in the foreground

    // if you want to runn the Receiver in background use register in onCreate and unregister in oNDestroy.




    private void initialzeReceiver(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        Toast.makeText(this, "Receiver Intialzed  !", Toast.LENGTH_SHORT).show();

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //do something based on the intent's action
                Log.i("ASHU-->",intent.getAction());
                // we will check if the intent received is of the proper action or not

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
        registerReceiver(receiver, filter);
    }

}