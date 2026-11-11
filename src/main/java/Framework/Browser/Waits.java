package Framework.Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private WebDriver driver;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    //Metodo usado para espera dentro das classes de pages, ou seja, na busca do elemento
    public WebElement visbilityOfElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Espera o elemento existir no DOM (mesmo oculto, ex.: checkbox de toggle)
    public WebElement presenceOfElement(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //Espera o elemento sumir (ex.: modal fechando)
    public void invisibilityOfElement(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //Metodo usado para espera dentro das classes de task, ou seja, entre uma ação e outra
    public WebElement loadElement(WebElement element) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e) {
            return element;
        }
    }
}
