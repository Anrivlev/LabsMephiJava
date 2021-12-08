package ru.anrivlev.lab6;

import java.io.Serializable;

public class Item implements Serializable {

    private static final long serialVersionUID = 1;

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
}
