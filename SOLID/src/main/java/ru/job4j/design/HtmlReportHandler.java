package ru.job4j.design;

import java.util.List;
import java.util.function.Function;

public class HtmlReportHandler implements Function<List<Employer>, String> {
    @Override
    public String apply(List<Employer> employers) {
        StringBuilder result = new StringBuilder()
                .append("<!DOCTYPE HTML><html><head></head><body><table><thead>")
                .append("<tr><td>Name</td><td>Hired</td><td>Fired</td><td>Salary</td></tr></thead>");
        for (Employer employer : employers) {
            String employerHtml = String.format(
                    "<tr><td>?</td><td>?</td><td>?</td><td>?</td></tr>",
                    employer.getName(),
                    employer.getHired(),
                    employer.getFired(),
                    employer.getSalary()
            );
            result.append(employerHtml);
        }
        result.append("</table></body></html>");
        return result.toString();
    }
}
