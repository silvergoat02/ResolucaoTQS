package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferenciaPage {

    private final Waits waits;

    public TransferenciaPage(WebDriver driver) {
        waits = new Waits(driver);
    }

    public WebElement getNumeroContaInput() {
        return waits.visbilityOfElement(By.name("accountNumber"));
    }

    public WebElement getDigitoInput() {
        return waits.visbilityOfElement(By.name("digit"));
    }

    public WebElement getValorInput() {
        return waits.visbilityOfElement(By.name("transferValue"));
    }

    public WebElement getDescricaoInput() {
        return waits.visbilityOfElement(By.name("description"));
    }

    public WebElement getTransferirButton() {
        return waits.visbilityOfElement(By.xpath("//button[normalize-space()='Transferir agora']"));
    }

    public WebElement getModalTexto() {
        return waits.visbilityOfElement(By.id("modalText"));
    }

    public WebElement getModalFecharButton() {
        return waits.visbilityOfElement(By.id("btnCloseModal"));
    }

    public WebElement getVoltarButton() {
        return waits.visbilityOfElement(By.id("btnBack"));
    }
}
