package com.example.mediarentalprojectphase2;

public class Game extends Media{
    private double weight;
    private String title;
    private int copiesAvailable;
    private String code;

    Game(){}

    public Game(String code, String title, int copiesAvailable, double weight) {
        this.title = title;
        this.copiesAvailable = copiesAvailable;
        this.weight = weight;

    }
    @Override
    public boolean equals(Media m) {
        return false;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getCode() {
        return null;
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



    @Override
    public int compareTo(Media o) {
        return title.compareToIgnoreCase(o.getTitle());
    }
    @Override
    public String toString () {

        return
                "title='" + title + '\'' + ", copiesAvailableAnInt='"+copiesAvailable  + '\'' + ", weight='" + weight + '\'';
    }

}
