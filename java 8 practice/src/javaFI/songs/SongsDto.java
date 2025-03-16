package javaFI.songs;

import java.util.List;


public class SongsDto {
    public SongsDto(String movie_Name, int song_duration, List<String> singers, int song_lang) {
        this.movie_Name = movie_Name;
        this.song_duration = song_duration;
        this.singers = singers;
        this.song_lang = song_lang;
    }

    private String movie_Name;
    private int song_duration;
    private List<String> singers;
    private int song_lang;

    public String getMovie_Name() {
        return movie_Name;
    }

    public void setMovie_Name(String movie_Name) {
        this.movie_Name = movie_Name;
    }

    public int getSong_duration() {
        return song_duration;
    }

    public void setSong_duration(int song_duration) {
        this.song_duration = song_duration;
    }

    public List<String> getSingers() {
        return singers;
    }

    public void setSingers(List<String> singers) {
        this.singers = singers;
    }

    public int getSong_lang() {
        return song_lang;
    }

    public void setSong_lang(int song_lang) {
        this.song_lang = song_lang;
    }

    @Override
    public String toString() {
        return "SongsDto{" +
                "movie_Name='" + movie_Name + '\'' +
                ", song_duration=" + song_duration +
                ", singers=" + singers +
                ", song_lang=" + song_lang +
                '}';
    }
}
