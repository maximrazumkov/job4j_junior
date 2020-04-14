package ru.job4j.menu;

import java.util.*;

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

    @Override
    public void add(int pareneID, Element element) {
        Queue<Element> data = new LinkedList<>(menu);
        int i = 1;
        while (!data.isEmpty()) {
            Element elem = data.poll();
            if (i++ == pareneID) {
                elem.getChildren().add(element);
                break;
            } else {
                for (Element elemChildren : elem.getChildren()) {
                    data.add(elemChildren);
                }
            }
        }
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
