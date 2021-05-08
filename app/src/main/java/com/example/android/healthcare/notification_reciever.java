package com.example.android.healthcare;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class notification_reciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"notiffy")
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("Water section")
                .setContentText("You may be want to drink water now!!!")
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT );
        NotificationManagerCompat notificationManager =NotificationManagerCompat.from(context);
        notificationManager.notify(200,builder.build());

    }
}