package ru.job4j.design;

import java.util.List;
import java.util.function.Function;

public class SortedBySalaryReportHandler implements Function<List<Employer>, String> {
    @Override
    public String apply(List<Employer> employers) {
        employers.sort((empl1, empl2) -> empl1.getSalary() < empl2.getSalary() ? 1 : -1);
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employer employer : employers) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return text.toString();
    }
}