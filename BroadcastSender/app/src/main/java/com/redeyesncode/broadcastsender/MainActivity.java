package com.redeyesncode.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.redeyesncode.broadcastsender.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSend.setOnClickListener(v->{
            Intent intent = new Intent("com.redeyesncode.receiver");
            intent.putExtra("com.redeyesncode.SECRET_MESSAGE",binding.edtMessage.getText().toString());
            sendBroadcast(intent);
        });
    }

}