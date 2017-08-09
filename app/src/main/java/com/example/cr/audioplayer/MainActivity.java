package com.example.cr.audioplayer;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.os.Build.VERSION.SDK_INT;

public class MainActivity extends AppCompatActivity
{
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS =1;
    public static final String Broadcast_PLAY_NEW_AUDIO = "com.example.cr.audioplayer.PlayNewAudio";

    private MediaPlayerService playerService;
    boolean serviceBound = false;
    ArrayList<Audio> audioList;

    ImageView imageView;

    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView = (ImageView) findViewById(R.id.collapseImageView);

        loadCollapsingImage(imageIndex);

        if(checkAndRequestPermissions())
        {
            loadAudioList();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //playAudio("https://upload.wikimedia.org/wikipedia/commons/6/6c/Grieg_Lyric_Pieces_Kobold.ogg");
                //play the first audio in the ArrayList
//                playAudio(2);
                if(imageIndex == 4)
                {
                    imageIndex =0;
                    loadCollapsingImage(imageIndex);
                }
                else
                {
                    loadCollapsingImage(++imageIndex);
                }

            }
        });
    }

    private void loadAudioList()
    {
        loadAudio();
        initRecyclerView();
    }

    private void initRecyclerView()
    {

    }

    private void loadAudio()
    {

    }

    private boolean checkAndRequestPermissions()
    {
        if(SDK_INT >= Build.VERSION_CODES.M)
        {
            int permissionReadState = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
            int permissionStorage =ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
            List<String> listPermission = new ArrayList<>();

            if(permissionReadState != PackageManager.PERMISSION_GRANTED)
            {
                listPermission.add(Manifest.permission.READ_PHONE_STATE);
            }

            if(permissionStorage != PackageManager.PERMISSION_GRANTED)
            {
                listPermission.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }

            if(!listPermission.isEmpty())
            {
                ActivityCompat.requestPermissions(this, listPermission.toArray(new String[listPermission.size()]),
                        REQUEST_ID_MULTIPLE_PERMISSIONS);
                return false;
            }
            else
                return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        String TAG = "Log Permission";
        Log.d(TAG, "Permission callback called.............");

        switch (requestCode)
        {
            case REQUEST_ID_MULTIPLE_PERMISSIONS:
            {
                Map<String, Integer> perms = new HashMap<>();

                perms.put(Manifest.permission.READ_PHONE_STATE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.READ_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void loadCollapsingImage(int imageIndex)
    {

    }
}
