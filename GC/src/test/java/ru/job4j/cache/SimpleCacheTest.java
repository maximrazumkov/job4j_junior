package ru.job4j.cache;

import org.junit.Before;
import org.junit.Test;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class SimpleCacheTest {

    private Cache<String, String> cache;
    private Map<String, SoftReference<String>> cacheMap;
    private Loader<String, String> loader;

    @Before
    public void init() {
        loader = mock(SimpleLoader.class);
        cacheMap = new HashMap<>();
        cache = new SimpleCache<>(cacheMap, loader);
    }

    @Test
    public void whenCacheHaveInfoThanCacheReturnInfo() {
        String nameFile = "Names.text";
        String textFile = "Some Text";
        cacheMap.put(nameFile, new SoftReference<>("Some Text"));
        String result = cache.getCache(nameFile);
        assertThat(result, is(textFile));
        verify(loader, times(0)).load(anyString());
    }

    @Test
    public void whenCacheHaveNotInfoThanCacheLoadAndReturnInfo() {
        String nameFile = "Names.text";
        String textFile = "Some Text";
        doReturn(textFile).when(loader).load(nameFile);
        String result = cache.getCache(nameFile);
        assertThat(result, is(textFile));
        assertThat(cacheMap.size(), is(1));
        verify(loader, times(1)).load(nameFile);
    }

    @Test
    public void whenCacheHaevNotInfoAndInfoNotInRepositoryThanCacheNotLoadAndNotReturnInfo() {
        String nameFile = "Names.text";
        String textFile = "Some Text";
        doReturn(null).when(loader).load(nameFile);
        String result = cache.getCache(nameFile);
        assertNull(result);
        assertThat(cacheMap.size(), is(0));
        verify(loader, times(1)).load(nameFile);
    }
}
