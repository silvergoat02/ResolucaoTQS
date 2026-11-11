package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final Waits waits;

    public HomePage(WebDriver driver) {
        waits = new Waits(driver);
    }

    public WebElement getTextoBoasVindas() {
        return waits.visbilityOfElement(By.id("textName"));
    }

    public WebElement getTextoSaldo() {
        return waits.visbilityOfElement(By.id("textBalance"));
    }

    public WebElement getTextoConta() {
        return waits.visbilityOfElement(By.id("textAccountNumber"));
    }

    public WebElement getTransferenciaButton() {
        return waits.visbilityOfElement(By.id("btn-TRANSFERÊNCIA"));
    }

    public WebElement getExtratoButton() {
        return waits.visbilityOfElement(By.id("btn-EXTRATO"));
    }

    public WebElement getSairButton() {
        return waits.visbilityOfElement(By.id("btnExit"));
    }
}
