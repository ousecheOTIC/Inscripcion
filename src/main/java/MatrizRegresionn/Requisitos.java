package MatrizRegresionn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Requisitos extends VerDetalle{
    @Test(priority = 25)
    public void RequisitosValidados ()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        /*WebElement validados = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/section/div[3]/div/div[4]/h1")));

        if (validados.isDisplayed()) {
            System.out.println("Hay documento validados");
        }else {
            System.out.println("No hay documentos validados");

        }*/


    }



    @AfterTest
    public void close () throws InterruptedException {
        //driver.close();
        driver.quit();
        driver.quit();
    }
}
