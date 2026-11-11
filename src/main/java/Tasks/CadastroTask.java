package Tasks;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.Browser.Waits;
import Framework.Utils.FakersGeneration;
import Model.Conta;
import PageObjects.CadastroPage;
import PageObjects.LoginPage;
import Validacao.CadastroValidacao;

public class CadastroTask {

    private final WebDriver driver;
    private final LoginPage loginPage;
    private final CadastroPage cadastroPage;
    private final CadastroValidacao cadastroValidacao;
    private final FakersGeneration faker;
    private final Waits waits;

    public CadastroTask(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        cadastroValidacao = new CadastroValidacao(driver);
        faker = new FakersGeneration();
        waits = new Waits(driver);
    }

    // Clique via JavaScript: evita "element click intercepted" causado por animacoes/overlays
    private void clicarJS(WebElement elemento) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }

    // Cadastra uma conta COM saldo e devolve os dados (inclusive numero/digito gerados pelo sistema)
    public Conta cadastrarContaComSaldo() {

        Conta conta = new Conta();
        conta.nome = faker.getNome();
        conta.email = faker.getEmail();
        conta.senha = faker.getSenha();
        conta.saldo = new BigDecimal("1000.00");

        // recarrega a pagina: formulario limpo e toggle desligado a cada cadastro
        driver.navigate().refresh();

        clicarJS(loginPage.getRegistrarButton());
        cadastroPage.getEmailInput().sendKeys(conta.email);
        cadastroPage.getNomeInput().sendKeys(conta.nome);
        cadastroPage.getSenhaInput().sendKeys(conta.senha);
        cadastroPage.getConfirmacaoSenhaInput().sendKeys(conta.senha);
        clicarJS(cadastroPage.getCriarComSaldoToggle());
        clicarJS(cadastroPage.getCadastrarButton());

        cadastroValidacao.validaContaCriada();

        String texto = cadastroPage.getModalTexto().getText();
        Matcher m = Pattern.compile("(\\d+)-(\\d)").matcher(texto);
        if (!m.find()) {
            throw new IllegalStateException("Numero da conta nao encontrado em: " + texto);
        }
        conta.numero = m.group(1);
        conta.digito = m.group(2);

        clicarJS(cadastroPage.getModalFecharButton());
        waits.invisibilityOfElement(By.id("modalText"));
        clicarJS(cadastroPage.getVoltarLoginLink());
        waits.loadElement(loginPage.getAcessarButton());
        return conta;
    }
}