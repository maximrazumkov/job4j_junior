package ru.job4j.inventory.location.action;

public interface Action<T> {
    void execute(T value);
}
