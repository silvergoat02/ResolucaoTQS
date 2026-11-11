package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final Waits waits;

    public LoginPage(WebDriver driver) {
        waits = new Waits(driver);
    }

    public WebElement getEmailInput() {
        return waits.visbilityOfElement(By.cssSelector(".card__login input[name='email']"));
    }

    public WebElement getPasswordInput() {
        return waits.visbilityOfElement(By.cssSelector(".card__login input[name='password']"));
    }

    public WebElement getAcessarButton() {
        return waits.visbilityOfElement(By.xpath("//div[contains(@class,'card__login')]//button[normalize-space()='Acessar']"));
    }

    public WebElement getRegistrarButton() {
        return waits.visbilityOfElement(By.xpath("//div[contains(@class,'card__login')]//button[normalize-space()='Registrar']"));
    }
}
