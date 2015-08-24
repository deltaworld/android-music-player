package uk.tareq.musicplayer;

/**
 * Created by Tareq Fadel on 23/08/15.
 * Song Model for tracks
 */
public class Song {
    private long id;
    private String title;
    private String artist;

    /**
     * Constructor for each song
     *
     * @param SongId     stores the unique ID of each song
     * @param songTitle  is the title of the song
     * @param songArtist is the name of the artist.
     */
    public Song(long SongId, String songTitle, String songArtist) {
        this.id = SongId;
        this.title = songTitle;
        this.artist = songArtist;
    }

    /**
     * Getter for the song ID
     *
     * @return the song ID
     */
    public long getId() {
        return id;
    }

    /**
     * Getter for the title of the song
     *
     * @return the name of the requested song.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for the artist of the song
     *
     * @return the artists name for the selected song
     */
    public String getArtist() {
        return artist;
    }
}
