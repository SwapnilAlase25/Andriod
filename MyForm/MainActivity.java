package com.example.myform;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name,prn;
    RadioGroup rg;
    CheckBox cbEng,cbMar;
    Spinner spCourse;
    Button btSubmit;
    TextView tvFeedback;

    String courseName;

    String [] listofCourses= {"Select Course","PG-DESD","PG-DAC","PG-VLSI","PG-DBDA","PG-DITISS","PG-DAI"};

    ArrayAdapter<String> adapterCousreName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editName);
        prn = findViewById(R.id.editPrn);
        rg = findViewById(R.id.radiogroup);
        cbEng = findViewById(R.id.cbEnglish);
        cbMar = findViewById(R.id.cbMarathi);
        spCourse = findViewById(R.id.spinnerCourse);
        btSubmit = findViewById(R.id.btSubmit);
        tvFeedback = findViewById(R.id.tvFeedback);

        adapterCousreName = new ArrayAdapter<String>(
                MainActivity.this,android.R.layout.simple_spinner_item,
                listofCourses
        );

        spCourse.setAdapter(adapterCousreName);



        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String studName = name.getText().toString();
                String studPrn = prn.getText().toString();

                int id = rg.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(id);
                String gender = (String) radioButton.getText();

                String lang;
                int i=0,j=0;

                if(cbEng.isChecked()){
                     i=1;
                }

                if(cbMar.isChecked()){
                    j=1;
                }

                if(i==1 && j==1){
                    lang="English,Marathi";
                }else if(i==1 && j==0){
                    lang="English";
                }else if(i==0 && j==1){
                    lang="Marathi";
                }else{
                    lang="No Lang";
                }


                spCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        if(id>0){
                            courseName= (String) parent.getItemAtPosition(position);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                String action = "datatx";
                Intent intent = new Intent(action);

                intent.putExtra("KEY_NAME",studName);
                intent.putExtra("KEY_PRN",studPrn);
                intent.putExtra("KEY_GENDER",gender);
                intent.putExtra("KEY_LANG",lang);
                intent.putExtra("KEY_COURSE",courseName);

                startActivityForResult(intent,11);


            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==11 && resultCode==RESULT_OK){


            String fb = data.getStringExtra("KEY_FEEDBACK");

            tvFeedback.setText("FeedBack: "+fb);
            tvFeedback.setTextColor(Color.RED);

        }

    }
}
