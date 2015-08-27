package ca.evelyne.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Evelyne on 26/08/15.
 */

@Entity
public class Recipe {
    //class variables
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int durationInMinutes;
    @Enumerated (EnumType.STRING)
    private MealType mealType;
    @OneToMany
    private List<Ingredient> ingredientList;
    private String description;
    @Lob
    private String howTo;


    //constructor
    public Recipe() {
    }

    //getters & setters
    public String getHowTo() {
        return howTo;
    }

    public void setHowTo(String howTo) {
        this.howTo = howTo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
