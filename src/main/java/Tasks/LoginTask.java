package Tasks;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Model.Conta;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Validacao.LoginValidacao;

public class LoginTask {

    private final WebDriver driver;
    private final LoginPage loginPage;
    private final HomePage homePage;
    private final LoginValidacao loginValidacao;

    public LoginTask(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginValidacao = new LoginValidacao(driver);
    }

    private void clicarJS(WebElement elemento) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }

    public void efetuarLogin(Conta conta) {
        loginPage.getEmailInput().sendKeys(conta.email);
        loginPage.getPasswordInput().sendKeys(conta.senha);
        clicarJS(loginPage.getAcessarButton());
        loginValidacao.validaHome(conta.nome);
    }

    public void sair() {
        clicarJS(homePage.getSairButton());
        loginValidacao.loginValidation();
    }
}