package com.example.rahee.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button totest;
    ListView list;
    String[] items={"Hilton", "Serena", "Intercon", "Weston", "Norfork"};
    ArrayAdapter<String> aa; //to specify exactly what type of array the adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totest = (Button) findViewById(R.id.totest);
        list = (ListView) findViewById(R.id.list);
        //pass 3 parameters: this page, design/style, my array
        aa=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,items);

        list.setAdapter(aa);


       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String items = (String) (list.getItemAtPosition(position));

               if (position==0) {
                   Intent h = new Intent(getApplicationContext(), hilton.class);
                   startActivity(h);
               }
               else if (position==1) {

                   Intent s = new Intent(getApplicationContext(), hilton.class);
                   startActivity(s);
               }
               else {

                   Intent i = new Intent(getApplicationContext(), hilton.class);
                   startActivity(i);

               }

           }
       });

        totest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent t = new Intent(getApplicationContext(), test.class);
                startActivity(t);
            }
        });


    }
}