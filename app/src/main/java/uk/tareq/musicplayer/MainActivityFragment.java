package uk.tareq.musicplayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private final String TAG = getClass().getSimpleName();
    private ArrayList<Song> mSongList = new ArrayList<>();

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSongList();

        // Sort in alphabetical order
        Collections.sort(mSongList, new Comparator<Song>() {
            @Override
            public int compare(Song a, Song b) {
                return a.getTitle().compareTo(b.getTitle());
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView songView = (ListView) rootView.findViewById(R.id.song_list);
        SongAdapter songAdt = new SongAdapter(getActivity(), mSongList);
        songView.setAdapter(songAdt);


        return rootView;
    }

    public void getSongList() {
        // retrieve song info
        ContentResolver musicResolver = getActivity().getContentResolver();
        Uri musicUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] STAR = {"*"};
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        Cursor musicCursor = musicResolver.query(musicUri, STAR, selection, null, null);

        if (musicCursor != null && musicCursor.moveToFirst()) {

            // get columns
            int idColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media._ID); // 0
            int titleColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE); // 8
            int artistColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST); // 25
            Log.i(TAG, "getSongList");

//            // add songs to list
            do {
                long thisId = musicCursor.getLong(idColumn);
                String thisTitle = musicCursor.getString(titleColumn);
                String thisArtist = musicCursor.getString(artistColumn);
                mSongList.add(new Song(thisId, thisTitle, thisArtist));
            }
            while (musicCursor.moveToNext());
        }
    }
}
