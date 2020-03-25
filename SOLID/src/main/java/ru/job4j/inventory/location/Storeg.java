package ru.job4j.inventory.location;

public interface Storeg<T> {
    void add(T items);
    boolean check(T items);
}
