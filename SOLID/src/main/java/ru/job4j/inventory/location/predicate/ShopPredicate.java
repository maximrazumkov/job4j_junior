package ru.job4j.inventory.location.predicate;

import ru.job4j.inventory.food.Food;

import java.util.function.Predicate;

public class ShopPredicate implements Predicate<Food> {
    @Override
    public boolean test(Food food) {
        double val = food.getValidityPeriod();
        return (val > 0.25) && (val < 1.0);
    }
}
