package com.example.android.healthcare;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class footSteps extends AppCompatActivity {

    SensorManager sensorManager;
    CircularProgressBar progressBar;
    TextView steps;
    Boolean running = false;
   private double Magnitudeprevious=0;
    private Integer step_count=0;
    Button reset_button,mbackbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot_steps);
        steps = (TextView) findViewById(R.id.steps_taken);
        progressBar=(CircularProgressBar) findViewById(R.id.circularProgressBar);
        reset_button=(Button) findViewById(R.id.reset_button);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mbackbutton=(Button) findViewById(R.id.back_button);
        mbackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(footSteps.this,CardViewMenu.class);
                intent.putExtra("Email",getIntent().getStringExtra("Email"));
                startActivity(intent);
                finish();
            }
        });

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
              if(sensorEvent!=null)
              {
                  float x_acceleration=sensorEvent.values[0];
                  float y_acceleration=sensorEvent.values[1];
                  float z_acceleration=sensorEvent.values[2];
                  double Magnitude=Math.sqrt(x_acceleration*x_acceleration+y_acceleration*y_acceleration+z_acceleration*z_acceleration);
                  double MagnitudeDelta=Magnitude-Magnitudeprevious;
                  Magnitudeprevious=Magnitude;
                  if(MagnitudeDelta>4)
                  {
                      step_count++;
                      progressBar.setVisibility(View.VISIBLE);
                      progressBar.setProgress(step_count.floatValue());

                  }
                  steps.setText(step_count.toString());
              }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        sensorManager.registerListener(sensorEventListener,countSensor,SensorManager.SENSOR_DELAY_NORMAL);
        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step_count=0;
                steps.setText(step_count.toString());
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(step_count.floatValue());
            }
        });
    }



}
