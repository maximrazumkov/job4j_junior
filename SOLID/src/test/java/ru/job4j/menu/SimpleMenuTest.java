package ru.job4j.menu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleMenuTest {
    @Test
    public void whenSuccessGetElementById() {
        List<Element> elements = new ArrayList<>();
        List<Element> subElements = new ArrayList<>();
        subElements.add(new Element("Задача 1.1", new ArrayList<>(), new ArrayList<>()));
        subElements.add(new Element("Задача 1.2", new ArrayList<>(), new ArrayList<>()));
        subElements.add(new Element("Задача 1.3", new ArrayList<>(), new ArrayList<>()));
        Element element1 = new Element("Задача 1", subElements, new ArrayList<>());
        Element element2 = new Element("Задача 2", subElements, new ArrayList<>());
        Element element3 = new Element("Задача 3", new ArrayList<>(), new ArrayList<>());
        elements.add(element1);
        elements.add(element2);
        elements.add(element3);
        Menu menu = new SimpleMenu(elements);
        Element element = menu.getElementById(5);
        assertThat(element.getName(), is("Задача 1.2"));
    }
}
