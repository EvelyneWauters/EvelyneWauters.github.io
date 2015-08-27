package ca.evelyne.domain;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by Evelyne on 26/08/15.
 */

@Entity
public class Ingredient {
    //class variables
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    @OneToOne
    public Quantity quantity;
    @Enumerated (EnumType.STRING)
    public Foodtype foodtype;

    //constructor
    public Ingredient() {
    }


    //getters & setters
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

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Foodtype getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(Foodtype foodtype) {
        this.foodtype = foodtype;
    }
}
