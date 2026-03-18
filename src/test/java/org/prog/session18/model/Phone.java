package org.prog.session18.model;

// класс для хранения модели телефона и цены
public class Phone {

    private String model; // название модели
    private int price;    // цена

    // конструктор
    public Phone(String model, int price) {
        this.model = model;
        this.price = price;
    }

    // получить модель
    public String getModel() {
        return model;
    }

    // получить цену
    public int getPrice() {
        return price;
    }
}