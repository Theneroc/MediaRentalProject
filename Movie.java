public class Movie extends Media{
    private String rating;
    private String title;
    private int copiesAvailable;

    Movie(){}

    @Override
    public boolean equals(Media m) {

            return false;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String getTitle() {
        return title;
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

    public Movie(String title, int copiesAvailable, String rating) {
        this.title = title;
        this.copiesAvailable = copiesAvailable;
        this.rating=rating;

    }

    public String getRating() {
        return rating;
    }

    @Override
    public int compareTo(Media o) {
        return title.compareToIgnoreCase(o.getTitle());
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' + ", copiesAvailableAnInt='"+copiesAvailable + '\'' + ", rating='" + rating + '\'';

    }
}
