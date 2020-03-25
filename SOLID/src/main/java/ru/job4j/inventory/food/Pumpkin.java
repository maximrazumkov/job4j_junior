package ru.job4j.inventory.food;

import java.util.Date;

public class Pumpkin extends Food {
    public Pumpkin() {
        super();
    }

    public Pumpkin(String name, Date expaireDate, Date createDate, double price, double discount) {
        super(name, expaireDate, createDate, price, discount);
    }
}
