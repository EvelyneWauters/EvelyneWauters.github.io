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
    public Integer id;
    public String name;
    public int durationInMinutes;
    @Enumerated (EnumType.STRING)
    public MealType mealType;
    @OneToMany
    public List<Ingredient> ingredientList;
    public String description;
    @Lob
    public String howTo;


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

    public int getDuration() {
        return durationInMinutes;
    }

    public void setDuration(int duration) {
        this.durationInMinutes = duration;
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
