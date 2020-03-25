package ru.job4j.inventory.food;

import java.util.Date;

public abstract class Food {
    private String name;
    private Date expaireDate;
    private Date createDate;
    private double price;
    private double discount;

    public Food() {
    }

    public Food(String name, Date expaireDate, Date createDate, double price, double discount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(Date expaireDate) {
        this.expaireDate = expaireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getValidityPeriod() {
        double validityPeriod = expaireDate.getTime() - createDate.getTime();
        return (System.currentTimeMillis() - createDate.getTime()) / validityPeriod;
    }
}
