package ca.evelyne.domain.person;

/**
 * Created by Evelyne on 10/07/15.
 */
public enum Gender {
    FEMALE("female"), MALE("male");

    private String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
