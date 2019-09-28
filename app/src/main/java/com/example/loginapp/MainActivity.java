package com.example.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     private EditText username;
     private  EditText password;
     private TextView tvAttempt;
     private Button btnLogin;
     private int att = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        tvAttempt = (TextView)findViewById(R.id.tvAttempt);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(),password.getText().toString());
            }
        });
    }
    private void validate(String user,String pass)
    {
        if((user.equals("Mxolisi"))&& (pass.equals("mxo")))
        {
            Intent go = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(go);
        }
        else
        {
            att--;
            tvAttempt.setText("Attempt left : "+String.valueOf(att));

            if(att == 0)
            {
                btnLogin.setEnabled(false);
            }
        }
    }
}
