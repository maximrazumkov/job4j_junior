package ru.job4j.inventory.location;

import ru.job4j.inventory.food.Food;
import ru.job4j.inventory.location.action.Action;

import java.util.List;
import java.util.function.Predicate;

public class Shop extends StorageBase<Food> {
    private Predicate<Food> predic;
    private final List<Action> actions;

    public Shop(List<Food> items, Predicate<Food> predic, List<Action> actions) {
        super(items);
        this.predic = predic;
        this.actions = actions;
    }

    @Override
    public boolean check(Food food) {
        boolean result = predic.test(food);
        if (result) {
            for (Action action : actions) {
                action.execute(food);
            }
        }
        return result;
    }
}
