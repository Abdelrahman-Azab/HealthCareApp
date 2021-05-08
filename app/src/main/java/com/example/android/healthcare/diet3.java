package com.example.android.healthcare;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class diet3 extends AppCompatActivity {
Button mbackbutton,donebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet3);
        mbackbutton=(Button) findViewById(R.id.back_button);
        mbackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(diet3.this,dietsection.class);
                startActivity(intent);
                finish();
            }
        });
        donebutton=(Button) findViewById(R.id.donediet);
        donebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialogbutton();
            }
        });
    }
    public void opendialogbutton()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(diet3.this);
        builder.setTitle("Congratulations")
                .setMessage("Whoooo,Nice Job.Waiting for Next Day!!!")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
