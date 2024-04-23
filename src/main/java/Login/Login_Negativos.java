package Login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Login_Negativos {
    public static WebDriver driver;
    public static WebDriverWait wait;
    ExtentReports extent;
    public static ExtentTest test;
    public static String folderName;

    public static String rutaArchivo = "C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\DATOS PARA PRUEBAS.txt";// Ruta del archivo que contiene las credenciales

    @BeforeTest
    //Inicializamos Driver y URL del ambiente de prueba
    public void paginaSucursalVirtual() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\src\\main\\resources\\drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver (2).exe");
        //TODO: Colocar el webdriver en carpeta compartida

        driver = new ChromeDriver();
        //TODO: Colocar otros driver de navegadores diferentes
        String url = "https://sucursalvirtualv2-qa2.ccc.cl/login";
        driver.get(url);
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
    }

    @BeforeClass
    //Iniciamos Test para contabilizar el estado de cada prueba
    public void inicializarTest() {
        // Configuración del test actual en ExtentReports
        test = extent.createTest(getClass().getSimpleName());
    }

    @BeforeSuite
    //Inicializamos el reporte de pruebas
    public void inicializarReporte() {
        // Configuración del informe ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ReporteDePruebas.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // Generar un nombre de carpeta única para la captura de pantalla
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
        folderName = "C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\Evidencias\\Evidencia" + timeStamp;
        File folder = new File(folderName);
        folder.mkdir();


        //////////////////////////////////////////////////////
        // Inicializa el informe una sola vez (puede ir en un método de configuración o en una clase de configuración separada)
        //ReportManager.initializeReport("C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\informe.html");
    }

    @Test(priority = 1)
    @When("Me logeo con usuario erroneo {string} y con contraseña erronea {string}")
    //Está comentado para no bloquear usuario
    public void loginIncorrecto(String usuarioIncorrecto, String contraseñaIncorrecta) {
        wait =  new WebDriverWait(driver, 20);
        WebElement msjHola = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/login\"]/div/div/div[3]/div/div/main/p[1]")));
        String TxtmsjHola = msjHola.getText();
        System.out.println(TxtmsjHola.equals("¡Bienvenido a nuestra Sucursal Virtual!"));

        //CREDENCIALES
        WebElement usernameInput = driver.findElement(By.className("jxrMZn"));
        WebElement passwordInput = driver.findElement(By.className("gBiohV"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/login\"]/div/div/div[3]/div/div/footer/button"));

        //PASAMOS LOS USUARIOS INCORRECTOS
        usernameInput.sendKeys(usuarioIncorrecto);
        passwordInput.sendKeys(contraseñaIncorrecta);
        //BOTON  INGRESAR
        loginBtn.click();

        //Validamos mensade de error
        WebElement btnEntendido = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[6]/button[3]")));
        WebElement msjError = driver.findElement(By.xpath("//*[@id=\"swal2-title\"]"));
        String txtmsjError = msjError.getText();

        //Vemos si está el mensaje de error
        if (msjError.isDisplayed()) {
            System.out.println("Aparece mensaje: " + txtmsjError);
            btnEntendido.click();
        } else {
            System.out.println("No aparece mensade de error");
        }
    }
}
