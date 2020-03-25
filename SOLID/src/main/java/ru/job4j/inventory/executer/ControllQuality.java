package ru.job4j.inventory.executer;

import java.util.List;

public interface ControllQuality<T> {
    void distribute(List<T> items);
}
