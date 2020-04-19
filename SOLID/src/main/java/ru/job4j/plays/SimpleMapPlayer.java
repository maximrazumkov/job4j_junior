package ru.job4j.plays;

import java.util.List;
import java.util.Map;

public class SimpleMapPlayer implements MapPlay {

    private final Map<Player, Point> playerList;
    private final List<Point> points;

    public SimpleMapPlayer(Map<Player, Point> playerList, List<Point> points) {
        this.playerList = playerList;
        this.points = points;
    }

    @Override
    public void move(Player player, int step) {

    }

    @Override
    public boolean isWin() {
        return false;
    }
}
