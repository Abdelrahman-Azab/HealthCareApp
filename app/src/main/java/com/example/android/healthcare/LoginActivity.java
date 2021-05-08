package com.example.android.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button sign_in;
    private DatabaseHelper db;
    private TextView sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHelper(this);
        email=(EditText) findViewById(R.id.emaill_edittext);
        password=(EditText) findViewById(R.id.passwordd_edittext);
        sign_in=(Button)findViewById(R.id.sign_in_button);
         sign_up =(TextView) findViewById(R.id.sign_up_textview);
         sign_up.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
           Intent registerr=new Intent(LoginActivity.this,register.class);
            startActivity(registerr);
            finish();
    }
});
         sign_in.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String emaill=email.getText().toString();
                 String passwordd=password.getText().toString();
                 Boolean checkemailpass=db.emailpassword(emaill,passwordd);
                 if(checkemailpass==true)
                 {
                     Toast.makeText(getApplicationContext(),"Sucessfully Login",Toast.LENGTH_SHORT).show();
                     Intent person_data=new Intent(LoginActivity.this,CardViewMenu.class);
                     person_data.putExtra("Email",emaill);
                     startActivity(person_data);
                     finish();

                 }
                 else
                 {
                     Toast.makeText(getApplicationContext(),"Wrong email or Password",Toast.LENGTH_SHORT).show();
                 }
             }
         });
    }
}
