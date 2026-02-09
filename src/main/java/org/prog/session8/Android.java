package org.prog.session8;

import java.util.Objects;                                // Нужен для удобного equals/hashCode без ошибок


public class Android implements IPhone {               // Класс Android = телефон, поэтому реализует (implements) IPhone

    private String model;                                // Поле (свойство): модель Android (private = спрятано)
    private String color;                                // Поле (свойство): цвет Android

    public Android(String model, String color) {          // Конструктор: создаёт Android и получает модель+цвет
        this.model = model;                               // this.model = поле объекта, model = что передали при создании
        this.color = color;                               // Запоминаем цвет в объекте
    }                                                     // Конец конструктора

    @Override                                             // Говорим: “Я реализую метод из интерфейса”
    public void call(String someone) {                    // Метод звонка (someone = кому звоним)
        System.out.println("Android calls " + someone);   // Выводим в консоль, что Android звонит
    }                                                     // Конец метода call

    @Override                                             // Реализуем второй метод интерфейса
    public void unlockScreen() {                          // Метод разблокировки экрана
        System.out.println("Android unlocked");           // Сообщаем, что Android разблокирован
    }                                                     // Конец метода unlockScreen

    @Override                                             // Переопределяем equals (сравнение объектов)
    public boolean equals(Object o) {                     // На вход приходит любой объект (Object)
        if (this == o) return true;                       // Если это один и тот же объект в памяти — сразу true
        if (!(o instanceof Android)) return false;        // Если o не Android — сравнивать нельзя, значит false
        Android a = (Android) o;                          // Приведение типа: теперь o считаем Android и кладём в a
        return Objects.equals(model, a.model)             // Сравниваем модели (Objects.equals безопасен даже если null)
                && Objects.equals(color, a.color);        // И сравниваем цвета (должны совпасть оба)
    }                                                     // Конец equals

    @Override                                             // Переопределяем hashCode (обязан совпадать с equals)
    public int hashCode() {                               // Возвращаем число-код объекта
        return Objects.hash(model, color);                // Хэш строится из тех же полей, что и equals (model+color)
    }                                                     // Конец hashCode
}                                                         // Конец класса Android

