package ru.job4j.overlap;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@State(Scope.Benchmark)
public class ExecutionPlan {

    public List<Price> currPrice;
    public List<Price> newPrice;

    @Setup(Level.Invocation)
    public void setUp() {
        currPrice = new ArrayList<>();
        newPrice = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000; ++i) {
            currPrice.add(new Price(random.nextInt(100), random.nextInt(10000)));
            newPrice.add(new Price(random.nextInt(100), random.nextInt(10000)));
        }
    }
}
