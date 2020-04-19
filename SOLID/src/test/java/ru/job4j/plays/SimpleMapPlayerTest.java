package ru.job4j.plays;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SimpleMapPlayerTest {

    private MapPlay mapPlay;
    private Map<Player, Point> pointList;
    private List<Point> points;
    private List<Action> actions;

    @Before
    public void init() {
        pointList = new HashMap<>();
        points = new ArrayList<>();
        actions = new ArrayList<>();
        mapPlay = new SimpleMapPlayer(pointList, points);
    }

    @Test
    public void whenPlayerMoveThanNotAction() {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Point point1 = new Point(1, new ArrayList<>());
        Point point2 = new Point(2, new ArrayList<>());
        Point point3 = new Point(3, new ArrayList<>());
        points.add(point1);
        points.add(point2);
        points.add(point3);
        pointList.put(player1, point1);
        pointList.put(player2, point1);
        pointList.put(player3, point1);
        mapPlay.move(player1, 2);
        Point result = pointList.get(player1);
        assertThat(result, is(point3));
    }

    @Test
    public void whenPlayerMoveThanActionExecAnd() {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Point point1 = new Point(1, new ArrayList<>());
        Point point2 = new Point(2, new ArrayList<>());
        Point point3 = new Point(3, actions);
        Action action1 = mock(Action.class);
        Action action2 = mock(Action.class);
        Action action3 = mock(Action.class);
        actions.add(action1);
        actions.add(action2);
        actions.add(action3);
        points.add(point1);
        points.add(point2);
        points.add(point3);
        pointList.put(player1, point1);
        pointList.put(player2, point1);
        pointList.put(player3, point1);
        mapPlay.move(player1, 2);
        Point result = pointList.get(player1);
        assertThat(result, is(point3));
        verify(action1, times(1)).exec(player1, points, pointList);
        verify(action2, times(1)).exec(player1, points, pointList);
        verify(action3, times(1)).exec(player1, points, pointList);
    }

    @Test
    public void whenPlayerIsWin() {
        Player player1 = new Player("Player1");
        Point point1 = new Point(1, new ArrayList<>());
        Point point2 = new Point(2, new ArrayList<>());
        Point point3 = new Point(3, new ArrayList<>());
        pointList.put(player1, point3);
        assertTrue(mapPlay.isWin());
    }

    @Test
    public void whenPlayerNotWin() {
        Player player1 = new Player("Player1");
        Point point1 = new Point(1, new ArrayList<>());
        Point point2 = new Point(2, new ArrayList<>());
        Point point3 = new Point(3, new ArrayList<>());
        pointList.put(player1, point1);
        assertFalse(mapPlay.isWin());
    }
}
