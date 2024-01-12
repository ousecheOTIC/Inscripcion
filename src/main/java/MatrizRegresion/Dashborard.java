package MatrizRegresion;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Set;


public class Dashborard {
    static WebDriver driver = new ChromeDriver();


    @BeforeClass
    public static void main(String[] args)throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\src\\main\\resources\\drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Ingresamos a la paguina de la OTIC
        driver.get("https://sucursalvirtual-qa.ccc.cl/login");

        //driver.manage().window().maximize();
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

        //PRUEBA
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/section/main/div/div/div[2]/div[1]"))).click();
        //WebElement prueba = driver.findElement(By.tagName("right-section"));
        //String btnprueba = prueba.getText();
        //System.out.println("El texto es: "+btnprueba);


        //DASHBOARD
        //Ingresar a la tarjeta Integra Negocios
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/section/main/div/main/div/div[13]/div/div/div/button"))).click();

        //Cambiamos de pantalla
        String mainTab = driver.getWindowHandle();
        String newTab ="";

        System.out.println("Main tab: "+mainTab);

        driver.findElement(By.cssSelector("#single-spa-application\\:\\@CCC\\/dashboard > div > div.fixed.top-0.left-0.right-0.h-0.z-10 > div.relative.float-right.h-20.mt-7 > div > div.relative.ml-9 > div > div > span"));

        Set<String> handles = driver.getWindowHandles();

        for (String actual: handles){
            System.out.println(" --Handles ID: "+ actual);

            if (!actual.equalsIgnoreCase(mainTab)){
                System.out.println(" -- Cambiando tab");
                driver.switchTo().window(actual);
                newTab=actual;
            }
        }

        /*
        //Visualizar el sistema Integra Negocio
        String parentWindowHandler = driver.getWindowHandle(); // Almacena tu ventana actual
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // Obten todas las ventana abiertas
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // Cámbiate a la ultima ventana (tu pop-up)

        System.out.println("Cambiamos a pantalla emergente");
        */


        //Validamos Nombre de usuario
        WebElement ventanaNueva = driver.findElement(By.cssSelector("#single-spa-application\\:\\@CCC\\/dashboard > div > div.fixed.top-0.left-0.right-0.h-0.z-10 > div.relative.float-right.h-20.mt-7 > div > div.relative.ml-9 > div > div > span"));
        String msjNuevaVentana = ventanaNueva.getText();
        System.out.println("El usuario es: "+msjNuevaVentana);

        if (ventanaNueva.isDisplayed()) {
            System.out.println("Sí veo el botón.");
        } else {
            System.out.println("No veo el botón.");
        }
        //Validamos segmento de usuario
        WebElement segmentoUser = driver.findElement(By.cssSelector("#single-spa-application\\:\\@CCC\\/dashboard > div > div.fixed.top-0.left-0.right-0.h-0.z-10 > div.relative.float-right.h-20.mt-7 > div > div.relative.ml-9 > div > div > span"));
        String segmento = segmentoUser.getText();
        System.out.println("El segmento es: "+segmento);

        if (ventanaNueva.isDisplayed()) {
            System.out.println("Sí veo el botón.");
        } else {
            System.out.println("No veo el botón.");
        }

        //Validamos boton de configuración
        boolean btnconfig = true;
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loading")));



        if (segmento == "Administrador"){
            System.out.println("Perfil autorizado para usar boton de configuracion");
        }
        else {
            btnconfig=false;
            System.out.println("Perfil no autorizado para usar boton de configuracion");
        }

        //Caso 7
        //Al pulsar el botón "Sucuarsal Virtual" se debe volver directamente a la sucusal virtual
        WebElement btnSucursalVirtal = driver.findElement(By.cssSelector("button.rounded-full[type='button']"));
        btnSucursalVirtal.click();


        if (btnSucursalVirtal.isDisplayed()){
            btnSucursalVirtal.click();
            btnSucursalVirtal.click();
            System.out.println("Presionamos boton sucursal virtual");
        }else {
            System.out.println("No presionamos boton sucursal virtual");
        }


    }


    }










/*
    @Test
    public void Prueba2()throws InterruptedException {
        //DASHBOARD
        //Ingresar a la tarjeta Integra Negocios
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/section/main/div/main/div/div[13]/div/div/div/button"))).click();

        //Visualizar el sistema Integra Negocio
        String parentWindowHandler = driver.getWindowHandle(); // Almacena tu ventana actual
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // Obten todas las ventana abiertas
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // Cámbiate a la ultima ventana (tu pop-up)

        System.out.println("Cambiamos a pantalla emergente");

    }
    @Test
    public void Prueba3()throws InterruptedException {
        //DASHBOARD
        //Ingresar a la tarjeta Integra Negocios
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/section/main/div/main/div/div[13]/div/div/div/button"))).click();

        //Visualizar el sistema Integra Negocio
        String parentWindowHandler = driver.getWindowHandle(); // Almacena tu ventana actual
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // Obten todas las ventana abiertas
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // Cámbiate a la ultima ventana (tu pop-up)

        System.out.println("Cambiamos a pantalla emergente");

        //Validamos Nombre de usuario
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#single-spa-application\\:\\@CCC\\/dashboard > div > div.fixed.top-0.left-0.right-0.h-0.z-10 > div.relative.float-right.h-20.mt-7 > div > div.relative.ml-9 > div > div > span")));
        WebElement ventanaNueva = driver.findElement(By.cssSelector("#single-spa-application\\:\\@CCC\\/dashboard > div > div.fixed.top-0.left-0.right-0.h-0.z-10 > div.relative.float-right.h-20.mt-7 > div > div.relative.ml-9 > div > div > span"));
        String msjNuevaVentana = ventanaNueva.getText();
        System.out.println("El usuario es: "+msjNuevaVentana);

        if (ventanaNueva.isDisplayed()) {
            System.out.println("Sí veo el botón.");
        } else {
            System.out.println("No veo el botón.");
        }
        //Validamos segmento de usuario
        WebElement segmentoUser = driver.findElement(By.cssSelector("#single-spa-application\\:\\@CCC\\/dashboard > div > div.fixed.top-0.left-0.right-0.h-0.z-10 > div.relative.float-right.h-20.mt-7 > div > div.relative.ml-9 > div > div > span"));
        String segmento = segmentoUser.getText();
        System.out.println("El segmento es: "+segmento);

        if (ventanaNueva.isDisplayed()) {
            System.out.println("Sí veo el botón.");
        } else {
            System.out.println("No veo el botón.");
        }

    }
    @AfterClass
    public static void setDownClass() {
        driver.quit();
    }*/

