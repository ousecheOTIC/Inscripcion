package MatrizRegresion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Filtros {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\src\\main\\resources\\drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Ingresamos a la paguina de la OTIC
        driver.get("https://sucursalvirtual-qa.ccc.cl/login");

        driver.manage().window().maximize();
        long timeoutInSeconds = Duration.ofSeconds(20).toMillis();
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-component")));
        By css = By.cssSelector("#root > div > div > div.ant-col.form-section.ant-col-xs-24.ant-col-md-12 > main > div > h2");
        WebElement cssHola = driver.findElement(css);
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
    }

}
