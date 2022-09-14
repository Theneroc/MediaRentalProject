package com.example.mediarentalprojectphase2;

public abstract class Media implements Comparable<Media> {
    private String title;
    private int copiesAvailable;
    private String code;
    Media(){}
    public Media(String code,String title, int copiesAvailable) {
        this.title=title;
        this.copiesAvailable = copiesAvailable;
        this.code = code;
    }

    public abstract void setTitle(String title);

    public abstract String getTitle();

    public abstract String getCode();

    public abstract void setCopiesAvailable(int copiesAvailable);

    public abstract int getCopiesAvailable();

    public abstract boolean equals(Media m);

    public abstract int compareTo(Media o);




}
