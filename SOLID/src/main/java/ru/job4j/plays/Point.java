package ru.job4j.plays;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return number == point.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
