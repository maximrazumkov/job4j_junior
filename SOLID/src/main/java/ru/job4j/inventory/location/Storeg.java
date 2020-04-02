package ru.job4j.inventory.location;

import java.util.List;

public interface Storeg<T> {
    void add(T items);
    boolean check(T items);
    List<T> findAll();
}
