package org.prog.session8;

public interface IPhone {                               // Интерфейс = правила, что “телефон обязан уметь”
    void call(String someone);                          // Метод без возврата: телефон звонит кому-то (someone = имя/контакт)
    void unlockScreen();                                // Метод без возврата: телефон разблокирует экран
}

