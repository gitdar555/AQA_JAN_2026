package org.prog.collections.session11;

public class Phone {

    private String brand;
    private String color;

    public Phone(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return brand + " " + color;
    }
}