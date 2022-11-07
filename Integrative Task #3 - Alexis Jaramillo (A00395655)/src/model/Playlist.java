package model;

import java.util.Arrays;

public class Playlist {

    private String name;
    private Song[] songs;
    private Podcast[] podcasts;
    private int numericalCode;

    public Playlist(String name, Song[] songs, Podcast[] podcasts, int numericalCode) {
        this.name = name;
        this.songs = songs;
        this.podcasts = podcasts;
        this.numericalCode = numericalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public Podcast[] getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(Podcast[] podcasts) {
        this.podcasts = podcasts;
    }

    public int getNumericalCode() {
        return numericalCode;
    }

    public void setNumericalCode(int numericalCode) {
        this.numericalCode = numericalCode;
    }

    @Override
    public String toString() {
        return "Playlist [name=" + name + ", songs=" + Arrays.toString(songs) + ", podcasts="
                + Arrays.toString(podcasts) + ", numericalCode=" + numericalCode + "]";
    }

}
