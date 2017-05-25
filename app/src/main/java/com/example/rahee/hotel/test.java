package com.example.rahee.hotel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class test extends AppCompatActivity {

    EditText username, password;
    Button register, signin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        register= (Button) findViewById(R.id.register);
        signin= (Button) findViewById(R.id.signin);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //we are going to store data in edittext using getstring
                //get the text,convert to string

                String uname=username.getText().toString().trim();//retrieve data
                String pass=password.getText().toString().trim();//retrieve data

                //first parameter is database, then access
                SharedPreferences.Editor editor = getSharedPreferences("security",MODE_PRIVATE).edit();
                editor.putString("username",uname);//package the input(key, value)
                editor.putString("password", pass);


                editor.commit(); //save to database

                Toast.makeText(test.this, "successful", Toast.LENGTH_SHORT).show();

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test.this, Signin.class));
            }
        });
    }
}
