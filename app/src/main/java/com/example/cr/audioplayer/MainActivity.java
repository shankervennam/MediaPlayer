package com.example.cr.audioplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS =1;
    public static final String Broadcast_PLAY_NEW_AUDIO = "com.example.cr.audioplayer.PlayNewAudio";



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
