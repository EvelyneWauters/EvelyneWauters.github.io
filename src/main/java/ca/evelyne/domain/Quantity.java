package ca.evelyne.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Evelyne on 26/08/15.
 */
@Entity
public class Quantity {
    //class variables
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer id;
    public int quantityMetric;
    public String baseUnit;


    //constructor
    public Quantity() {
    }

    public Quantity(int quantityMetric, String baseUnit) {
        this.quantityMetric = quantityMetric;
        this.baseUnit = baseUnit;
    }

    //getters & setters
    public int getQuantityMetric() {
        return quantityMetric;
    }

    public void setQuantityMetric(int quantityMetric) {
        this.quantityMetric = quantityMetric;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
