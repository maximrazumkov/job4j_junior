package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;

public class SimpleLoader implements Loader<String, String> {

    private final VirtualFileSystem vfs;

    public SimpleLoader(VirtualFileSystem vfs) {
        this.vfs = vfs;
    }

    @Override
    public String load(String name) {
        String result = null;
        String dir = vfs.findFileByName(name);
        if (dir != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(dir))) {
                String line;
                StringBuilder strBuilder = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    strBuilder.append(line);
                }
                result = strBuilder.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
