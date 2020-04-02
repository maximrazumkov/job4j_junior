package ru.job4j.inventory.executer;

import ru.job4j.design.Store;
import ru.job4j.inventory.food.Food;
import ru.job4j.inventory.location.Storeg;

import java.util.ArrayList;
import java.util.List;

public class SimpleControllQuality implements ControllQuality<Food> {
    private final List<Storeg<Food>> storegs;

    public SimpleControllQuality(List<Storeg<Food>> storegs) {
        this.storegs = storegs;
    }

    @Override
    public void distribute(List<Food> foods) {
        for (Food food : foods) {
            for (Storeg store : storegs) {
                if (store.check(food)) {
                    store.add(food);
                    break;
                }
            }
        }
    }

    @Override
    public void reset() {
        List<Food> allFood = new ArrayList<>();
        for (Storeg<Food> storeg : storegs) {
            allFood.addAll(storeg.findAll());
        }
        distribute(allFood);
    }
}
