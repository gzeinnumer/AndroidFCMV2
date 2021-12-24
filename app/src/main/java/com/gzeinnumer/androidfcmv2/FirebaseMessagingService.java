package com.gzeinnumer.androidfcmv2;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    private final String TAG = "Fireb_aseMessaging";

    public FirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        sendNotif(remoteMessage);
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.d(TAG, "onNewToken: "+s);
    }

    private void sendNotif(RemoteMessage remoteMessage) {
        Log.e(TAG, "sendNotif: " + remoteMessage.getData().get("id"));
        Log.e(TAG, "sendNotif: " + remoteMessage.getNotification().getTitle());
        Log.e(TAG, "sendNotif: " + remoteMessage.getNotification().getBody());

        final NotificationHelper notificationHelper = new NotificationHelper(this);
        notificationHelper.createNotification("Reminder", "Apakah anda sudah mengisi DSR hari ini?");
    }
}