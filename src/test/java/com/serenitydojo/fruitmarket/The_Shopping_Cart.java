package com.serenitydojo.fruitmarket;

import com.serenitydojo.Catalog;
import com.serenitydojo.ItemsToTheShoppingCart;
import com.serenitydojo.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import static com.serenitydojo.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class The_Shopping_Cart {
    Catalog catalog;
    ShoppingCart cart;

    @Before
    public void setupCatalog() {
        catalog = new Catalog();
        catalog.setPriceOf(Apples).to(4.00)
                .setPriceOf(Oranges).to(5.50)
                .setPriceOf(Bananas).to(4.50)
                .setPriceOf(Pears).to(4.50);

        cart = new ShoppingCart(catalog);
    }

    @Test
    public void shouldBeginWithEmptyCart() {
        assertThat(cart.getItems()).isEmpty();
    }


    @Test
    public void shouldAddSingleItemsInTheCart() {
        cart.add(2.0).kilosOf(Apples);
        assertThat(cart.getItems()).hasSize(1);
    }

    @Test
    public void shouldCheckMoreThenSingleItemsInTheCart() {
        cart.add(2.0).kilosOf(Apples);
        assertThat(cart.getItems()).hasSizeGreaterThanOrEqualTo(1);
    }


    @Test
    public void shouldCalculateThePriceOfItemsAddedToTheCart() {
 /*    Apples 4.00$ * 4 = 16
       Oranges 5.50$ = 23.65
       Pears 4.50$ = 22.5
       Bananas 4.50$
       */
        cart.add(1.0).kilosOf(Apples)
                .add(3.0).kilosOf(Oranges)
                .add(2.0).kilosOf(Pears);
        //System.out.println(cart.getTotalPrice());
        assertThat(cart.getTotalPrice()).isEqualTo(29.5);
    }

    @Test
    public void shouldCheckTheItemsPresentInTheCart() {
        cart.add(3.5).kilosOf(Oranges);

        ItemsToTheShoppingCart oranges = cart.getItems().get(0);

        assertThat(oranges.getFruit()).isEqualTo(Oranges);
        assertThat(oranges.getQuantity()).isEqualTo(3.5);
        assertThat(oranges.getTotalCost()).isEqualTo(19.25);
    }

    @Test
    public void shouldGiveDiscountOnGettingFiveOrMoreItems() {
        cart.add(7.0).kilosOf(Oranges);
        // Oranges Discount => 7 * 5.50 = 38.5 * 10% == 3.85 => 38.5 - 3.85 == 34.65
        assertThat(cart.getTotalPrice()).isEqualTo(34.65);
    }

    @Test
    public void shouldGiveDiscountOnSingleItemsThatAreOfFiveOrGreater() {
        cart.add(10.0).kilosOf(Bananas);
        cart.add(2.00).kilosOf(Pears);

        assertThat(cart.getTotalPrice()).isEqualTo(49.5);
    }
}
