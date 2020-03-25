package ru.job4j.inventory.location;

import ru.job4j.inventory.food.Food;

import java.util.List;
import java.util.function.Predicate;

public class Trash extends StorageBase<Food> {
    private final Predicate<Food> predic;

    public Trash(List<Food> items, Predicate<Food> predic) {
        super(items);
        this.predic = predic;
    }

    @Override
    public boolean check(Food food) {
        return predic.test(food);
    }
}
