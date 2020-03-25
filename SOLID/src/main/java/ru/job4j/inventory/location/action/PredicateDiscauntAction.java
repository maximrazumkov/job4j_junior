package ru.job4j.inventory.location.action;

import ru.job4j.inventory.food.Food;

import java.util.function.Predicate;

public class PredicateDiscauntAction implements Predicate<Food> {

    @Override
    public boolean test(Food food) {
        double val = food.getValidityPeriod();
        return (val > 0.75) && (val < 1.0);
    }

}
