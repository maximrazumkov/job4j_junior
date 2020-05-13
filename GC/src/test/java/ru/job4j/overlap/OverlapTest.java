package ru.job4j.overlap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OverlapTest {
    @Test
    public void whenList3ElemsUniteList3ElemsThanResultList6Elems() {
        List<Price> currPrice = new ArrayList<>();
        List<Price> newPrice = new ArrayList();
        currPrice.add(new Price(122856,11000));
        currPrice.add(new Price(122856, 99000));
        currPrice.add(new Price(6654,5000));
        newPrice.add(new Price(122856,11000));
        newPrice.add(new Price(122856, 92000));
        newPrice.add(new Price(6654,4000));
        List<Price> result = new Overlap().overlapPrice(currPrice, newPrice);
        List<Price> expect = new ArrayList<>();
        expect.add(new Price(122856, 99000));
        expect.add(new Price(122856, 92000));
        expect.add(new Price(122856,11000));
        expect.add(new Price(122856,11000));
        expect.add(new Price(6654,5000));
        expect.add(new Price(6654,4000));
        assertThat(result, is(expect));
    }

    @Test
    public void whenUniteEmptyListsThanResultEmptyList() {
        List<Price> currPrice = new ArrayList<>();
        List<Price> newPrice = new ArrayList();
        List<Price> result = new Overlap().overlapPrice(currPrice, newPrice);
        List<Price> expect = new ArrayList<>();
        assertThat(result, is(expect));
    }
}
