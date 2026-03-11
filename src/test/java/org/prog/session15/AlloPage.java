package org.prog.session15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlloPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AlloPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void open() {
        driver.get("https://allo.ua/");
    }

    public void acceptCookies() {

        try {

            WebElement acceptCookies = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(.,'Прийняти') or contains(.,'Accept')]")
                    )
            );

            acceptCookies.click();

        } catch (Exception e) {

            System.out.println("Cookies popup не появился");

        }
    }

    public void search(String text) {

        WebElement searchInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[contains(@placeholder,'Пошук') or @type='search' or @name='search']")
                )
        );

        searchInput.click();
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void waitForResults() {

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Apple iPhone 17')]")
                )
        );
    }

    public List<WebElement> getProductCards() {

        return driver.findElements(
                By.xpath("//*[.//*[contains(text(),'Apple iPhone 17')] and .//*[contains(text(),'₴')]]")
        );
    }
}