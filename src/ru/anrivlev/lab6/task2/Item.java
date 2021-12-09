package ru.anrivlev.lab6.task2;

import java.io.Serializable;
import java.util.Random;

public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int id;
    private String description;
    private double cost;

    public Item(int id, String description, double cost) {
        this.id = id;
        this.description = description;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void updateCost() {
        double p = (Math.random() - 0.5) / 5;
        this.cost = (1 + p) * this.cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                "description='" + description +"'" +
                "cost=" + cost + "}";
    }
}
