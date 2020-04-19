package ru.job4j.plays;

import java.util.Objects;

public class Player {
    private final String name;
    private boolean isBlock;

    public Player(String name) {
        this.name = name;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }
}
