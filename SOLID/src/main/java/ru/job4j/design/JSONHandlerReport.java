package ru.job4j.design;

import java.util.List;
import java.util.function.Function;

public class JSONHandlerReport implements Function<List<Employer>, String> {
    @Override
    public String apply(List<Employer> employers) {
        StringBuilder json = new StringBuilder();
        String empl = "{ \"name\": \"?\", \"hired\": ?, \"fired\": ?, \"salary\": ? }";
        json.append("\"employers\": [ ");
        for (Employer employer : employers) {
            json.append(String.format(empl,
                    employer.getName(),
                    employer.getFired(),
                    employer.getHired(),
                    employer.getSalary()
            ));
        }
        json.append(" ]");
        return json.toString();
    }
}
