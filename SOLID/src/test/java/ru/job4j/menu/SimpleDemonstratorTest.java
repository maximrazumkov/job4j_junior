package ru.job4j.menu;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleDemonstratorTest {

    @Test
    public void whenElementsMenuIsEmpty() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        Demonstrator demonstrator = new SimpleDemonstrator(printStream);
        List<Element> elements = new ArrayList<>();
        demonstrator.show(elements);
    }

    @Test
    public void whenDemonstratorElementMenuWithoutSubElement() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        Demonstrator demonstrator = new SimpleDemonstrator(printStream);
        List<Element> elements = new ArrayList<>();
        Element element1 = new Element("Задача 1", new ArrayList<>(), new ArrayList<>());
        Element element2 = new Element("Задача 2", new ArrayList<>(), new ArrayList<>());
        Element element3 = new Element("Задача 3", new ArrayList<>(), new ArrayList<>());
        elements.add(element1);
        elements.add(element2);
        elements.add(element3);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("----Задача 1")
                .add("----Задача 2")
                .add("----Задача 3")
                .toString();
        demonstrator.show(elements);
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenDemonstratorElementMenuWithSubElement() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        Demonstrator demonstrator = new SimpleDemonstrator(printStream);
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
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("----Задача 1")
                .add("--------Задача 1.1")
                .add("--------Задача 1.2")
                .add("--------Задача 1.3")
                .add("----Задача 2")
                .add("--------Задача 1.1")
                .add("--------Задача 1.2")
                .add("--------Задача 1.3")
                .add("----Задача 3")
                .toString();
        demonstrator.show(elements);
        String result = new String(out.toByteArray());
        assertThat(result, is(expect));
    }
}
