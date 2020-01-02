package com.example.multipleactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button  bt1 ,bt2;
    //static int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.btToTest);
        bt2=findViewById(R.id.btToExit);

                                            //explicit approach
                                            bt1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent = new Intent(
                                                            MainActivity.this,
                                                            TestActivity.class
                                                    );
                                                    startActivity(intent);
                                                }
                                            });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage("ARE u SURE TO EXIT??");
                dialog.setIcon(R.drawable.download);
                 dialog.setTitle("Alert!!!");

                 dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         MainActivity.this.finish();
                     }
                 });

                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                 dialog.show();


                 /*if(flag==1) {
                    flag=0;
                    MainActivity.this.finish();
                }
                else{
                    Toast.makeText(MainActivity.this,"Do U want to really Exit ??",Toast.LENGTH_SHORT).show();
                    flag=1;
                }*/

            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK)
        {

            Toast.makeText(MainActivity.this,"Back button disabled",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}

