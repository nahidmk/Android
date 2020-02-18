package com.example.alartdialog_vedioview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 private Button b1;
 private VideoView videoView;
 private ImageView imageView;
 private ZoomControls zoomControls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Alert Dialog
        b1 = findViewById(R.id.button);


        //video view
        videoView = findViewById(R.id.vedio);


        //zoom controls
        zoomControls = findViewById(R.id.zoom);
        imageView = findViewById(R.id.image);

        //Alert Dialog
        b1.setOnClickListener(this);

        //zoom control
        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = imageView.getScaleX();
                float y = imageView.getScaleY();

                if(x<4)
                {
                    imageView.setScaleX(x+1);
                    imageView.setScaleY(y+1);
                }
            }
        });
        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = imageView.getScaleX();
                float y = imageView.getScaleY();

                if(x>1)
                {
                    imageView.setScaleX(x-1);
                    imageView.setScaleY(y-1);
                }
            }
        });


        // video view
        Uri uri =  Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.android);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("Do you want to exit ?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"you have clicked no",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
