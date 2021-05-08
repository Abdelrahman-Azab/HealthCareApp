package com.example.android.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class dietsection extends AppCompatActivity {
Button mbackbutton;
ImageView mdiet1,mdiet2,mdiet3,mdiet4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietsection);
        mbackbutton=(Button) findViewById(R.id.back_button);
        mdiet1=(ImageView) findViewById(R.id.diet1);
        mdiet2=(ImageView) findViewById(R.id.diet2);
        mdiet3=(ImageView) findViewById(R.id.diet3);
        mdiet4=(ImageView) findViewById(R.id.diet4);
        mbackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dietsection.this,CardViewMenu.class);
                intent.putExtra("Email",getIntent().getStringExtra("Email"));
                startActivity(intent);
                finish();
            }
        });
        mdiet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d1=new Intent(dietsection.this,diet1.class);
                startActivity(d1);
                finish();
            }
        });
        mdiet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d2=new Intent(dietsection.this,diet2.class);
                startActivity(d2);
                finish();
            }
        });
        mdiet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d3=new Intent(dietsection.this,diet3.class);
                startActivity(d3);
                finish();
            }
        });
        mdiet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d4=new Intent(dietsection.this,diet4.class);
                startActivity(d4);
                finish();
            }
        });
    }
}
