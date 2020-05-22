package ru.job4j.overlap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OverlapTest {

    @Test
    public void whenUniteEmptyListsThanResultEmptyList() {
        List<Price> currPrice = new ArrayList<>();
        List<Price> newPrice = new ArrayList();
        List<Price> result = new Overlap().overlapPrice(currPrice, newPrice);
        List<Price> expect = new ArrayList<>();
        assertThat(result, is(expect));
    }

    @Test
    public void whenOnePriceThanReturnOnePrice() {
        List<Price> currPrice = new ArrayList<>();
        List<Price> newPrice = new ArrayList();
        newPrice.add(new Price(122856,11000));
        List<Price> result = new Overlap().overlapPrice(currPrice, newPrice);
        List<Price> expect = new ArrayList<>();
        expect.add(new Price(122856,11000));
        assertThat(result, is(expect));
    }

    @Test
    public void whenTwoPriceAndSetDoesNotCrossThanReturnTwoPrice() {
        List<Price> currPrice = new ArrayList<>();
        List<Price> newPrice = new ArrayList();
        currPrice.add(new Price(6654,5000));
        newPrice.add(new Price(122856,11000));
        List<Price> result = new Overlap().overlapPrice(currPrice, newPrice);
        List<Price> expect = new ArrayList<>();
        expect.add(new Price(122856,11000));
        expect.add(new Price(6654,5000));
        assertThat(result, is(expect));
    }

    @Test
    public void whenTwoPriceAndSetCrossThanReturnTwoPrice() {
        List<Price> currPrice = new ArrayList<>();
        List<Price> newPrice = new ArrayList();
        currPrice.add(new Price(6654,11000));
        newPrice.add(new Price(122856,11000));
        List<Price> result = new Overlap().overlapPrice(currPrice, newPrice);
        List<Price> expect = new ArrayList<>();
        expect.add(new Price(122856,11000));
        expect.add(new Price(6654,11000));
        assertThat(result, is(expect));
    }

    @Test
    public void whenTwoPriceAndSetCrossThanReturnOnePrice() {
        List<Price> currPrice = new ArrayList<>();
        List<Price> newPrice = new ArrayList();
        currPrice.add(new Price(122856,5900));
        newPrice.add(new Price(122856,11000));
        List<Price> result = new Overlap().overlapPrice(currPrice, newPrice);
        List<Price> expect = new ArrayList<>();
        expect.add(new Price(122856,11000));
        assertThat(result, is(expect));
    }
}
