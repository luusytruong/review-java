package week7.movie;

public class Movie {
    private int id;
    private String title, director, year, type;

    public Movie(int id, String title, String director, String year, String type) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Model [id=" + id + ", title=" + title + ", director=" + director + ", year=" + year + ", type=" + type
                + "]";
    }
}
