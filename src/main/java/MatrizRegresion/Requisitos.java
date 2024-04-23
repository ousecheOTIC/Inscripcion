package MatrizRegresion;

import Login.Login_Positivos;
import VerDetalle.VerDetalle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Requisitos extends VerDetalle {
    static WebDriverWait wait = Login_Positivos.wait;
    static WebDriver driver = Login_Positivos.driver;

    @Test(priority = 25)
    public void RequisitosValidados ()throws InterruptedException{
        wait =  new WebDriverWait(driver, 4000);

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
