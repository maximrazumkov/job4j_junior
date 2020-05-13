package ru.job4j.plays;

import java.util.List;

public class PlayWalker implements Play {

    private final List<Player> players;
    private final MapPlay map;
    private final Dice dice;

    public PlayWalker(List<Player> players, MapPlay map, Dice dice) {
        this.players = players;
        this.map = map;
        this.dice = dice;
    }

    @Override
    public void run() {
        Player currPlayer;
        int i = 0;
        int size = players.size();
        do {
            i = (i == size) ? 0 : i;
            currPlayer = players.get(i++);
            map.move(currPlayer, dice.throwDice());
        } while (!map.isWin());
    }
}
