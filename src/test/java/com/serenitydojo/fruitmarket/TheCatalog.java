package com.serenitydojo.fruitmarket;

import com.serenitydojo.Catalog;
import com.serenitydojo.FruitUnavailableException;
import org.junit.Before;
import org.junit.Test;

import static com.serenitydojo.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TheCatalog {
    Catalog catalog;

    @Before
    public void creatingANewCatalog() {
        catalog = new Catalog();
        catalog.setPriceOf(Apples).to(4.00)
                .setPriceOf(Oranges).to(5.50)
                .setPriceOf(Bananas).to(6.00)
                .setPriceOf(Pears).to(4.50);

    }

    // You can update the catalog with the current market price of a fruit
    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
// TODO: Uncomment this code and make it work

        catalog = new Catalog();
        // Setting Up New Prices of Apples
        catalog.setPriceOf(Apples).to(3.50);
        assertThat(catalog.getPriceOf(Apples)).isEqualTo(3.50);
    }

    //The Catalog should list the names of the currently available fruit in alphabetical order
    @Test
    public void shouldBeAbleToSortFruitsInAplphabeticalOrder() {
        assertThat(catalog.getAvailableFruit()).containsExactly("Apples", "Bananas", "Oranges", "Pears");
    }

    // The Catalog should report the price of a given type of fruit
    @Test
    public void shouldBeAbleToEnsureCorrectPricesOfFruit() {
        assertThat(catalog.getPriceOf(Apples)).isEqualTo(4.00);
        assertThat(catalog.getPriceOf(Bananas)).isEqualTo(6.00);

    }
    // The Catalog should throw a FruitUnavailableException if the fruit is not currently available
    @Test(expected = FruitUnavailableException.class)
    public void shouldThrowExceptionWhenFruitIsUnavailable(){
        catalog.getPriceOf(Blueberries);
    }
}