package MatrizRegresion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;
public class Login {
    private String url = "https://sucursalvirtual-qa.ccc.cl/login";
    private WebDriver driver;
    private WebDriverWait wait;

    public Login(WebDriverWait wait) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @BeforeTest
    public void paginaSucursalVirtual() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\src\\main\\resources\\drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {

        //Valido que Aparezca mensaje "Hola!"
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-col-24")));
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

    @Test(priority = 2)
    public void AccesoIntegraNegocio() throws InterruptedException {
        //DASHBOARD
        //Ingresar a la tarjeta Integra Negocios
        WebElement btnIntegraNegocio = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > div > div > section > main > div > main > div > div:nth-child(13) > div > div > div > button")));
        btnIntegraNegocio.click();

        //Cambiamos de pantalla
        String mainTab = driver.getWindowHandle();
        String newTab = "";

        System.out.println("Main tab: " + mainTab);

        //driver.findElement(By.cssSelector("#single-spa-application\\:\\@CCC\\/dashboard > div > div.fixed.top-0.left-0.right-0.h-0.z-10 > div.relative.float-right.h-20.mt-7 > div > div.relative.ml-9 > div > div > span"));

        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            System.out.println(" --Handles ID: " + actual);

            if (!actual.equalsIgnoreCase(mainTab)) {
                System.out.println(" -- Cambiando tab");
                driver.switchTo().window(actual);
                newTab = actual;
            }
        }

        System.out.println("Cambiamos a pantalla emergente");
        Thread.sleep(10000);
    }

    @Test(priority = 2)
    public void mensajeBienvenida ()throws InterruptedException{
        WebElement ventanaNueva = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#single-spa-application\\:\\@CCC\\/dashboard > div > div.fixed.top-0.left-0.right-0.h-0.z-10 > div.relative.float-right.h-20.mt-7 > div > div.relative.ml-9 > div > div > span")));
        String msjNuevaVentana = ventanaNueva.getText();
        System.out.println("El usuario es: " + msjNuevaVentana);

    }

    @AfterTest
    public void close () throws InterruptedException {
        //driver.close();
        driver.quit();
        driver.quit();
    }

}
