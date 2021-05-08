package com.example.android.healthcare;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
public class NotificationHelper extends ContextWrapper {
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";
    private static Uri alarmSound;
    private NotificationManager mManager;

    public NotificationHelper(Context base) {
        super(base);

            createChannel();

    }
    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
        getManager().createNotificationChannel(channel);
    }
    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }
    public NotificationCompat.Builder getChannelNotification() {
        alarmSound=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle("Alarm!")
                .setContentText("Your AlarmManager is working.")
                .setSmallIcon(R.drawable.ic_alarm)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setSound(alarmSound);

    }
}

