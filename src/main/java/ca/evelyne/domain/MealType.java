package ca.evelyne.domain;

/**
 * Created by Evelyne on 26/08/15.
 */
public enum MealType {
    BREAKFAST("breakfast"), LUNCH("lunch"), DINNER("dinner"), DESERT("desert"), SOUP("soup"), APETIZER("apetizer");

    private String label;

    MealType(String label) {
        this.label = label;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
