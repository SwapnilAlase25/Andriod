package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvDet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail);

        tvDet = findViewById(R.id.ShowDetails);

        Intent recintent = getIntent();

        String name= recintent.getStringExtra("KEY_VALUE");
        tvDet.setText("Name: "+name);
    }
}
