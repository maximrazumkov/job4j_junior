package ru.job4j.inventory.food;

import java.util.Date;

public class Potato extends Food {
    public Potato() {
        super();
    }

    public Potato(String name, Date expaireDate, Date createDate, double price, double discount) {
        super(name, expaireDate, createDate, price, discount);
    }
}
