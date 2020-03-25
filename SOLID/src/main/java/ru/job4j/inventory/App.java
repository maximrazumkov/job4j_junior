package ru.job4j.inventory;

import ru.job4j.inventory.executer.ControllQuality;
import ru.job4j.inventory.executer.SimpleControllQuality;
import ru.job4j.inventory.food.Food;
import ru.job4j.inventory.food.Onion;
import ru.job4j.inventory.food.Potato;
import ru.job4j.inventory.food.Pumpkin;
import ru.job4j.inventory.location.Shop;
import ru.job4j.inventory.location.Storeg;
import ru.job4j.inventory.location.Trash;
import ru.job4j.inventory.location.Warehouse;
import ru.job4j.inventory.location.action.Action;
import ru.job4j.inventory.location.action.DiscauntAction;
import ru.job4j.inventory.location.action.PredicateDiscauntAction;
import ru.job4j.inventory.location.predicate.ShopPredicate;
import ru.job4j.inventory.location.predicate.TrashPredicate;
import ru.job4j.inventory.location.predicate.WarehousePredicate;

import java.util.*;

public class App {

    private final ControllQuality<Food> controllQuality;

    public App(ControllQuality controllQuality) {
        this.controllQuality = controllQuality;
    }

    public void run() {
        List<Food> foods = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +1);
        Date expaire = cal.getTime();
        cal.add(Calendar.DATE, -30);
        Date create = cal.getTime();
        foods.add(new Onion("Лук", expaire, create, 15, 0));

        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +15);
        foods.add(new Potato("Картошка", cal.getTime(), new Date(System.currentTimeMillis()), 20, 0));

        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +15);
        expaire = cal.getTime();
        cal.add(Calendar.DATE, -30);
        create = cal.getTime();
        foods.add(new Pumpkin("Тыква", expaire, create, 10, 0));

        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -60);
        foods.add(new Pumpkin("Просроченная тыква", new Date(System.currentTimeMillis()), cal.getTime(), 10, 0));
        controllQuality.distribute(foods);
    }

    public static void main(String[] args) {
        List<Storeg<Food>> storegs = new ArrayList<>();
        List<Action> actions = new ArrayList<>();
        actions.add(new DiscauntAction(0.25, new PredicateDiscauntAction()));
        storegs.add(new Shop(new ArrayList<>(), new ShopPredicate(), actions));
        storegs.add(new Warehouse(new ArrayList<>(), new WarehousePredicate()));
        storegs.add(new Trash(new ArrayList<>(), new TrashPredicate()));
        ControllQuality<Food> controllQuality = new SimpleControllQuality(storegs);
        new App(controllQuality).run();
    }
}
