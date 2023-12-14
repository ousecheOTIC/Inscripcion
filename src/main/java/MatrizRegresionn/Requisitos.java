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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement validados = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#single-spa-application\\:\\@CCC\\/inscriptions > div > div.sc-bcXHqe.dqlVec > div > div.mx-auto > section > div.w-8\\/12 > div > div:nth-child(4) > h1")));

        if (validados.isDisplayed()) {
            System.out.println("Hay documento validados");
        }else {
            System.out.println("No hay documentos validados");
        }


    }







    @AfterTest
    public void close () throws InterruptedException {
        //driver.close();
        driver.quit();
        driver.quit();
    }
}
