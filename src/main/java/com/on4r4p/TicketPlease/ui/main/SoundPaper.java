package com.on4r4p.TicketPlease.ui.main;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.on4r4p.TicketPlease.R;

public class SoundPaper extends Service {
    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.paperthem); //select music file
        player.setLooping(true); //set looping
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return Service.START_NOT_STICKY;
    }
    public void stfu() {
        player.stop();
        player.release();
        stopSelf();
    }
    public void onDestroy() {
        player.stop();
        player.release();
        stopSelf();
        super.onDestroy();
    }

}
