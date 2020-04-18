package ru.job4j.cache;

public interface Loader<T, V> {
    V load(T name);
}
