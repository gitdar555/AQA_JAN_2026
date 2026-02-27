package org.prog.session13;
// тот же пакет, что и у Apple

import org.junit.jupiter.api.Assertions;
// импорт для проверок (assert)

import org.junit.jupiter.api.Test;
// импорт аннотации @Test

public class JUnitTests4 {
// имя класса ДОЛЖНО совпадать с именем файла

    @Test
        // говорим что это тест

    void modelNumber_is_3_or_above() {
        // имя тестового метода

        Apple apple = new Apple();
        // создаём объект Apple

        int model = apple.getModelNumber();
        // получаем номер модели

        Assertions.assertTrue(model >= 1 && model <= 5);
        // проверяем что число от 1 до 5

        Assertions.assertTrue(model >= 3);
        // проверяем что число >= 3
    }
}

/*package org.prog.session13;

import org.junit.jupiter.api.*;

public class JUnitTests4 {

    @BeforeAll
    public static void setUp() {
        System.out.println("Start BROWSER 2");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Terminate BROWSER 2");
    }

    @BeforeEach
    public void beforeTest(){
        System.out.println("Load Home Page");
    }

    @AfterEach
    public void afterTest(){
        System.out.println("Clear Cookies");
        System.out.println("Load about:blank");
    }

    @Test
    public void cancelRegTest() {
        System.out.println("Click Reg button");
        System.out.println("Fill user credentials");
        System.out.println("Cancel reg by pressing 'cancel'");
    }

    @Test
    public void cancelRegTest2() {
        System.out.println("Click Reg button");
        System.out.println("Fill user credentials");
        System.out.println("Close reg form by pressing ESC");
    }
}
*/