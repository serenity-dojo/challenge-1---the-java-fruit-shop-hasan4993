package com.serenitydojo;

public class PriceSetter extends Catalog {

    private final Catalog catalog;
    private final Fruit fruit;

    public PriceSetter(Catalog catalog, Fruit fruit) {

        this.catalog = catalog;
        this.fruit = fruit;
    }

    public PriceSetter setPriceof(Fruit fruit) {
        return new PriceSetter(this, fruit);
    }

    public Catalog to(Double price) {
        catalog.pricesPerKilo.put(fruit, price);
        return catalog;
    }
}
