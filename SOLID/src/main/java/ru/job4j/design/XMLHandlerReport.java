package ru.job4j.design;

import java.util.List;
import java.util.function.Function;

public class XMLHandlerReport implements Function<List<Employer>, String> {
    @Override
    public String apply(List<Employer> employers) {
        StringBuilder xml = new StringBuilder();
        String empl = "<employer><name>?</name><hired>?</hired><fired>?</fired><salary?</salary></employer>";
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><employers>");
        for (Employer employer : employers) {
            xml.append(String.format(empl,
                    employer.getName(),
                    employer.getFired(),
                    employer.getHired(),
                    employer.getSalary()
            ));
        }
        xml.append("</employers>");
        return xml.toString();
    }
}
