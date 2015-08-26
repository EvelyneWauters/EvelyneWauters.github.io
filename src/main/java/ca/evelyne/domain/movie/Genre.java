package ca.evelyne.domain.movie;

/**
 * Created by Evelyne on 10/07/15.
 */
public enum Genre {
    COMEDY("comedy"), DRAMA("drama"), THRILLER("thriller"), HORROR("horror"), SCIENCEFICTION("science-fiction"), ROMANCE("romance"), DOCUMENTARY("documentary");

    private String label;

    private Genre(String label)   {
        this.label=label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



}
