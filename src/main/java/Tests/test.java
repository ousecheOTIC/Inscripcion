package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class test {
    @Test
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\src\\main\\resources\\drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Ingresamos a la paguina de la OTIC
        driver.get("https://sucursalvirtual-qa.ccc.cl/login");

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-component")));
        By css = By.cssSelector("#root > div > div > div.ant-col.form-section.ant-col-xs-24.ant-col-md-12 > main > div > h2");
        WebElement cssHola = driver.findElement(css );
        String msjHola = cssHola.getText();
        System.out.println(msjHola.equals("¡Hola!"));

        //CREDENCIALES
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/form/div[4]/div/div/div/button"));


        //PASAMOS LOS USUARIOS
        usernameInput.sendKeys("265589014");
        passwordInput.sendKeys("1234");
        //BOTON  INGRESAR
        loginBtn.click();


        //INICIO
        //String username = "Oscar Useche";
        WebElement strongElement = driver.findElement(By.className("ant-col"));

        // Obtener el texto del elemento
        String username = strongElement.getText();
        System.out.println("Este es el mensaje: "+username);


        // Texto que deseas comparar
        String textoDeseado = "Hola Oscar Useche, ¿qué necesitas?";

        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-col")));


        // Comparar el texto del elemento con el texto deseado
        if (username.equals(textoDeseado)) {
            System.out.println("El texto del elemento coincide con el texto deseado.");
        } else {
            System.out.println("El texto del elemento NO coincide con el texto deseado.");
        }


        //Login - Acceso a Integra Negocio
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/section/main/div/main/div/div[13]/div/div/div/button"))).click();




        driver.close();
        //driver.quit();
    }
}