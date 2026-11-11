package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtratoPage {

    private final Waits waits;

    public ExtratoPage(WebDriver driver) {
        waits = new Waits(driver);
    }

    public WebElement getSaldoDisponivel() {
        return waits.visbilityOfElement(By.id("textBalanceAvailable"));
    }

    // Todo o conteudo do extrato (lista de transacoes)
    public WebElement getCorpoExtrato() {
        return waits.visbilityOfElement(By.tagName("body"));
    }

    public WebElement getVoltarButton() {
        return waits.visbilityOfElement(By.id("btnBack"));
    }
}
