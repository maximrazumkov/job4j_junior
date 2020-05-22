package ru.job4j.overlap;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Fork(value = 2, warmups = 2)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class Overlap {

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void loopArrayList(ExecutionPlan plan, Blackhole blackhole) {
        overlapPrice(plan.currPrice, plan.newPrice);
    }

    public List<Price> overlapPrice(List<? extends Price> currPrice, List<? extends Price> newPrice) {
        Set<Price> currSetPrice = new HashSet<>(currPrice);
        currSetPrice.addAll(newPrice);
        List<Price> result = new ArrayList<>(currSetPrice);;
        result.sort((o1, o2) -> {
            int res = o2.getCode() - o1.getCode();
            if (res == 0) {
                res = o2.getValue() - o1.getValue();
            }
            return res;
        });
        return result;
    }
}
