package org.prog.collections.session12;
import java.util.Objects;
// Нужен для удобного сравнения объектов

public class Owner {
// Создаём класс Owner (владелец)

    private String name;
    // Поле — имя владельца

    public Owner(String name) {
        // Конструктор — вызывается при new Owner("Anna")

        this.name = name;
        // Сохраняем переданное имя в переменную name
    }

    @Override
    public boolean equals(Object o) {
        // Метод сравнения объектов (очень важен для HashMap)

        if (this == o) return true;
        // Если это один и тот же объект в памяти → true

        if (!(o instanceof Owner)) return false;
        // Если объект не типа Owner → false

        Owner owner = (Owner) o;
        // Приводим Object к типу Owner

        return Objects.equals(name, owner.name);
        // Сравниваем имена владельцев
        // Если имена одинаковые → владельцы считаются равными
    }

    @Override
    public int hashCode() {
        // HashMap сначала использует hashCode

        return Objects.hash(name);
        // Хэш строится на основе имени
    }
}
/*public class Owner {
    public String name;
}
*/