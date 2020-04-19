package ru.job4j.plays;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class ActionBlockPlayerTest {

    private Map<Player, Point> pointList;
    private List<Point> points;

    @Before
    public void init() {
        pointList = new HashMap<>();
        points = new ArrayList<>();
    }

    @Test
    public void whenBlockPlayer() {
        Player player1 = new Player("Player1");
        Point point1 = new Point(1, new ArrayList<>());
        Point point2 = new Point(2, new ArrayList<>());
        Point point3 = new Point(3, new ArrayList<>());
        points.add(point1);
        points.add(point2);
        points.add(point3);
        pointList.put(player1, point3);
        Action action = new ActionReturnPlayerPrevStep();
        action.exec(player1, points, pointList);
        assertTrue(player1.isBlock());
    }
}
