package ru.job4j.menu;

import java.util.List;

public interface Menu {
    List<Element> getElementsList();
    Element getElementById(int num);
    void add(int pareneID, Element element);
}
