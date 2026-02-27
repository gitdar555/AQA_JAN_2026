package org.prog.session13;  // пакет (должен совпадать с папками)

import java.util.Random;     // подключаем Random

public class Apple {         // создаём класс

    private int modelNumber; // поле (переменная)

    public Apple() {         // конструктор
        Random random = new Random();      // создаём random
        modelNumber = random.nextInt(5) + 1;
        // число от 1 до 5
    }

    public int getModelNumber() { // метод для получения значения
        return modelNumber;
    }
}