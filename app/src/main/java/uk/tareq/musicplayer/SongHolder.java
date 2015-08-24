package uk.tareq.musicplayer;

import android.view.View;
import android.widget.TextView;

public class SongHolder {
    private TextView songTitle;
    private TextView songArtist;

    public SongHolder(View view) {
        songTitle = (TextView) view.findViewById(R.id.song_title);
        songArtist = (TextView) view.findViewById(R.id.song_artist);
    }

    public TextView getSongArtist() {
        return songArtist;
    }

    public TextView getSongTitle() {
        return songTitle;
    }
}
