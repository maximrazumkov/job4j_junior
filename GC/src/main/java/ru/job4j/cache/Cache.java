package ru.job4j.cache;

public interface Cache<T, V> {
    V getCache(T key);
}
