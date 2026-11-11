package Validacao;

import Framework.Utils.TakeScreenshot;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginValidacao {

    private final WebDriver driver;
    private final LoginPage loginPage;
    private final HomePage homePage;

    public LoginValidacao(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public void loginValidation() {
        try {
            Assertions.assertTrue(loginPage.getAcessarButton().isDisplayed());
            TakeScreenshot.screenshotPage(driver, "Login");
        } catch (Exception e) {
            TakeScreenshot.screenshotPage(driver, "Login");
            throw e;
        }
    }

    public void validaHome(String nome) {
        try {
            String texto = homePage.getTextoBoasVindas().getText();
            Assertions.assertTrue(texto.contains(nome), "Boas-vindas inesperada: " + texto);
            TakeScreenshot.screenshotPage(driver, "Home " + nome);
        } catch (Exception e) {
            TakeScreenshot.screenshotPage(driver, "Home " + nome);
            throw e;
        }
    }
}
