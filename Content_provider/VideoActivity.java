package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;


public class VideoActivity extends AppCompatActivity {

    VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video=findViewById(R.id.videoView);
        Intent recIntent = getIntent();
        String path = recIntent.getStringExtra("KEY_PATH");
        video.setVideoPath(path);

        MediaController mediaController = new MediaController(VideoActivity.this);
        video.setMediaController(mediaController);

        video.start();

    }
}
