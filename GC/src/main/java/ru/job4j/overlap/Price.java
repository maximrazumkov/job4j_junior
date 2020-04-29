package ru.job4j.overlap;

public class Price {
    private int code;
    private int value;

    public Price(int code, int value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Price{" +
                "code=" + code +
                ", value=" + value +
                '}';
    }
}
