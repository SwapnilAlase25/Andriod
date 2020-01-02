package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);

        bt=findViewById(R.id.btToMain);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(TestActivity.this,MainActivity.class);
              //  startActivity(intent);
                TestActivity.this.finish();
            }

        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Toast.makeText(TestActivity.this,"DONT USE THISSSS",Toast.LENGTH_SHORT).show();
            return true;
        }


        return super.onKeyDown(keyCode, event);
    }
}

