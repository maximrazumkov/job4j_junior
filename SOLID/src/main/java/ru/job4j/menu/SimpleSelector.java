package ru.job4j.menu;

import java.util.Scanner;

public class SimpleSelector implements Selector {

    private Scanner scanner;

    public SimpleSelector(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int select() {
        return Integer.valueOf(scanner.nextLine());
    }
}
