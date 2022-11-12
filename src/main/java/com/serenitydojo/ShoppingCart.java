package com.serenitydojo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    final Catalog catalog;
    final List<ItemsToTheShoppingCart> items;

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        this.items = new ArrayList<>();
    }

    public AddingtoShoppingCart add(Double amount) {
        return new AddingtoShoppingCart(this, amount);
    }

    public List<ItemsToTheShoppingCart> getItems() {
        return new ArrayList<>(items);
    }

    public Double getTotalPrice() {
        return items.stream().mapToDouble(ItemsToTheShoppingCart::getTotalCost).sum();
    }

}