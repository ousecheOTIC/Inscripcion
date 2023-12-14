package MatrizRegresionn;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public  class Login {
    private String url = "https://sucursalvirtual-qa.ccc.cl/login";
    static WebDriver driver;


    @BeforeTest
    public void paginaSucursalVirtual() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\src\\main\\resources\\drivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
    }


    String Usuario = "265589014";//265589014 --116088134
    String Contraseña = "Oticcc2023";//Oticcc2023 --1160

    String ContraseñaIncorrecta ="1235";

    @Test (priority = 1)
    public void loginIncorrecto ()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Valido que Aparezca mensaje "Hola!"
        By css = By.cssSelector("#root > div > div > div.ant-col.form-section.ant-col-xs-24.ant-col-md-12 > main > div > h2");
        WebElement cssHola = driver.findElement(css);
        String msjHola = cssHola.getText();
        System.out.println(msjHola.equals("¡Hola!"));

        //CREDENCIALES
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/form/div[4]/div/div/div/button"));


        //PASAMOS LOS USUARIOS
        usernameInput.sendKeys(Usuario);
        passwordInput.sendKeys(ContraseñaIncorrecta);
        //BOTON  INGRESAR
        loginBtn.click();

        //Validamos mensade de error
        WebElement btnEntendido = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div/button")));
        WebElement msjError = driver.findElement(By.xpath("//*[@id=\"rcDialogTitle0\"]/h4/strong"));
        String txtmsjError = msjError.getText();

        //Vemos si está el mensaje de error
        if (msjError.isDisplayed()){
            System.out.println("Aparece mensaje: "+ txtmsjError);
            btnEntendido.click();
        }else {
            System.out.println("No aparece mensade de error");
        }

    }


    @Test(priority = 2)
    public void login() throws InterruptedException {
        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Valido que Aparezca mensaje "Hola!"
        WebElement msjHola = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/h2")));
        String TxtmsjHola = msjHola.getText();
        System.out.println(TxtmsjHola.equals("¡Hola!"));



        //CREDENCIALES
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/form/div[4]/div/div/div/button"));

        //PASAMOS LOS USUARIOS
        usernameInput.clear();
        usernameInput.sendKeys(Usuario);
        passwordInput.clear();
        passwordInput.sendKeys(Contraseña);
        //BOTON  INGRESAR
        loginBtn.click();



        //1. Se debe indicar el mensaje de bienvenida al usuario que realiza login.
        WebElement msj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div > div > section > main > div > main > div > div.ant-col.ant-col-24")));
        String msjBienvenida = msj.getText();
        if (msj.isDisplayed()) {
            System.out.printf(msjBienvenida);
        }else {
            System.out.printf("No aparece mensaje");;
        }
    }






    @Test(priority = 3)
    public void AccesoIntegraNegocio() throws InterruptedException {
        //TODO: hacer una lista de elementos con esta clase "xs-24" que es la que tiene todas las tarjetas y poder controlar que filtre por nombre de Integra negocio
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //DASHBOARD
        //Ingresar a la tarjeta Integra Negocios
        WebElement btnIntegraNegocio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/section/main/div/main/div/div[13]/div/div/div/button")));
        btnIntegraNegocio.click();
        /*
        String opcionASeleccionar = "Integra Negocio";
        WebElement btnIntegraNegocio = driver.findElement(By.xpath("//div[text()='" + opcionASeleccionar + "']"));//Busco la opcion que quiero
        btnIntegraNegocio.click();
        */
        //Cambiamos de pantalla
        String mainTab = driver.getWindowHandle();
        String newTab = "";

        //System.out.println("Main tab: " + mainTab);

        //driver.findElement(By.cssSelector("#single-spa-application\\:\\@CCC\\/dashboard > div > div.fixed.top-0.left-0.right-0.h-0.z-10 > div.relative.float-right.h-20.mt-7 > div > div.relative.ml-9 > div > div > span"));

        Set<String> handles = driver.getWindowHandles();


        for (String actual : handles) {
            //System.out.println(" --Handles ID: " + actual);

            if (!actual.equalsIgnoreCase(mainTab)) {
                //System.out.println(" -- Cambiando tab");
                driver.switchTo().window(actual);
                newTab = actual;
            }
        }

        System.out.println("Cambiamos a Integra Negocios");
        Thread.sleep(5000);


    }

    //TODO Validar por que viene la variable del nombre vacia
    @Test(priority = 4)

    public void mensajeBienvenida() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //WebElement ventanaNueva = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(By.xpath("//span[text()='Tipo de Curso']")")));
        WebElement ventanaNueva = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[1]/div[2]/div/div[1]/div/div/span"))));
        String msjNuevaVentana = ventanaNueva.getText();
        System.out.println(ventanaNueva);
        if (msjNuevaVentana.isEmpty()) {
            System.out.println("Variable viene vacia");
            System.out.println(": "+msjNuevaVentana);
        } else{
            System.out.println("El usuario es: " + msjNuevaVentana);

        }
    }

    @AfterTest
    public void close () throws InterruptedException {
        //driver.close();
        driver.quit();
        driver.quit();
    }
}