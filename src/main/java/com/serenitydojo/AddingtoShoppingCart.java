package com.serenitydojo;

public class AddingtoShoppingCart {
    private final ShoppingCart shoppingCart;
    private final Double amount;


    public AddingtoShoppingCart(ShoppingCart shoppingCart, Double amount) {
        this.shoppingCart = shoppingCart;
        this.amount = amount;
    }

    public ShoppingCart kilosOf(Fruit fruit) {
        double initialPrice = shoppingCart.catalog.getPriceOf(fruit);
        double discountedPrice = (amount >= 5) ? initialPrice - (initialPrice * 0.1) : initialPrice;
        ItemsToTheShoppingCart item = new ItemsToTheShoppingCart(fruit, amount, discountedPrice * amount);
        shoppingCart.items.add(item);
        return shoppingCart;

    }

}
