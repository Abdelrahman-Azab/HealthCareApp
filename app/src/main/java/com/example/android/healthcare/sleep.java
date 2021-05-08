package com.example.android.healthcare;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.PeriodicSync;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

import androidx.annotation.RequiresApi;

public class sleep extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
private TextView mtextalarm;
Button mtimepicker,mcancelalarm,mbackbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        mtextalarm=(TextView) findViewById(R.id.alarmtext);
        mtimepicker=(Button) findViewById(R.id.timepicker_button);
        mcancelalarm=(Button) findViewById(R.id.cancel_alarm);
        mbackbutton=(Button) findViewById(R.id.back_button);
        mbackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(sleep.this,CardViewMenu.class);
                intent.putExtra("Email",getIntent().getStringExtra("Email"));
                startActivity(intent);
                finish();
            }
        });

        mtimepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timepicker=new  TimePickerFragment();
                timepicker.show(getSupportFragmentManager(),"Time Picker");
            }
        });
        mcancelalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              cancelalarm();
            }
        });
    }
    private void cancelalarm() {
        AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent alarmmm=new Intent(this,AlertReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,1,alarmmm,0);
        alarmManager.cancel(pendingIntent);
        mtextalarm.setText("Alarm Canceled");

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        updateTimeText(c);
        startAlarm(c);
    }
    private void updateTimeText(Calendar c) {
        String timeText = "Alarm set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        mtextalarm.setText(timeText);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

            alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);

    }

}
