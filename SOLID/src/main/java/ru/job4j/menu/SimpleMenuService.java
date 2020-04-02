package ru.job4j.menu;

import java.util.List;

public class SimpleMenuService implements MenuService {
    private final Demonstrator demonstrator;
    private final Selector selector;
    private final Menu menu;

    public SimpleMenuService(Demonstrator demonstrator, Selector selector, Menu menu) {
        this.demonstrator = demonstrator;
        this.selector = selector;
        this.menu = menu;
    }

    public void run() {
        demonstrator.show(menu.getElementsList());
        int idx = selector.select();
        Element element = menu.getElementById(idx);
        List<Action> actions = element.getAction();
        if (!actions.isEmpty()) {
            actions.forEach(action -> action.execute());
        }
    }
}
