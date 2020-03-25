package ru.job4j.inventory.location.predicate;

import ru.job4j.inventory.food.Food;

import java.util.function.Predicate;

public class TrashPredicate implements Predicate<Food> {
    @Override
    public boolean test(Food food) {
        return food.getValidityPeriod() > 1.0;
    }
}
