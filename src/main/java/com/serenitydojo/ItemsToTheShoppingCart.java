package com.serenitydojo;

public class ItemsToTheShoppingCart {


    public Fruit fruit;
    private Double quantity;
    private Double totalCost;

    public ItemsToTheShoppingCart(Fruit fruit, Double quantity, Double totalCost) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.totalCost = totalCost;

    }

    public Fruit getFruit() {
        return fruit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getTotalCost() {
        return totalCost;
    }
}
