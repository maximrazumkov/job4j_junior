package ru.job4j.plays;

import java.util.Random;

public class SimpleDice implements Dice {
    @Override
    public int throwDice() {
        return new Random().nextInt(6) + 1;
    }
}
