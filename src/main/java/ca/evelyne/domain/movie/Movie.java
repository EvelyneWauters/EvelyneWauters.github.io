package ca.evelyne.domain.movie;


import ca.evelyne.domain.person.MovieCharacter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Movie {
    /**
     * Class fields
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String title;

    @NotNull
    private int length;

    @Column(length = 1000)
    private String summary;

    @Enumerated (EnumType.STRING)
    private Genre genre;

    @NotBlank
    private String yearReleased;

    private String coverImageUrl;

    private String movieTrailerUrl;

    private String director;

    @Min(1)
    @Max(10)
    private double rating;

    @Transient
    private int ratingCount;

    @OneToMany
    @JoinTable(name="movie_cast", joinColumns=@JoinColumn(name="movie_id"), inverseJoinColumns=@JoinColumn(name="character_id"))
    private Set<MovieCharacter> cast= new TreeSet<>();

//  misschien beter vanuit de andere richting mappen?
//    @OneToMany
//    private Set<Comment> commentSet= new TreeSet<>();


    //TODO: convert coverImage from Url to real image


    /**
     * Constructors
     */
    public Movie() {
    }

    /**
     * Other methods & overrides
     */
    public double calculateRating(int newRating)    {
        return (this.rating + newRating)/ratingCount;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    /**
     * Getters & setters
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getMovieTrailerUrl() {
        return movieTrailerUrl;
    }

    public void setMovieTrailerUrl(String movieTrailerUrl) {
        this.movieTrailerUrl = movieTrailerUrl;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Set<MovieCharacter> getCast() {
        return cast;
    }

    public void setCast(Set<MovieCharacter> cast) {
        this.cast = cast;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }
}
