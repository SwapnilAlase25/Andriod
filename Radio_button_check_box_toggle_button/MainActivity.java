package com.desd.aug19.day12app1mixview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroupGender;
    CheckBox checkHindi, checkEnglish, checkMarathi;
    ToggleButton toggleNationality;
    Button btSubmit;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            radioGroupGender=findViewById(R.id.radioGroupGender);
            checkEnglish=findViewById(R.id.checkBEnglish);
            checkHindi=findViewById(R.id.checkBHindi);
            checkMarathi=findViewById(R.id.checkBMarathi);
            toggleNationality=findViewById(R.id.toggleBNationality);
            btSubmit=findViewById(R.id.btnSubmit);

            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int id=radioGroupGender.getCheckedRadioButtonId();
                    RadioButton radioButton=findViewById(id);
                    String gender= (String) radioButton.getText();

                    StringBuffer stringBuffer= new StringBuffer();
                    stringBuffer.append("Gender: "+gender);

                    stringBuffer.append("\n Languages: ");

                    if(checkHindi.isChecked()) {
                        stringBuffer.append(" Hindi");
                    }
                    if(checkEnglish.isChecked()) {
                        stringBuffer.append(" English");
                    }
                    if(checkMarathi.isChecked()) {
                        stringBuffer.append(" Marathi");
                    }

                    stringBuffer.append("\n");

                    if(toggleNationality.isChecked()){
                        String textON= (String) toggleNationality.getTextOn();
                        stringBuffer.append("Nationality: "+textON);
                    }else {
                        String textOFF= (String) toggleNationality.getTextOff();
                        stringBuffer.append("Nationality: "+textOFF);
                    }

                    Toast.makeText(
                            MainActivity.this,stringBuffer,Toast.LENGTH_SHORT).show();





                }
            });
        }
}
