package org.prog.session8;

import java.util.Objects;                                 // Для equals/hashCode

public class Apple implements IPhone {                  // Apple = телефон, поэтому implements IPhone

    private String model;                                 // Поле: модель iPhone
    private String color;                                 // Поле: цвет iPhone

    public Apple(String model, String color) {             // Конструктор: создаём Apple с моделью и цветом
        this.model = model;                                // Сохраняем модель в объект
        this.color = color;                                // Сохраняем цвет в объект
    }                                                      // Конец конструктора

    @Override                                              // Реализуем метод из интерфейса
    public void call(String someone) {                     // Метод звонка
        System.out.println("Apple calls " + someone);      // Пишем в консоль, что Apple звонит
    }                                                      // Конец call

    @Override                                              // Реализуем метод из интерфейса
    public void unlockScreen() {                           // Метод разблокировки
        System.out.println("Apple unlocked");              // Сообщаем, что Apple разблокирован
    }                                                      // Конец unlockScreen

    @Override                                              // Переопределяем equals
    public boolean equals(Object o) {                      // На вход приходит Object (любой объект)
        if (this == o) return true;                        // Если сравниваем объект сам с собой — true
        if (!(o instanceof Apple)) return false;           // Если o не Apple — это другой тип, значит false
        Apple a = (Apple) o;                               // Приводим Object к Apple, чтобы читать поля model/color
        return Objects.equals(model, a.model)              // Сравниваем модели безопасно (без NPE)
                && Objects.equals(color, a.color);         // И цвета (оба должны совпасть)
    }                                                      // Конец equals

    @Override                                              // Переопределяем hashCode
    public int hashCode() {                                // Возвращаем хэш-код
        return Objects.hash(model, color);                 // Хэш из model+color (как в equals)
    }                                                      // Конец hashCode
}                                                          // Конец класса Apple

