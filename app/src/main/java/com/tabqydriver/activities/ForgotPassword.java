package com.tabqydriver.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tabqydriver.R;

        public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {


            private TextView forgot_password_reset_password;
            private EditText forgot_password_email;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_forgot_password);

                forgot_password_reset_password = findViewById(R.id.forgot_password_reset_password);
                forgot_password_email = findViewById(R.id.forgot_password_email);

                forgot_password_reset_password.setOnClickListener(this);
                forgot_password_email.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                final String Email = forgot_password_email.getText().toString().trim();
                if (v.getId() == R.id.forgot_password_reset_password) {
                    finish();
                    /*if (Email.length() == 0) {
                        forgot_password_email.requestFocus();
                        forgot_password_email.setError("FIELD CANN'T BE EMPTY");
                    } else if (!Email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
                        forgot_password_email.requestFocus();
                        forgot_password_email.setError("ENTER VALID EMAIL ADDRESS");
                    } else {
                        //startActivity(new Intent(ForgotPassword.this,MainActivity.class));
                        finish();
                    }*/
                }
                else {}
            }
        }
