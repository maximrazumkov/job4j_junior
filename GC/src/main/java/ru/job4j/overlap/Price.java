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

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + code;
        result = 31 * result + value;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }

        if (o instanceof Price) {
            Price price = (Price) o;
            return (price.code == this.code)
                    && (price.value == this.value);
        }

        return false;
    }
}
