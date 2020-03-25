package ru.job4j.inventory.location.action;

import ru.job4j.inventory.food.Food;

import java.util.function.Predicate;

public class DiscauntAction implements Action<Food> {
    private double disc;
    private Predicate<Food> predic;

    public DiscauntAction(double disc, Predicate<Food> predic) {
        this.disc = disc;
        this.predic = predic;
    }

    @Override
    public void execute(Food food) {
        if (predic.test(food)) {
            food.setDiscount(disc);
        }
    }

    public double getDisc() {
        return disc;
    }

    public void setDisc(double disc) {
        this.disc = disc;
    }

    public Predicate<Food> getPredic() {
        return predic;
    }

    public void setPredic(Predicate<Food> predic) {
        this.predic = predic;
    }
}
