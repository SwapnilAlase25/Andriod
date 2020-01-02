package com.example.multipletasks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btn1;
    EditText etName,etAge;
    TextView showfeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.BtnToFirst);
        etName= findViewById(R.id.editName);
        etAge = findViewById(R.id.editAge);
        showfeedback = findViewById(R.id.ShowFeedBack);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());

                etName.setText("");
                etAge.setText("");

            String action = "desdaction";
            Intent intent = new Intent(action);

            intent.putExtra("KEY_NAME",name);
            intent.putExtra("KEY_AGE",age);

            //startActivity(intent);
            startActivityForResult(intent,11);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==11 && resultCode==RESULT_OK){

            String fb = data.getStringExtra("KEY_FEEDBACK");

            showfeedback.setText("FeedBack: "+fb);
            showfeedback.setTextColor(Color.RED);
        }
    }
}
