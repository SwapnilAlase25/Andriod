package com.example.broadcastrecevier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btnToBc);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                       MainActivity.this,MyBCreceiver.class
              );
                sendBroadcast(intent);
       /* String action = "mydesd";
            Intent intent =  new Intent(action);
        sendBroadcast(intent);*/
            }
        });

    }





}
