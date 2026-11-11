package TestCases;

import Framework.TestBase;
import Framework.Utils.FileOperations;
import Framework.Utils.TakeScreenshot;
import Model.Conta;
import Tasks.CadastroTask;
import Tasks.ExtratoTask;
import Tasks.LoginTask;
import Tasks.TransferenciaTask;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

@Epic("Teste BugBank")
@Feature("Transferencia entre contas")
public class TransferenciaBancariaTest extends TestBase {

    private final WebDriver driver = getDriverManager();

    CadastroTask cadastroTask = new CadastroTask(driver);
    LoginTask loginTask = new LoginTask(driver);
    TransferenciaTask transferenciaTask = new TransferenciaTask(driver);
    ExtratoTask extratoTask = new ExtratoTask(driver);

    @Test
    @Story("Transferir valor entre duas contas com saldo e validar os extratos")
    @Description("Cria duas contas com saldo, transfere da conta A para a B e valida saldo/extrato das duas")
    public void realizarTransferencia() {

        try {
            BigDecimal valor = new BigDecimal(FileOperations.getProperties("dados").getProperty("valorTransferencia"));

            // 1) Cadastro das duas contas com saldo
            Conta origem = cadastroTask.cadastrarContaComSaldo();
            Conta destino = cadastroTask.cadastrarContaComSaldo();

            // 2) Login na conta origem e transferencia
            loginTask.efetuarLogin(origem);
            transferenciaTask.transferir(destino, valor);

            // 3) Extrato da origem: saldo = inicial - valor
            extratoTask.validarExtrato(origem.saldo.subtract(valor), valor, "origem");
            loginTask.sair();

            // 4) Login no destino e validacao do recebimento: saldo = inicial + valor
            loginTask.efetuarLogin(destino);
            extratoTask.validarExtrato(destino.saldo.add(valor), valor, "destino");
            loginTask.sair();

        } catch (Exception e) {
            TakeScreenshot.screenshotPage(driver, "ERRO");
            throw e;
        }
    }
}
