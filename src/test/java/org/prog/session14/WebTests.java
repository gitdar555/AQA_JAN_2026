package org.prog.session14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebTests {

    private WebDriver driver; // Переменная для управления браузером

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver(); // Открываем браузер Chrome
        driver.manage().window().maximize(); // Разворачиваем окно
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрываем браузер после выполнения всех тестов
        }
    }

    @Test
    public void myWebTest() {

        driver.get("https://allo.ua/"); // Переходим на сайт allo.ua

        // Ищем поле поиска по name="search"
        WebElement element = driver.findElement(By.name("search"));

        element.sendKeys("iphone 17 pro max"); // Вводим текст
        element.sendKeys(Keys.ENTER); // Нажимаем Enter

        System.out.println("done!"); // Сообщение в консоль
    }
}
/*package org.prog.session14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//TODO: write testng tests to go to allo.ua
//TODO: find seach input
//TODO: search for iphone 17 pro max

public class WebTests {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void myWebTest() {
        driver.get("https://rozetka.com.ua/");
        WebElement element = driver.findElement(By.name("search"));
        element.sendKeys("Xiaomi");
        element.sendKeys(Keys.ENTER);
        System.out.println("done!");
    }
}
*/