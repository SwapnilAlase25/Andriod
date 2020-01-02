package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    ListView lv1;

    String [] name={"Swapnil","Ankit","Aksahay.K","Akashay.R","Apoorav","Anurag","Abhishek","Bhushan","Shweta","Pooja","123","123.456","Cdac123"};

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.btToShowList);
        lv1 = findViewById(R.id.listNames);

        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                name
        );


        lv1.setAdapter(adapter);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv1.setVisibility(View.VISIBLE);
            }

        });


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                String item = (String)parent.getItemAtPosition(position);
                //Toast.makeText(MainActivity.this,"you clicked on "+item,Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(
                            MainActivity.this,DetailActivity.class
                    );

                    intent.putExtra("KEY_VALUE",item);

                    startActivity(intent);
            }
        });
    }
}
