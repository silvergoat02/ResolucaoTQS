package Validacao;

import Framework.Utils.TakeScreenshot;
import PageObjects.TransferenciaPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class TransferenciaValidacao {

    private final WebDriver driver;
    private final TransferenciaPage transferenciaPage;

    public TransferenciaValidacao(WebDriver driver) {
        this.driver = driver;
        transferenciaPage = new TransferenciaPage(driver);
    }

    public void validaTransferenciaRealizada() {
        try {
            String msg = transferenciaPage.getModalTexto().getText();
            Assertions.assertTrue(msg.toLowerCase().contains("sucesso"), "Mensagem inesperada: " + msg);
            TakeScreenshot.screenshotPage(driver, "Transferencia");
        } catch (Exception e) {
            TakeScreenshot.screenshotPage(driver, "Transferencia");
            throw e;
        }
    }
}
