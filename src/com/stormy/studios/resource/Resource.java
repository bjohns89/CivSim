package com.stormy.studios.resource;

public class Resource {

    public static final Resource WOOD = new Resource("wood", 1);
    public static final Resource METAL = new Resource("metal", 5);
    public static final Resource STONE = new Resource("stone", 1);
    public static final Resource FOOD = new Resource("food", 3);

    private String name;
    private double cost;

    public Resource(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
