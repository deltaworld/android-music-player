package uk.tareq.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tareq Fadel on 23/08/15.
 * Adapter for populating the ListView from the ArrayList of Songs
 */
public class SongAdapter extends BaseAdapter {

    private ArrayList<Song> mSongs;
    private LayoutInflater mSongInf;

    public SongAdapter(Context c, ArrayList<Song> theSongs) {
        this.mSongs = theSongs;
        mSongInf = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return mSongs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // map to song layout
        LinearLayout songLay = (LinearLayout) mSongInf.inflate(R.layout.song, parent, false);

        SongHolder songHolder = new SongHolder(songLay);

        // get song using position;
        Song currSong = mSongs.get(position);

        // Get the TextViews from the ViewHolder Pattern
        TextView songView = songHolder.getSongTitle();
        TextView artistView = songHolder.getSongArtist();

        // Get the title and artist from current song and set the TextViews
        songView.setText(currSong.getTitle());
        artistView.setText(currSong.getArtist());

        // set position as tag
        songLay.setTag(position);
        return songLay;
    }
}
