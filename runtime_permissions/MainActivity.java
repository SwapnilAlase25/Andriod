package com.example.implicitintent_bluetooth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Color;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvstatus;
    Button btBTon,btBTDisc,btImgCap;
    ImageView ShowImgCapture;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(
                MainActivity.this,new String[]{
                        Manifest.permission.BLUETOOTH,
                        Manifest.permission.BLUETOOTH_ADMIN,
                        Manifest.permission.CAMERA
                },101
        );


        tvstatus=findViewById(R.id.textShowStatus);
        btBTon=findViewById(R.id.btnBtOn);
        btBTDisc=findViewById(R.id.btnBtDisc);
        btImgCap=findViewById(R.id.btnCapImg);
        ShowImgCapture=findViewById(R.id.ShowImg);

        btBTon.setOnClickListener(this);
        btBTDisc.setOnClickListener(this);
        btImgCap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id=v.getId();

        switch(id){

            case R.id.btnBtOn:
                Intent intent = new Intent(
                        BluetoothAdapter.ACTION_REQUEST_ENABLE
                );

                    startActivityForResult(intent,11);
                break;

            case R.id.btnBtDisc:
                Intent intent1 = new Intent(
                        BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE
                );
                startActivityForResult(intent1,12);
                break;

            case R.id.btnCapImg:

                Intent intent2 = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE
                );
                startActivityForResult(intent2,13);
                break;
        }



    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==11){

                tvstatus.setText("Status: Bluetooth is ON");
                tvstatus.setTextColor(Color.GREEN);

        }
        else if(requestCode==12){
            tvstatus.setText("Status: BT Discovery is ON");
            tvstatus.setTextColor(Color.GREEN);
        }

        else if(requestCode==13){
            Bundle bundle = data.getExtras();
            Bitmap img = (Bitmap)bundle.get("data");
            ShowImgCapture.setImageBitmap(img);
            tvstatus.setText("Status:Camera is ON");
            tvstatus.setTextColor(Color.GREEN);

        }
    }
}
