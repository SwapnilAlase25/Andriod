package com.example.studentform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

Button btShowDialog;
    EditText fname,mname,lname;
    Button add,cancel;
TextView ShowName;
EditText prn,age;
Spinner SelectCourse;
Button submit;
ListView liststudents;

String fName,mName,lName;
String name;
    String courseName;

    String [] listofCourses= {"Select Course","PG-DESD","PG-DAC","PG-VLSI","PG-DBDA","PG-DITISS","PG-DAI"};

//step1
ArrayAdapter<String> adpaterCourseName;
ArrayAdapter<String> adapterListStudents;
//ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SharedPreferences sharedPreferences = getSharedPreferences("sPref1",MODE_PRIVATE);

        btShowDialog = findViewById(R.id.btName);
        ShowName = findViewById(R.id.TvName);
        prn = findViewById(R.id.prn);
        age = findViewById(R.id.age);
        SelectCourse = findViewById(R.id.SelectCourse);
        submit = findViewById(R.id.btSubmit);
        liststudents = findViewById(R.id.listStud);


       // arrayList= new ArrayList<String>();

        adapterListStudents = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1
               // arrayList
        );

        liststudents.setAdapter(adapterListStudents);

        //step 2
        adpaterCourseName = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                listofCourses
        );
        //step 3
        SelectCourse.setAdapter(adpaterCourseName);

        //step 4
        SelectCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(id>0) {
                    courseName = (String) parent.getItemAtPosition(position);
                    Toast.makeText(MainActivity.this, "Selected course:  " + courseName, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.layout_dialog);
                dialog.show();

                fname = dialog.findViewById(R.id.editFn);
                mname = dialog.findViewById(R.id.editMn);
                lname = dialog.findViewById(R.id.editLn);
                add = dialog.findViewById(R.id.add);
                cancel= dialog.findViewById(R.id.cancel);



                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        fName=fname.getText().toString();
                        mName=mname.getText().toString();
                        lName=lname.getText().toString();

                        name=fName+" "+mName+" "+lName;
                        ShowName.setText("Name: "+name);

                        fname.setText("");
                        mname.setText("");
                        lname.setText("");

                        dialog.cancel();


                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShowName.setText("Name: ");
                        dialog.cancel();
                    }
                });




            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String prnNo=prn.getText().toString();
                String ageNo=age.getText().toString();

                String info = "Name: "+fName+" "+mName+" "+lName+"\n"+"PRN: "+prnNo+"\n"+"Age: "+ageNo+"\n"+"Course: "+courseName;

                prn.setText("");
                age.setText("");
                fName="";
                mName="";
                lName="";
                courseName="";
                ShowName.setText("Name: ");
                SelectCourse.setSelection(0);

                adapterListStudents.add(info);
                //listofCourses[listofCourses.length - 1]
              //  adapterListStudents.notifyDataSetChanged();

               // Toast.makeText(MainActivity.this,info,Toast.LENGTH_SHORT).show();
//                liststudents.add(info);

            }
        });

    }
}
