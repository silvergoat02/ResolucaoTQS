package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroPage {

    private final Waits waits;

    public CadastroPage(WebDriver driver) {
        waits = new Waits(driver);
    }

    public WebElement getEmailInput() {
        return waits.visbilityOfElement(By.cssSelector(".card__register input[name='email']"));
    }

    public WebElement getNomeInput() {
        return waits.visbilityOfElement(By.cssSelector(".card__register input[name='name']"));
    }

    public WebElement getSenhaInput() {
        return waits.visbilityOfElement(By.cssSelector(".card__register input[name='password']"));
    }

    public WebElement getConfirmacaoSenhaInput() {
        return waits.visbilityOfElement(By.cssSelector(".card__register input[name='passwordConfirmation']"));
    }

    // o input do toggle fica oculto (so o slider aparece), entao so exige presenca no DOM
    public WebElement getCriarComSaldoToggle() {
        return waits.presenceOfElement(By.id("toggleAddBalance"));
    }

    public WebElement getCadastrarButton() {
        return waits.visbilityOfElement(By.xpath("//button[normalize-space()='Cadastrar']"));
    }

    public WebElement getVoltarLoginLink() {
        return waits.visbilityOfElement(By.xpath("//a[normalize-space()='Voltar ao login']"));
    }

    public WebElement getModalTexto() {
        return waits.visbilityOfElement(By.id("modalText"));
    }

    public WebElement getModalFecharButton() {
        return waits.visbilityOfElement(By.id("btnCloseModal"));
    }
}
