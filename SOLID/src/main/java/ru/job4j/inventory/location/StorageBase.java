package ru.job4j.inventory.location;

import java.util.List;

public abstract class StorageBase<T> implements Storeg<T> {
    private final List<T> items;

    public StorageBase(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    @Override
    public void add(T item) {
        this.items.add(item);
    }
}
