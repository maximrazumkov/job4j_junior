package ru.job4j.menu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SimpleMenu implements Menu {

    private final List<Element> menu;

    public SimpleMenu(List<Element> menu) {
        this.menu = menu;
    }

    @Override
    public List<Element> getElementsList() {
        return menu;
    }

    @Override
    public Element getElementById(int num) {
        Iterator<Element> itr = new ElementIterator();
        Element result = null;
        int i = 0;
        while (++i <= num && itr.hasNext()) {
            result = itr.next();
        }
        return result;
    }

    private class ElementIterator implements Iterator<Element> {

        private Queue<Element> elements = new LinkedList<>(menu);

        @Override
        public boolean hasNext() {
            return !elements.isEmpty();
        }

        @Override
        public Element next() {
            Element element = elements.peek();
            if (!element.getChildren().isEmpty()) {
                for (Element elm : element.getChildren()) {
                    elements.add(elm);
                }
            }
            return elements.poll();
        }
    }
}
