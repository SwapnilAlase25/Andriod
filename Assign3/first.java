package com.example.assign3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class first extends AppCompatActivity {

    TextView name,rollno,c,cpp,java,total,perc;
    Button btback;
    float totalm;
    float percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        name = findViewById(R.id.tvName);
        rollno = findViewById(R.id.tvRoll);
        c = findViewById(R.id.tvC);
        cpp = findViewById(R.id.tvCpp);
        java = findViewById(R.id.tvJava);
        total = findViewById(R.id.tvTotal);
        perc = findViewById(R.id.tvPer);

        btback = findViewById(R.id.btnToBack);

        Intent recIntent = getIntent();


        String recName = recIntent.getStringExtra("KEY_NAME");
        String recRoll = recIntent.getStringExtra("KEY_ROLL");
        int recC = recIntent.getIntExtra("KEY_C",0);
        int recCpp = recIntent.getIntExtra("KEY_CPP",0);
        int recJava = recIntent.getIntExtra("KEY_JAVA",0);

        name.setText("Name: "+recName);
        rollno.setText("RollNo "+recRoll);
        c.setText("C: "+recC+" Marks");
        cpp.setText("C++: "+recCpp+" Marks");
        java.setText("Java: "+recJava+" Marks");

        totalm = recC + recCpp + recJava;
        total.setText("Total: "+totalm);

        percent = (totalm/300)*100;
        perc.setText("Percentage: "+percent+"%");

       final String totalstring=String.valueOf(totalm);
        final String perstring=String.valueOf(percent);

        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent rexintent = new Intent();
                rexintent.putExtra("KEY_TOTAL",totalstring);
                rexintent.putExtra("KEY_PERCENTAGE",perstring);
                setResult(RESULT_OK,rexintent);

                first.this.finish();

            }
        });



    }
}
