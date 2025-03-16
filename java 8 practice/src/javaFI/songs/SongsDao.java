package javaFI.songs;

import java.util.ArrayList;
import java.util.List;

public class SongsDao {

    public static List<SongsDto> SongsDatabase(){
        List<SongsDto> songsDto = new ArrayList<>();
        List<String> singers = new ArrayList<>();
        singers.add("sonu");
        singers.add("shreya");

        songsDto.add(new SongsDto("arasu", 3,singers, 10));
        songsDto.add(new SongsDto("abhi", 3,singers, 10));
        songsDto.add(new SongsDto("jackie", 3,singers, 10));
        songsDto.add(new SongsDto("aakash", 3,singers, 10));
        songsDto.add(new SongsDto("vamshi", 3,singers, 10));
        return songsDto;

    }
}
