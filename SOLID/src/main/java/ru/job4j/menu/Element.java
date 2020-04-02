package ru.job4j.menu;

import java.util.List;

public class Element {
    private final String name;
    private final List<Element> children;
    private final List<Action> action;

    public Element(String name, List<Element> children, List<Action> action) {
        this.name = name;
        this.children = children;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public List<Action> getAction() {
        return action;
    }

    public List<Element> getChildren() {
        return children;
    }
}
