package ru.job4j.plays;

import java.util.List;
import java.util.Map;

public interface Action {
    void exec(Player player, List<Point> points, Map<Player, Point> playerList);
}
