package ru.job4j.cache;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLoaderTest {

    private Loader<String, String> loader;

    @Before
    public void init() {
        loader = new SimpleLoader(new SimpleVirtualFileSystem("./src/test/resources"));
    }

    @Test
    public void whenFileNotEmptyLoadSuccess() {
        String result = loader.load("Names.txt");
        assertThat(result, is("Igor;Tany;Vanya"));
    }

    @Test
    public void whenNotFoundFileThanLoadFail() {
        String result = loader.load("Address222.txt");
        assertNull(result);
    }

    @Test
    public void whenFileisEmptyThanLoadSuccess() {
        String result = loader.load("Address.txt");
        assertTrue(result.isEmpty());
    }
}
