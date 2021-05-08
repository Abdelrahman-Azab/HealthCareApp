package com.example.android.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class water_section extends AppCompatActivity {
Button mbackbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_section);
        mbackbutton=(Button) findViewById(R.id.back_button);
        mbackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(water_section.this,CardViewMenu.class);
                intent.putExtra("Email",getIntent().getStringExtra("Email"));
                startActivity(intent);
                finish();
            }
        });
    }
}
