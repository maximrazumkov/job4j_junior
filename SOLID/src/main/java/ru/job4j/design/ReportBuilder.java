package ru.job4j.design;

import java.util.function.Predicate;

public interface ReportBuilder {
    public String generate(Predicate<Employer> filter);
}
