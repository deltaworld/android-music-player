package uk.tareq.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Tareq Fadel on 23/08/15.
 * A service based class for running the music task asynchronously after the app has lost focus.
 */
public class MusicService extends Service implements
        MediaPlayer.OnPreparedListener, OnErrorListener, OnCompletionListener {

    //media player

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }
}
