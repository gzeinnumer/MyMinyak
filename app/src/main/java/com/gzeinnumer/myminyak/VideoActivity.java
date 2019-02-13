package com.gzeinnumer.myminyak;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {


    VideoView videoView;
    Button play,quis;
    MediaController mediaController;

    String videoUrl = "android.resource://com.gzeinnumer.myminyak/"+ String.valueOf(R.raw.view_view_exer);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        play = findViewById(R.id.play);
        quis = findViewById(R.id.quis);
        videoView = findViewById(R.id.videoView);

        mediaController = new MediaController(this);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(videoUrl);
                videoView.setVideoURI(uri);
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);
                videoView.start();
            }
        });

        quis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Quises.class);
                startActivity(intent);
            }
        });

    }
}
