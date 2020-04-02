package ru.job4j.menu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class SimpleMenuServiceTest {
    @Test
    public void whenRunMenu() {
        Demonstrator demonstrator = mock(Demonstrator.class);
        Selector selector = mock(Selector.class);
        Menu menu = mock(Menu.class);
        MenuService menuService = new SimpleMenuService(demonstrator, selector, menu);
        when(selector.select()).thenReturn(6);
        List<Action> actions = new ArrayList<>();
        Action action1 = mock(Action.class);
        Action action2 = mock(Action.class);
        actions.add(action1);
        actions.add(action2);
        Element element = new Element("Задача 1.1", new ArrayList<>(), actions);
        when(menu.getElementById(6)).thenReturn(element);
        menuService.run();
        verify(action1, times(1)).execute();
        verify(action2, times(1)).execute();
    }
}
