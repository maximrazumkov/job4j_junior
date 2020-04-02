package ru.job4j.menu;

import java.io.PrintStream;
import java.util.List;

public class SimpleDemonstrator implements Demonstrator {

    private final PrintStream out;

    public SimpleDemonstrator(PrintStream out) {
        this.out = out;
    }

    @Override
    public void show(List<Element> element) {
        print(element, "----%s");
    }

    private void print(List<Element> elements, String mask) {
        for (int i = 0; i < elements.size(); ++i) {
            Element element = elements.get(i);
            out.println(String.format(mask, element.getName()));
            if (!element.getChildren().isEmpty()) {
                print(element.getChildren(), String.format(mask, "----%s"));
            }
        }
    }
}
