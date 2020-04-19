package ru.job4j.plays;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PlayWalkerTest {

    private Play play;
    private List<Player> players;
    private MapPlay map;
    private Dice dice;

    @Before
    public void init() {
        players = new ArrayList<>();
        map = mock(MapPlay.class);
        dice = mock(Dice.class);
        play = new PlayWalker(players, map, dice);
    }

    @Test
    public void whenPlayerMoveAndWin() {
        Player player1 = new Player("Player1");
        players.add(player1);
        Player player2 = new Player("Player2");
        players.add(player2);
        Player player3 = new Player("Player3");
        players.add(player3);
        when(map.isWin()).thenReturn(false).thenReturn(false).thenReturn(true);
        when(dice.throwDice()).thenReturn(4).thenReturn(3).thenReturn(6);
        play.run();
        verify(map, times(3)).isWin();
        verify(dice, times(3)).throwDice();
        verify(map, times(1)).move(player1, 4);
        verify(map, times(1)).move(player2, 3);
        verify(map, times(1)).move(player3, 6);
    }
}
