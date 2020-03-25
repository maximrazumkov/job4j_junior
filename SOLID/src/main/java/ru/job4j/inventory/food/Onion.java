package ru.job4j.inventory.food;

import java.util.Date;

public class Onion extends Food {
    public Onion() {
        super();
    }

    public Onion(String name, Date expaireDate, Date createDate, double price, double discount) {
        super(name, expaireDate, createDate, price, discount);
    }
}
