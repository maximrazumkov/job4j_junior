package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.Map;

public class SimpleCache<T, V> implements Cache<T, V> {

    private final Map<T, SoftReference<V>> cache;
    private final Loader<T, V> loader;

    public SimpleCache(Map<T, SoftReference<V>> cache, Loader<T, V> loader) {
        this.cache = cache;
        this.loader = loader;
    }

    @Override
    public V getCache(T key) {
        V result = null;
        if (cache.containsKey(key)) {
            result = cache.get(key).get();
        }
        if (result == null) {
            result = loader.load(key);
            if (result != null) {
                cache.put(key, new SoftReference<>(result));
            }
        }
        return result;
    }
}
