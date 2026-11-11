package Validacao;

import Framework.Utils.Formato;
import Framework.Utils.TakeScreenshot;
import PageObjects.ExtratoPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class ExtratoValidacao {

    private final WebDriver driver;
    private final ExtratoPage extratoPage;

    public ExtratoValidacao(WebDriver driver) {
        this.driver = driver;
        extratoPage = new ExtratoPage(driver);
    }

    public void validaSaldo(BigDecimal esperado, String evidencia) {
        try {
            BigDecimal atual = Formato.extrairValor(extratoPage.getSaldoDisponivel().getText());
            Assertions.assertEquals(0, esperado.compareTo(atual),
                    "Saldo esperado " + esperado + " mas foi " + atual);
            TakeScreenshot.screenshotPage(driver, evidencia);
        } catch (Exception e) {
            TakeScreenshot.screenshotPage(driver, evidencia);
            throw e;
        }
    }

    // Confere se a transacao (valor formatado em R$) aparece no extrato
    public void validaTransacao(BigDecimal valor, String evidencia) {
        try {
            String corpo = extratoPage.getCorpoExtrato().getText();
            Assertions.assertTrue(corpo.contains(Formato.paraBR(valor)),
                    "Valor " + Formato.paraBR(valor) + " nao encontrado no extrato");
            TakeScreenshot.screenshotPage(driver, evidencia);
        } catch (Exception e) {
            TakeScreenshot.screenshotPage(driver, evidencia);
            throw e;
        }
    }
}
