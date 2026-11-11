package Framework.Utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class TakeScreenshot {

    //Tira print da tela e anexa ao relatorio do Allure
    public static void screenshotPage(WebDriver driver, String nome) {
        try {
            byte[] img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(nome, "image/png", new ByteArrayInputStream(img), "png");
        } catch (Exception e) {
            System.out.println("Nao foi possivel tirar screenshot: " + nome);
        }
    }
}
