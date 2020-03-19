package ru.job4j.design;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ReportEngine {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter, Function<List<Employer>, String> handler) {
        List<Employer> employers = store.findBy(filter);
        String result = handler.apply(employers);
        return result;
    }
}

