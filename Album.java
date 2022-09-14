package com.example.mediarentalprojectphase2;

public class Album extends Media{
    private String title;
    private int copiesAvailable;
    private String artist;
    private String songs= new String();
    private String code= new String();


    Album(){}

    @Override
    public boolean equals(Media m) {
        return false;
    }

    public Album(String code, String title, int copiesAvailable, String artist, String songs) {
        this.title = title;
        this.artist = artist;
        this.songs = songs;
        this.copiesAvailable = copiesAvailable;
        this.code = code;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    @Override
    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    @Override
    public int compareTo(Media o) {

        return title.compareToIgnoreCase(o.getTitle());
    }

    @Override
    public String toString() {
        return  "title='" + title + '\'' + ", copiesAvailable=" + copiesAvailable + ", artist='" + artist + '\'' + ", songs='" + songs + '\'';
    }
}
