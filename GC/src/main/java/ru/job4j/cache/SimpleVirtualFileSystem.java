package ru.job4j.cache;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class SimpleVirtualFileSystem implements VirtualFileSystem {

    private final String dir;

    public SimpleVirtualFileSystem(String dir) {
        this.dir = dir;
    }

    @Override
    public String findFileByName(String name) {
        String result = null;
        try {
            Queue<File> files = new LinkedList<>();
            files.add(new File(dir));
            while (!files.isEmpty()) {
                File file = files.poll();
                if (file.isDirectory()) {
                    for (File subFile : file.listFiles()) {
                        files.add(subFile);
                    }
                } else {
                    if (file.getName().equals(name)) {
                        result = file.getCanonicalPath();
                        break;
                    }
                };
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
