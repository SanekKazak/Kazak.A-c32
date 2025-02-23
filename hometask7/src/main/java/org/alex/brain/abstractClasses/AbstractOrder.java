package org.alex.brain.abstractClasses;

public class AbstractOrder {

    private String type;
    private int cost;
    private String country;

    public AbstractOrder(String type, int cost, String country) {
        this.type = type;
        this.cost = cost;
        this.country = country;
    }

    public String getType() {
        return this.type;
    }

    public int getCost() {
        return this.cost;
    }

    public String getCountry() {
        return this.country;
    }

}
