package org.prog.session15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class WebTests {

    // Driver оставляем в тестовом классе,
    // потому что именно тест создаёт и закрывает браузер.
    private WebDriver driver;

    // Создаём объект страницы allo.ua.
    // Через него тест будет работать со страницей.
    private AlloPage alloPage;

    @BeforeSuite
    public void setUp() {

        // Создаём ChromeDriver перед запуском всех тестов.
        driver = new ChromeDriver();

        // Разворачиваем окно на весь экран,
        // чтобы элементы страницы были видимы и доступны.
        driver.manage().window().maximize();

        // Создаём объект страницы и передаём туда driver.
        // Теперь весь код взаимодействия со страницей
        // будет находиться внутри AlloPage.
        alloPage = new AlloPage(driver);
    }

    @AfterSuite
    public void tearDown() {

        // После завершения тестов закрываем браузер,
        // если он был создан.
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void alloIphone17PricesTest() {

        // Открываем главную страницу сайта.
        // Раньше было driver.get(...),
        // теперь это скрыто внутри метода open().
        alloPage.open();

        // Принимаем cookies, если popup появился.
        // Тест не знает, как именно ищется кнопка —
        // это спрятано в page object.
        alloPage.acceptCookies();

        // Выполняем поиск по тексту "iphone 17".
        // Тест говорит ЧТО надо сделать,
        // а page object знает КАК это сделать.
        alloPage.search("iphone 17");

        // Ждём, пока результаты поиска загрузятся.
        alloPage.waitForResults();

        // Получаем все найденные карточки товаров.
        // Снова тест не работает напрямую с XPath.
        List<WebElement> productCards = alloPage.getProductCards();

        // Проверяем, что найдено хотя бы 3 товара.
        // Assert должен оставаться в тесте,
        // потому что проверки — это задача теста, а не page object.
        Assert.assertTrue(
                productCards.size() >= 3,
                "Найдено меньше 3 товаров"
        );
    }
}
/*package org.prog.session15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebTests {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        // создаём драйвер Chrome

        driver.manage().window().maximize();
        // открываем окно браузера на весь экран
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        // закрываем браузер после выполнения тестов
    }

    @Test
    public void alloIphone17PricesTest() {

        driver.get("https://allo.ua/");
        // открываем сайт allo.ua

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // создаём явное ожидание на 20 секунд

        try {
            WebElement acceptCookies = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(.,'Прийняти') or contains(.,'Accept')]")));
            // пытаемся найти кнопку принятия cookies

            acceptCookies.click();
            // нажимаем кнопку cookies
        } catch (Exception e) {
            System.out.println("Cookies popup не появился");
            // если окно cookies не появилось, просто продолжаем
        }

        WebElement searchInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[contains(@placeholder,'Пошук') or @type='search' or @name='search']")));
        // ищем поле поиска

        searchInput.click();
        // кликаем в поле поиска

        searchInput.sendKeys("iphone 17");
        // вводим в поиск iphone 17

        searchInput.sendKeys(Keys.ENTER);
        // нажимаем Enter для выполнения поиска

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Apple iPhone 17')]")));
        // ждём, пока на странице результатов появится хотя бы один товар Apple iPhone 17

        List<WebElement> productCards = driver.findElements(
                By.xpath("//*[.//*[contains(text(),'Apple iPhone 17')] and .//*[contains(text(),'₴')]]"));
        // находим карточки, внутри которых есть и название Apple iPhone 17, и цена в гривнах

        Assert.assertTrue(productCards.size() >= 3, "Найдено меньше 3 товаров iPhone 17");
        // проверяем, что найдено хотя бы 3 карточки товаров

        for (int i = 0; i < 3; i++) {
            // цикл по первым трём товарам

            WebElement card = productCards.get(i);
            // берём текущую карточку товара

            WebElement title = card.findElement(
                    By.xpath(".//*[contains(text(),'Apple iPhone 17')][1]"));
            // внутри карточки находим название товара

            List<WebElement> prices = card.findElements(
                    By.xpath(".//*[contains(text(),'₴')]"));
            // внутри карточки находим все элементы, где есть символ гривны

            String titleText = title.getText().trim();
            // получаем текст названия товара

            String priceText = "";
            // создаём переменную для цены

            for (WebElement price : prices) {
                // перебираем все найденные элементы с гривной

                String currentText = price.getText().trim();
                // получаем текст текущего элемента

                if (!currentText.isEmpty() && currentText.contains("₴")) {
                    // проверяем, что текст не пустой и это действительно цена

                    priceText = currentText;
                    // записываем первую подходящую цену

                    break;
                    // выходим из цикла
                }
            }

            System.out.println("Product: " + titleText);
            // выводим название товара в консоль

            System.out.println("Price: " + priceText);
            // выводим цену товара в консоль

            Assert.assertNotNull(titleText);
            // проверяем, что название не равно null

            Assert.assertFalse(titleText.isEmpty(), "Название товара пустое");
            // проверяем, что название не пустое

            Assert.assertNotNull(priceText);
            // проверяем, что цена не равна null

            Assert.assertFalse(priceText.isEmpty(), "Цена товара пустая");
            // проверяем, что цена не пустая
        }
    }
}
/*package org.prog.session15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

//TODO: load allo.ua (done)
//TODO: search for iphone (done)
//TODO: find prices for first 3 items
//TODO: assert price not null

//TODO: * - confirm goods it not null for first 3 items
//TODO: * - if doing this, use maximize (see below)

public class WebTests {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void alloIphonePricesTest() {

        driver.get("https://allo.ua/");
        // открываем сайт allo.ua в браузере

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // создаем явное ожидание (максимум 10 секунд)

        WebElement searchInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        // ждём пока появится поле поиска и находим его по атрибуту name="q"

        searchInput.click();
        // нажимаем на поле поиска

        searchInput.sendKeys("iphone");
        // вводим слово iphone в поле поиска

        searchInput.sendKeys(Keys.ENTER);
        // нажимаем Enter чтобы выполнить поиск

        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.className("product-card")));
        // ждём пока на странице появятся карточки товаров

        List<WebElement> products = driver.findElements(By.className("product-card"));
        // получаем список всех найденных товаров

        for (int i = 0; i < 3; i++) {
            // цикл для первых трёх товаров

            WebElement product = products.get(i);
            // берём текущий товар из списка

            WebElement title = product.findElement(By.xpath(".//a"));
            // внутри карточки товара находим ссылку с названием товара

            WebElement price = product.findElement(By.xpath(".//span[contains(@class,'price')]"));
            // внутри карточки товара находим элемент с ценой через xpath

            String titleText = title.getText();
            // получаем текст названия товара

            String priceText = price.getText();
            // получаем текст цены

            System.out.println("Product: " + titleText);
            // выводим название товара в консоль

            System.out.println("Price: " + priceText);
            // выводим цену товара в консоль

            Assert.assertNotNull(priceText);
            // проверяем что цена не равна null

            Assert.assertFalse(priceText.isEmpty());
            // проверяем что цена не пустая строка

            Assert.assertNotNull(titleText);
            // проверяем что название товара не null

            Assert.assertFalse(titleText.isEmpty());
            // проверяем что название товара не пустое
        }
    }
    /*@Test
    public void actionsTest() {
        driver.get("https://www.w3schools.com/cssref/tryit.php?filename=trycss_sel_hover");

//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("alert('Hello Selenium!')");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookiesFrame =
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("fast-cmp-iframe")));
        driver.switchTo().frame(cookiesFrame);
        //accept cookies
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Accept']")))
                .click();
        driver.switchTo().defaultContent();

        WebElement iFrame = webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("iframeResult_0")));
        driver.switchTo().frame(iFrame);

        Actions linkActions = new Actions(driver);
        WebElement link1 = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("w3schools.com")));
        WebElement link2 = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("wikipedia.org")));
        linkActions.moveToElement(link1);
        linkActions.pause(Duration.ofSeconds(5));
        linkActions.moveToElement(link2);
        linkActions.pause(Duration.ofSeconds(5));
        linkActions.perform();
        System.out.println("done!");

    }

    @Test
    public void iFrameTest() {
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_test");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookiesFrame =
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("fast-cmp-iframe")));
        driver.switchTo().frame(cookiesFrame);
        //accept cookies
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Accept']")))
                .click();

        driver.switchTo().defaultContent();
        //switch to iFrame
        WebElement iFrame = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iFrame);

        WebElement element =
                webDriverWait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//button[text()='Click Me!']")));
        System.out.println(element.isDisplayed());
    }

    @Test
    public void myWebTest() {
        driver.get("https://www.cloudflare.com/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5L));

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler")));

//        WebElement acceptCookies =webDriverWait.until(
//                ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
//        acceptCookies.click();

        webDriverWait
                .until(
                        ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")))
                .click();

        WebElement sideMenu = driver.findElement(By.xpath(
                "//button[@aria-label='Toggle menu']"));
        sideMenu.click();

        WebElement loginBtn = driver.findElement(By.linkText("Log in"));
        loginBtn.click();

//        WebElement emailInput = driver.findElement(By.id("email"));
//        emailInput.click();
//        emailInput.sendKeys("test@test.com");
//
//        WebElement passwordInput = driver.findElement(By.id("password"));
//        passwordInput.click();
//        passwordInput.sendKeys("test123");

        System.out.println("done!");
    }
}
*/