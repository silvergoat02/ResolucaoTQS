package Tasks;

import java.math.BigDecimal;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.ExtratoPage;
import PageObjects.HomePage;
import Validacao.ExtratoValidacao;

public class ExtratoTask {

    private final WebDriver driver;
    private final HomePage homePage;
    private final ExtratoPage extratoPage;
    private final ExtratoValidacao extratoValidacao;

    public ExtratoTask(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        extratoPage = new ExtratoPage(driver);
        extratoValidacao = new ExtratoValidacao(driver);
    }

    private void clicarJS(WebElement elemento) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }

    public void validarExtrato(BigDecimal saldoEsperado, BigDecimal valorTransferido, String evidencia) {
        clicarJS(homePage.getExtratoButton());
        extratoValidacao.validaSaldo(saldoEsperado, "Saldo " + evidencia);
        extratoValidacao.validaTransacao(valorTransferido, "Transacao " + evidencia);
        clicarJS(extratoPage.getVoltarButton());
    }
}