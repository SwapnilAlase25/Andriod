package com.example.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    TextView name,prn,gen,lang,course;
    Button btBack;
    EditText etFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        name = findViewById(R.id.tvName);
        prn = findViewById(R.id.tvPrn);
        gen = findViewById(R.id.tvGender);
        lang = findViewById(R.id.tvLang);
        course = findViewById(R.id.tvCourse);

        btBack = findViewById(R.id.btback);
        etFeedback = findViewById(R.id.editFeedback);

        Intent recintent = getIntent();

        String rName = recintent.getStringExtra("KEY_NAME");
        String rPrn = recintent.getStringExtra("KEY_PRN");
        String rGen = recintent.getStringExtra("KEY_GENDER");
        String rLang = recintent.getStringExtra("KEY_LANG");
        String rCourse = recintent.getStringExtra("KEY_COURSE");


        name.setText("Name: "+rName);
        prn.setText("PRN: "+rPrn);
        gen.setText("Gender: "+rGen);
        lang.setText("Languages: "+rLang);
        course.setText("Course: "+rCourse);



        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String bufferFB = etFeedback.getText().toString();
                etFeedback.setText("");

                Intent retintent = new Intent();
                retintent.putExtra("KEY_FEEDBACK",bufferFB);
                setResult(RESULT_OK,retintent);

                FirstActivity.this.finish();
            }
        });
    }
}
