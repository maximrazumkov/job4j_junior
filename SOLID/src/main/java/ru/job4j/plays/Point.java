package ru.job4j.plays;

import java.util.List;

public class Point {
    private final int number;
    private final List<Action> actions;

    public Point(int number, List<Action> actions) {
        this.number = number;
        this.actions = actions;
    }

    public List<Action> getActions() {
        return actions;
    }

}
