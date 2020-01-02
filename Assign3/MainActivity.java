package com.example.assign3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etname,etroll,etc,etcplusplus,etjava;
    EditText NameEditText,wordEditText;
    Button btsubmit;
    TextView total,percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.editName);
        etroll = findViewById(R.id.editRollNo);
        etc = findViewById(R.id.editCmarks);
        etcplusplus = findViewById(R.id.editCplussplusmarks);
        etjava = findViewById(R.id.editJavamarks);

        btsubmit = findViewById(R.id.btSubmit);

        total = findViewById(R.id.tvTotalMarks);
        percentage = findViewById(R.id.tvPercentage);

        NameEditText = findViewById(R.id.NameEditText);
        wordEditText = findViewById(R.id.wordEditText);

        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etname.getText().toString();
                String rollno = etroll.getText().toString();
                String cmarks = etc.getText().toString();
                String cppmarks = etcplusplus.getText().toString();
                String javamarks = etjava.getText().toString();


                if(name.equals("") || rollno.equals("") || cmarks=="" || cppmarks=="" || javamarks==""){

                    if(name.length()==0)

                    {
                        NameEditText.requestFocus();
                        NameEditText.setError("FIELD CANNOT BE EMPTY");
                    }

                    else if(!name.matches("[a-zA-Z ]+"))
                    {
                        NameEditText.requestFocus();
                        NameEditText.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                    }

                    if(rollno.length()==0)
                    {
                        wordEditText.requestFocus();
                        wordEditText.setError("FIELD CANNOT BE EMPTY");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Validation Successful",Toast.LENGTH_LONG).show();
                    }


                        //Toast.makeText(MainActivity.this,"Enter all Details",Toast.LENGTH_LONG).show();


                    }
                else {


                    etname.setText("");
                    etroll.setText("");
                    etc.setText("");
                    etcplusplus.setText("");
                    etjava.setText("");

                    int cm=Integer.parseInt(cmarks);
                    int cppm=Integer.parseInt(cppmarks);
                    int javam=Integer.parseInt(javamarks);

                    String action = "desdaction1";
                    Intent intent = new Intent(action);

                    intent.putExtra("KEY_NAME", name);
                    intent.putExtra("KEY_ROLL", rollno);
                    intent.putExtra("KEY_C", cm);
                    intent.putExtra("KEY_CPP", cppm);
                    intent.putExtra("KEY_JAVA", javam);

                    startActivityForResult(intent, 11);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==11 && resultCode==RESULT_OK){

            Float ShowTotal = Float.parseFloat(data.getStringExtra("KEY_TOTAL"));
            Float ShowPer = Float.parseFloat(data.getStringExtra("KEY_PERCENTAGE"));

            total.setText("Total: "+ShowTotal);
            percentage.setText("Total: "+ShowPer);
        }
    }
}
