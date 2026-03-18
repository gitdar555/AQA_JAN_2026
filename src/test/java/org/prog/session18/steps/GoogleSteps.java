package org.prog.session18.steps; // пакет где находится класс шагов

import io.cucumber.java.en.Given; // аннотация для шага Given
import io.cucumber.java.en.Then; // аннотация для шага Then
import io.cucumber.java.en.When; // аннотация для шага When
import org.openqa.selenium.By; // класс для поиска элементов на странице
import org.openqa.selenium.WebDriver; // драйвер браузера
import org.openqa.selenium.WebElement; // элемент страницы
import org.prog.session18.model.Phone; // наш класс Phone

import java.util.ArrayList; // класс ArrayList
import java.util.List; // интерфейс List

public class GoogleSteps { // класс с cucumber step-ами

    public static WebDriver driver; // сюда из CucumberRunner передаётся driver

    public static List<Phone> phones = new ArrayList<>(); // список для найденных телефонов

    @Given("open allo ua") // шаг Given open allo ua из feature
    public void openAlloUa() {

        driver.get("https://allo.ua/ru/"); // открыть главную страницу allo.ua
    }

    @When("search iphone") // шаг When search iphone из feature
    public void searchIphone() {

        driver.get("https://allo.ua/ru/products/mobile/proizvoditel-apple/");
        // сразу открыть страницу с iPhone, чтобы не искать поле поиска
    }

    @Then("get first 3 phones") // шаг Then get first 3 phones из feature
    public void getFirst3Phones() {

        phones.clear();
        // очистить список телефонов перед новым запуском теста

        List<WebElement> products = driver.findElements(By.cssSelector("[data-product-id]"));
        // найти карточки товаров по атрибуту data-product-id

        for (int i = 0; i < 3; i++) {
            // цикл берёт первые 3 товара

            WebElement product = products.get(i);
            // взять одну карточку товара

            String model = product.findElement(
                    By.cssSelector("a.product-card__title, a.product-card__name")
            ).getText();
            // взять название телефона из карточки товара

            String priceText = product.findElement(
                    By.cssSelector(".v-pb__cur, .sum, .price-box__cur")
            ).getText();
            // взять только текст цены, а не весь текст карточки

            int price = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
            // удалить всё кроме цифр и превратить строку в число

            phones.add(new Phone(model, price));
            // создать объект Phone и добавить его в список
        }
    }
}
/*package org.prog.session18.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSteps {

    public static WebDriver driver;

    @Given("I open google main page")
    public void openGooglePage() {
        driver.get("https://www.google.com/");
    }

    @Given("I accept cookies if present")
    public void acceptCookiesIfPresent() {
        WebElement cookiesLink = driver.findElement(By.xpath("//a[contains(@href,'technologies/cookies')]"));
        if (cookiesLink.isDisplayed()) {
            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            buttons.get(buttons.size() - 2).click();
        } else {
            System.out.println("No cookies link found - proceed");
        }
    }

    @Given("I set search field to that person's first and last name")
    public void setSearchFieldToThatPersonFirstAndLastName() throws InterruptedException {
        String firstLastName = DBSteps.randomNames.get(0);
        System.out.println("I will search for " + firstLastName);
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(firstLastName);
        Thread.sleep(1000);
    }
}
*/