package ru.job4j.inventory.location.predicate;

import ru.job4j.inventory.food.Food;

import java.util.function.Predicate;

public class WarehousePredicate implements Predicate<Food> {
    @Override
    public boolean test(Food food) {
        return food.getValidityPeriod() < 0.25;
    }
}
