package com.example.rahee.hotel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends AppCompatActivity {
    EditText susername, spassword;
    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        susername= (EditText) findViewById(R.id.susername);
        spassword= (EditText) findViewById(R.id.spassword);
        start= (Button) findViewById(R.id.start);

           start.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   SharedPreferences prefs=getSharedPreferences("security",MODE_PRIVATE);
                   String usname=prefs.getString("username","not set"); //to retrieve from database
                   String passw=prefs.getString("password", "not set");

                   String suname=susername.getText().toString().trim();
                   String spass=spassword.getText().toString().trim();


                   if (usname.equals(suname) && passw.equals(spass)){
                       Toast.makeText(Signin.this, "You are now signed in", Toast.LENGTH_SHORT).show();
                       Intent ss=new Intent(getApplicationContext(),HomeActivity.class);
                       startActivity(ss);

                   }//end of if statement
                   else{

                       Toast.makeText(Signin.this, "Your password is incorrect", Toast.LENGTH_SHORT).show();
                       start.setEnabled(false);
                   }//end of else
               }


           });

    }
}
