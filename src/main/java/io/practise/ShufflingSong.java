package io.practise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShufflingSong {

    public static void main(String[] args) {
        Song song1 = new Song("A");
        Song song2 = new Song("B");
        Song song3 = new Song("C");
        Song song4 = new Song("D");
        Song song5 = new Song("E");

        List<Song> list = Arrays.asList(song1, song2, song3, song4, song5);
        Collections.shuffle(list);

        System.out.println(list);
    }
}

class Song {
    String name;

    public Song(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                '}';
    }
}
