package com.tabqydriver.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.tabqydriver.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    TextView activity_login_tv_login,activity_login_tv_forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        activity_login_tv_login = findViewById(R.id.activity_login_tv_login);
        activity_login_tv_forgot_password = findViewById(R.id.activity_login_tv_forgot_password);

        activity_login_tv_login.setOnClickListener(this);
        activity_login_tv_forgot_password.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.activity_login_tv_login:
               startActivity(new Intent(Login.this, MainActivity.class));
               Toast.makeText(this, "Successful login", Toast.LENGTH_SHORT).show();
               break;
           case R.id.activity_login_tv_forgot_password:
               startActivity(new Intent(Login.this, ForgotPassword.class));
               break;
               default:
                   break;
       }
         /*if (view.getId()==R.id.activity_login_tv_login){
            startActivity(new Intent(Login.this,MainActivity.class));
            Toast.makeText(this, "Successful login", Toast.LENGTH_SHORT).show();
        }
        else {}*/
    }
}
