package ru.job4j.design;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReportEngineTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        String result = engine.generate(em -> true, new DefaultHandlerReport());
        assertThat(result, is(expect.toString()));
    }

    @Test
    public void whenForProgrammersGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        String worketHtml = String.format(
                "<tr><td>?</td><td>?</td><td>?</td><td>?</td></tr>",
                worker.getName(),
                worker.getHired(),
                worker.getFired(),
                worker.getSalary()
        );
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE HTML><html><head></head><body><table><thead>")
                .append("<tr><td>Name</td><td>Hired</td><td>Fired</td><td>Salary</td></tr></thead>")
                .append(worketHtml)
                .append("</table></body></html>");
        assertThat(engine.generate(em -> true, new HtmlReportHandler()), is(expect.toString()));
    }

    @Test
    public void whenForAccountantsGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(String.format("%.2f", worker.getSalary())).append(";");
        assertThat(engine.generate(em -> true, new UnusualSalaryHandlerReport()), is(expect.toString()));
    }

    @Test
    public void whenForHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker1 = new Employer("Ivan", now, now, 100);
        Employer worker2 = new Employer("Ivan", now, now, 400);
        Employer worker3 = new Employer("Ivan", now, now, 50);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";");
        assertThat(engine.generate(em -> true, new SortedBySalaryReportHandler()), is(expect.toString()));
    }
}
