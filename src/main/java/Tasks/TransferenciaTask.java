package Tasks;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.Browser.Waits;
import Model.Conta;
import PageObjects.HomePage;
import PageObjects.TransferenciaPage;
import Validacao.TransferenciaValidacao;

public class TransferenciaTask {

    private final WebDriver driver;
    private final HomePage homePage;
    private final TransferenciaPage transferenciaPage;
    private final TransferenciaValidacao transferenciaValidacao;
    private final Waits waits;

    public TransferenciaTask(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        transferenciaPage = new TransferenciaPage(driver);
        transferenciaValidacao = new TransferenciaValidacao(driver);
        waits = new Waits(driver);
    }

    private void clicarJS(WebElement elemento) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }

    public void transferir(Conta destino, BigDecimal valor) {
        clicarJS(homePage.getTransferenciaButton());
        transferenciaPage.getNumeroContaInput().sendKeys(destino.numero);
        transferenciaPage.getDigitoInput().sendKeys(destino.digito);
        transferenciaPage.getValorInput().sendKeys(valor.toPlainString());
        transferenciaPage.getDescricaoInput().sendKeys("Transferencia automatizada TQS");
        clicarJS(transferenciaPage.getTransferirButton());
        transferenciaValidacao.validaTransferenciaRealizada();
        clicarJS(transferenciaPage.getModalFecharButton());
        waits.invisibilityOfElement(By.id("modalText"));
        clicarJS(transferenciaPage.getVoltarButton());
    }
}