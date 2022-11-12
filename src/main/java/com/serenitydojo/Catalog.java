package com.serenitydojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Catalog {

    Map<Fruit,Double> pricesPerKilo = new HashMap<>();
    public PriceSetter setPriceOf(Fruit fruit) {
        return new PriceSetter(this, fruit);
    }

    public List<String> getAvailableFruit() {
        return pricesPerKilo.keySet()
                .stream()
                .map(Enum::name)
                .sorted()
                .collect(toList());
    }

    public Double getPriceOf(Fruit fruit) {
        if (pricesPerKilo.containsKey(fruit)) {
            return pricesPerKilo.get(fruit);
        }
        throw new FruitUnavailableException(fruit.name() + ": Sorry! The Fruit is currently Unavailable" );

    }

}
