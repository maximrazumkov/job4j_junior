package ru.job4j.design;

import java.util.List;
import java.util.function.Function;

public class DefaultHandlerReport implements Function<List<Employer>, String> {
    @Override
    public String apply(List<Employer> employers) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employer employer : employers) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return text.toString();
    }
}
