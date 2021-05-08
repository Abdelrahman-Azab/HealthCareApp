package com.example.android.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    private DatabaseHelper db;
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText re_password;
    private EditText phone;
    private Button sign_up;
    private Button mbackbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db=new DatabaseHelper(this);
        username=(EditText) findViewById(R.id.username_edittext);
        email=(EditText) findViewById(R.id.email_edittext);
        password=(EditText) findViewById(R.id.password_edittext);
        re_password=(EditText) findViewById(R.id.re_password_edittext);
        phone=(EditText) findViewById(R.id.phone_edittext);
        sign_up=(Button) findViewById(R.id.sign_up_button);
        mbackbutton=(Button) findViewById(R.id.back_button);
        mbackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(register.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
sign_up.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String usernamee=username.getText().toString();
        String emaill=email.getText().toString();
        String passwordd=password.getText().toString();
        String re_passwordd=re_password.getText().toString();
        String phonee=phone.getText().toString();
        if(usernamee.equals("") || emaill.equals("")|| passwordd.equals("")||re_passwordd.equals("")||phonee.equals(""))
        {
            Toast.makeText(register.this,"Empty Creditianls",Toast.LENGTH_SHORT).show();
        }
        else if (!passwordd.equals(re_passwordd))
        {
            Toast.makeText(register.this,"Password Doesn't match",Toast.LENGTH_SHORT).show();
        }
        else if (phonee.length()!=11)
        {
            Toast.makeText(register.this,"Phone length is wrong",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Boolean checkemaill=db.checkemail(emaill);
            if(checkemaill)
            {
                Boolean insert=db.insert(usernamee,emaill,passwordd,phonee);
                if(insert)
                {
                    Toast.makeText(register.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(register.this,CardViewMenu.class);
                    startActivity(intent);
                    finish();

                }
            }
            else
            {
                Toast.makeText(register.this,"Email Already exists",Toast.LENGTH_SHORT).show();
            }
        }
    }
});
}



    }

