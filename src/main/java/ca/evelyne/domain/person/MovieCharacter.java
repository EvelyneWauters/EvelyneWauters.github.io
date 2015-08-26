package ca.evelyne.domain.person;

import javax.persistence.*;


@Entity
public class MovieCharacter {
    /**
     * Class fields
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    @ManyToOne
    private Actor actor;

    /**
     * Constructors
     */
    public MovieCharacter() {
    }



    /**
     * setters & getters
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Integer getId() {
        return id;
    }

}
