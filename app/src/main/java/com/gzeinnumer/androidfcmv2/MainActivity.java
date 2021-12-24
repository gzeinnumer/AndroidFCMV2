package com.gzeinnumer.androidfcmv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainAct_ivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, FirebaseMessagingService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: "+ FirebaseInstanceId.getInstance().getToken());

        ((TextView)findViewById(R.id.tv)).setText(FirebaseInstanceId.getInstance().getToken());
    }
}