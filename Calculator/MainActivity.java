package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input1,input2;
    Button add,subs,multi,divi,reset;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1=findViewById(R.id.ip1);
        input2=findViewById(R.id.ip2);
        add=findViewById(R.id.sum);
        subs=findViewById(R.id.sub);
        multi=findViewById(R.id.mul);
        divi=findViewById(R.id.div);
        output=findViewById(R.id.result);
        reset=findViewById(R.id.reset);
        buttonListener();

        }

    private void buttonListener(){

    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String a = input1.getText().toString();
            String b = input2.getText().toString();
            int ip1=Integer.parseInt(a);
            int ip2=Integer.parseInt(b);
            int c = ip1 + ip2;

            output.setText("Result: "+c);
             }
    });

        subs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = input1.getText().toString();
                String b = input2.getText().toString();
                int ip1=Integer.parseInt(a);
                int ip2=Integer.parseInt(b);
                int c = ip1 - ip2;

                output.setText("Result: "+c);
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = input1.getText().toString();
                String b = input2.getText().toString();
                int ip1=Integer.parseInt(a);
                int ip2=Integer.parseInt(b);
                int c = ip1 * ip2;

                output.setText("Result: "+c);
            }
        });

        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = input1.getText().toString();
                String b = input2.getText().toString();
                float ip1=Integer.parseInt(a);
                int ip2=Integer.parseInt(b);
                float c = ip1/ ip2;

                output.setText("Result: "+ c);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                input1.setText("");
                input2.setText("");
                output.setText("Result: ");
            }
        });








    }
}

