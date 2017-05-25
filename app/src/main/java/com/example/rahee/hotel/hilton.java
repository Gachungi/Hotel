package com.example.rahee.hotel;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class hilton extends AppCompatActivity {
    WebView hilton;
    Button call;
    ImageView share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilton);
        share = (ImageView) findViewById(R.id.share);
        hilton = (WebView) findViewById(R.id.hilton);
        hilton.loadUrl("file:///android_asset/hilton.html");

        call = (Button) findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent piga = new Intent(Intent.ACTION_CALL);
                piga.setData(Uri.parse("tel 0731932771"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(piga);

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(Intent.ACTION_SEND);
                s.setType("text/plain"); //used to specify what you're sharing eg image
                s.putExtra(Intent.EXTRA_SUBJECT,"hilton");
                s.putExtra(Intent.EXTRA_TEXT, "Welcome to Hilton: http://hilton.com");
                startActivity(Intent.createChooser(s, "share our link"));
            }
        });




    }
}
