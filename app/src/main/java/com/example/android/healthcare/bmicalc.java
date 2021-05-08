package com.example.android.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmicalc extends AppCompatActivity {
EditText mweight,mheight;
Button mcalculate;
TextView mresult;
Button bresult,mbackbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalc);
        mweight=(EditText) findViewById(R.id.weight);
        mheight=(EditText) findViewById(R.id.height);
        mcalculate=(Button) findViewById(R.id.calculate);
        mresult=(TextView) findViewById(R.id.result);
        bresult=(Button) findViewById(R.id.result_button);
        mbackbutton=(Button) findViewById(R.id.back_button);
        mbackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bmicalc.this,CardViewMenu.class);
                intent.putExtra("Email",getIntent().getStringExtra("Email"));
                startActivity(intent);
                finish();
            }
        });
        mcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float w= Float.parseFloat((mweight.getText().toString()));
                float h= (float) (Float.parseFloat(mheight.getText().toString())/(100.0));
                float bmi=w/(h*h);

                 if(bmi<18.5)
                {
                    mresult.setText("Under Weight");
                    bresult.setVisibility(View.VISIBLE);
                    bresult.setText("Go to Diet 1");
                    bresult.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent d1=new Intent(bmicalc.this,diet1.class);
                            startActivity(d1);
                            finish();
                        }
                    });
                }
                else if(bmi>=18.5 && bmi<=24.9)
                {
                    mresult.setText("Normal Weight");
                    bresult.setVisibility(View.VISIBLE);
                    bresult.setText("Go to Diet 2");
                    bresult.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent d2=new Intent(bmicalc.this,diet2.class);
                            startActivity(d2);
                            finish();
                        }
                    });
                }
                else if(bmi>=25 && bmi<=29.9)
                 {
                     mresult.setText("Over Weight");
                     bresult.setVisibility(View.VISIBLE);
                     bresult.setText("Go to Diet 3");
                     bresult.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                             Intent d3=new Intent(bmicalc.this,diet3.class);
                             startActivity(d3);
                             finish();
                         }
                     });
                 }
                 else
                 {
                     mresult.setText("Obese Weight");
                     bresult.setVisibility(View.VISIBLE);
                     bresult.setText("Go to Diet 4");
                     bresult.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                             Intent d4=new Intent(bmicalc.this,diet4.class);
                             startActivity(d4);
                             finish();
                         }
                     });
                 }
            }
        });
    }
}
