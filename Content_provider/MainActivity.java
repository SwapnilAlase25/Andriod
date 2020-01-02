package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    TextView filecount,audio;
    ListView lstvideo,audolist;
    ArrayAdapter<String> adapter,adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filecount=findViewById(R.id.textToFile);
        lstvideo=findViewById(R.id.ListToFile);
        audio=findViewById(R.id.textToFile1);
        audolist=findViewById(R.id.Audio1);

        ActivityCompat.requestPermissions(
                MainActivity.this,new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE
                },101
        );



        adapter=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1
        );
        lstvideo.setAdapter(adapter);

        ContentResolver resolver = getContentResolver();
        Uri videouri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;


         Cursor cursor =resolver.query(
                 videouri,null,null,null,null
         );

         for(int i=0;i<cursor.getColumnCount();i++){
             String colName = cursor.getColumnName(i);
                adapter.add(colName);
         }

         cursor.close();
         adapter.clear();

         String [] args ={"_id","_data","_display_name"};
         Cursor cursor1 = resolver.query(
                 videouri,args,
                 null,null,"_display_name"
         );

     while(cursor1.moveToNext()){
         String id=cursor1.getString(0);
         String data=cursor1.getString(1);
         String name=cursor1.getString(2);
         String info=id+"\n"+data+"\n"+name;
         adapter.add(data);

     }
         int count=adapter.getCount();
         filecount.setText("Video count: " + count);



        lstvideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String path = (String) parent.getItemAtPosition(position);

                Intent intent = new Intent(
                        MainActivity.this, VideoActivity.class
                );
                intent.putExtra("KEY_PATH",path);
                startActivity(intent);
            }
        });


     /////////////// audio //////////////////////


        adapter1 =new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1
        );
        audolist.setAdapter(adapter1);

        ContentResolver resolver1 = getContentResolver();

        Uri songsuri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String [] args1 ={"_id","_data","_display_name"};
        Cursor cursor2 =resolver.query(
                songsuri,args1,null,null,null
        );

        while(cursor2.moveToNext()){
            String id=cursor2.getString(0);
            String data=cursor2.getString(1);
            String name=cursor2.getString(2);
            String info=id+"\n"+data+"\n"+name;
            adapter1.add(info);

        }


         int count1=adapter1.getCount();
        audio.setText("Audio count: " + count1);

    }
}
