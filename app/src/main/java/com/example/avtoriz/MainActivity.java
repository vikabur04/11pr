package com.example.avtoriz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edit_user;
    private EditText edit_password;
    private Button button_login;
    private TextView loginLocked;
    private TextView textView2;
    private TextView textView;
    private TextView soob;

    int numberOfRemainingLoginAttempts = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_user=(EditText) findViewById(R.id.edit_user);
        edit_password=(EditText) findViewById(R.id.edit_password);
        button_login=(Button) findViewById(R.id.button_login);
        loginLocked=(TextView) findViewById(R.id.textView3);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView = (TextView) findViewById(R.id.textView);
        soob = (TextView) findViewById(R.id.soob);

        View.OnClickListener GoTo=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_user.getText().toString().equals("admin") &&
                        edit_password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Вход выполнен!",Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(MainActivity.this, second.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Неправильные данные!",Toast.LENGTH_SHORT).show();
                    numberOfRemainingLoginAttempts= numberOfRemainingLoginAttempts -1;
                    if ( numberOfRemainingLoginAttempts < 1){
                        finish();
                    }
                    else{
                        soob.setText("У вас осталось"+ numberOfRemainingLoginAttempts+ "попыток");


                    }


                }

                }
        };
        button_login.setOnClickListener(GoTo);


    }
}