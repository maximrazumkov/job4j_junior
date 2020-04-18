package ru.job4j.cache;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SimpleVirtualFileSystemTest {

    private VirtualFileSystem vfs;

    @Before
    public void init() {
        vfs = new SimpleVirtualFileSystem("./src/test/resources");
    }

    @Test
    public void whenFindFile() {
        String result = vfs.findFileByName("Names.txt");
        assertTrue(result.contains("Names.txt"));
    }

    @Test
    public void whenNotFindFile() {
        String result = vfs.findFileByName("Names222.txt");
        assertNull(result);
    }
}
