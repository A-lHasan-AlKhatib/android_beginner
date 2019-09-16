package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    static MediaPlayer mp;

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this,R.raw.bbno);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(getBaseContext(),"Finished",Toast.LENGTH_SHORT);
            }
        });
        mp.release();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (! mp.isPlaying())
            mp.start();
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getBaseContext(),"Destroyed",Toast.LENGTH_SHORT).show();
        mp.release();
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static void pause(){
        mp.pause();
    }

}
