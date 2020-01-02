package com.example.multipletasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    Button bt2;
    TextView tname,tage;
    EditText feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        bt2 = findViewById(R.id.BtnToMain);
        tname = findViewById(R.id.TextName);
        tage = findViewById(R.id.TextAge);
        feedback = findViewById(R.id.FeedBack);

        Intent recIntent = getIntent();

        String recName = recIntent.getStringExtra("KEY_NAME");
        int recAge = recIntent.getIntExtra("KEY_AGE",0);

        tname.setText("Name: "+recName);
        tage.setText("Age: "+recAge);


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String bufferFB = feedback.getText().toString();
                feedback.setText("");

                Intent retintent = new Intent();
                retintent.putExtra("KEY_FEEDBACK",bufferFB);
                setResult(RESULT_OK,retintent);

                FirstActivity.this.finish();
            }
        });
    }
}
