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
        List<Element> subElements1 = new ArrayList<>();
        subElements1.add(new Element("Задача 1.1", new ArrayList<>(), new ArrayList<>()));
        subElements1.add(new Element("Задача 1.2", new ArrayList<>(), new ArrayList<>()));
        subElements1.add(new Element("Задача 1.3", new ArrayList<>(), new ArrayList<>()));

        List<Element> subElements2 = new ArrayList<>();
        subElements2.add(new Element("Задача 2.1", new ArrayList<>(), new ArrayList<>()));
        subElements2.add(new Element("Задача 2.2", new ArrayList<>(), new ArrayList<>()));
        subElements2.add(new Element("Задача 2.3", new ArrayList<>(), new ArrayList<>()));

        Element element1 = new Element("Задача 1", subElements1, new ArrayList<>());
        Element element2 = new Element("Задача 2", subElements2, new ArrayList<>());
        Element element3 = new Element("Задача 3", new ArrayList<>(), new ArrayList<>());
        elements.add(element1);
        elements.add(element2);
        elements.add(element3);
        Menu menu = new SimpleMenu(elements);
        Element element = menu.getElementById(5);
        assertThat(element.getName(), is("Задача 1.2"));
    }

    @Test
    public void whenAddElementByParentIdThanSuccess() {
        List<Element> elements = new ArrayList<>();
        List<Element> subElements1 = new ArrayList<>();
        subElements1.add(new Element("Задача 1.1", new ArrayList<>(), new ArrayList<>()));
        subElements1.add(new Element("Задача 1.2", new ArrayList<>(), new ArrayList<>()));
        subElements1.add(new Element("Задача 1.3", new ArrayList<>(), new ArrayList<>()));

        List<Element> subElements2 = new ArrayList<>();
        subElements2.add(new Element("Задача 2.1", new ArrayList<>(), new ArrayList<>()));
        subElements2.add(new Element("Задача 2.2", new ArrayList<>(), new ArrayList<>()));
        subElements2.add(new Element("Задача 2.3", new ArrayList<>(), new ArrayList<>()));

        Element element1 = new Element("Задача 1", subElements1, new ArrayList<>());
        Element element2 = new Element("Задача 2", subElements2, new ArrayList<>());
        Element element3 = new Element("Задача 3", new ArrayList<>(), new ArrayList<>());
        elements.add(element1);
        elements.add(element2);
        elements.add(element3);
        Menu menu = new SimpleMenu(elements);
        menu.add(5, new Element("Задача 1.2.1", new ArrayList<>(), new ArrayList<>()));
        Element element = menu.getElementById(10);
        assertThat(element.getName(), is("Задача 1.2.1"));
    }
}
