package Validacao;

import Framework.Utils.TakeScreenshot;
import PageObjects.CadastroPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CadastroValidacao {

    private final WebDriver driver;
    private final CadastroPage cadastroPage;

    public CadastroValidacao(WebDriver driver) {
        this.driver = driver;
        cadastroPage = new CadastroPage(driver);
    }

    public void validaContaCriada() {
        try {
            String msg = cadastroPage.getModalTexto().getText();
            Assertions.assertTrue(msg.contains("criada com sucesso"), "Mensagem inesperada: " + msg);
            TakeScreenshot.screenshotPage(driver, "Conta criada");
        } catch (Exception e) {
            TakeScreenshot.screenshotPage(driver, "Conta criada");
            throw e;
        }
    }
}
