package com.example.android.healthcare;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CardViewMenu extends AppCompatActivity {
private LinearLayout workout;
private LinearLayout sleep;
private LinearLayout footsteps;
private LinearLayout bmii;
private LinearLayout diet;
private LinearLayout water;
    TextView username1;
    TextView email1;
   DatabaseHelper db;
    String em;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_menu);
        workout = (LinearLayout) findViewById(R.id.workout);
        db=new DatabaseHelper(this);
        footsteps = (LinearLayout) findViewById(R.id.footstep);
        sleep = (LinearLayout) findViewById(R.id.sleepsection);
        bmii = (LinearLayout) findViewById(R.id.bmisection);
        diet = (LinearLayout) findViewById(R.id.diet_section);
        water = (LinearLayout) findViewById(R.id.water_section);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        View vi=navigationView.getHeaderView(0);
        username1=(TextView)vi.findViewById(R.id.username) ;
        email1=(TextView)vi.findViewById(R.id.email);
         em=getIntent().getExtras().getString("Email");
        String us=db.getName(em);
           username1.setText(us);
           email1.setText(em);
        navigationView.getMenu().findItem(R.id.log_out).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent logout = new Intent(CardViewMenu.this, LoginActivity.class);
                startActivity(logout);
                finish();
                return false;
            }
        });

        navigationView.getMenu().findItem(R.id.training).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent training = new Intent(CardViewMenu.this, WorkOut.class);
                startActivity(training);
                finish();
                return false;
            }
        });
    createNotficationchannel();
        water.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), notification_reciever.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(CardViewMenu.this, 1, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                long timeAtButtonClick = System.currentTimeMillis();
                long tenSecond = 1000 * 60*30;
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeAtButtonClick + tenSecond,AlarmManager.INTERVAL_HALF_HOUR, pendingIntent);
                Intent water = new Intent(CardViewMenu.this, water_section.class);
                water.putExtra("Email",em);
                startActivity(water);
                finish();
            }
        });
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workout_activity = new Intent(CardViewMenu.this, WorkOut.class);
                startActivity(workout_activity);
                finish();
            }
        });
        footsteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent footstep_activity = new Intent(CardViewMenu.this, footSteps.class);
                footstep_activity.putExtra("Email",em);
                startActivity(footstep_activity);
                finish();
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sleep_activity = new Intent(CardViewMenu.this, sleep.class);
                sleep_activity.putExtra("Email",em);
                startActivity(sleep_activity);
                finish();
            }
        });
        bmii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bmi_activity = new Intent(CardViewMenu.this, bmicalc.class);
                bmi_activity.putExtra("Email",em);
                startActivity(bmi_activity);
                finish();
            }
        });
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent diet_activity = new Intent(CardViewMenu.this, dietsection.class);
                diet_activity.putExtra("Email",em);
                startActivity(diet_activity);
                finish();
            }
        });
    }
        private void createNotficationchannel () {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "LemubitReminderChannel";
                String description = "Channel for lemubit Reminder";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel("notiffy", name, importance);
                channel.setDescription(description);

                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }
        }
}
