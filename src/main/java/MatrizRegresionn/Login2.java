package MatrizRegresionn;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Login2 {
    static WebDriver driver;
    private static WebDriverWait wait;
    ExtentReports extent;
    private ExtentTest test;
    private String folderName;
    String Usuario = "";
    String Contraseña = "";
    String ContraseñaIncorrecta = "1235";
    int numeroLinea = 0;

    public static String rutaArchivo = "C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\DATOS PARA PRUEBAS.txt";// Ruta del archivo que contiene las credenciales
    @BeforeTest
    //Inicializamos Driver y URL del ambiente de prueba
    public void paginaSucursalVirtual() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\src\\main\\resources\\drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver (2).exe");
                                                     //C:\Users\ouseche\OneDrive - OTIC CChC\Escritorio\Automatización\probando\src\main\resources\drivers\           chromedriver-win64\chromedriver-win64
        //TODO: Colocar el webdriver en carpeta compartida

        driver = new ChromeDriver();
        //TODO: Colocar otros driver de navegadores diferentes
        String url = "https://sucursalvirtualv2-qa.ccc.cl/login";
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

    /*@Test(priority = 1)
    //Está comentado para no bloquear usuario
    public void loginIncorrecto() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement msjHola =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/login\"]/div/div/div[3]/div/div/main/p[1]")));
        String TxtmsjHola = msjHola.getText();
        System.out.println(TxtmsjHola.equals("¡Bienvenido a nuestra Sucursal Virtual!"));

        //CREDENCIALES
        WebElement usernameInput = driver.findElement(By.className("jxrMZn"));
        WebElement passwordInput = driver.findElement(By.className("gBiohV"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/login\"]/div/div/div[3]/div/div/footer/button"));

        //PASAMOS LOS USUARIOS INCORRECTOS
        usernameInput.sendKeys(Usuario);
        passwordInput.sendKeys(ContraseñaIncorrecta);
        //BOTON  INGRESAR
        loginBtn.click();

        //Validamos mensade de error
        WebElement btnEntendido = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[6]/button[3]")));
        WebElement msjError = driver.findElement(By.xpath("//*[@id=\"swal2-title\"]"));
        String txtmsjError = msjError.getText();

        //Vemos si está el mensaje de error
        if (msjError.isDisplayed()){
            System.out.println("Aparece mensaje: "+ txtmsjError);
            btnEntendido.click();
        }else {
            System.out.println("No aparece mensade de error");
        }

    }*/

    @Test(priority = 2)
    //Login usuario
    public void login() throws InterruptedException, IOException {

        try {
            wait =  new WebDriverWait(driver, 20);

        //Valido que Aparezca mensaje "¡Bienvenido a nuestra Sucursal Virtual!"
        WebElement msjHola = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/login\"]/div/div/div[3]/div/div/main/p[1]")));
        String TxtmsjHola = msjHola.getText();
        System.out.println(TxtmsjHola.equals("¡Bienvenido a nuestra Sucursal Virtual!"));

        //NOMBRE DE LA URL
        String nombreURL= driver.getCurrentUrl();
            System.out.println(nombreURL);

        //CREDENCIALES
        WebElement usernameInput = driver.findElement(By.className("jxrMZn"));
        WebElement passwordInput = driver.findElement(By.className("gBiohV"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/login\"]/div/div/div[3]/div/div/footer/button"));



        Usuario = extraerDatosDeLinea(rutaArchivo, 2);
        Contraseña = extraerDatosDeLinea(rutaArchivo, 3);


            //PASAMOS LOS USUARIOS
            usernameInput.clear();
            usernameInput.sendKeys(Usuario);
            passwordInput.clear();
            passwordInput.sendKeys(Contraseña);





        capturarYAdjuntarCaptura("Captura_Login");//Captura de pantalla

        //BOTON  INGRESAR
        loginBtn.click();


        //1. Se debe indicar el mensaje de bienvenida al usuario que realiza login.
        WebElement msj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Bienvenido')]"))); //QA2

            String msjBienvenida = msj.getText();
        if (msj.isDisplayed()) {
            System.out.printf(msjBienvenida);

        } else {
            System.out.printf("No aparece mensaje");
            ;
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void mensajeBienvenida() throws InterruptedException, IOException {
        WebElement usuario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/home\"]/div/div[1]/div/div/div[1]/div/div[1]/div/div/p")));
        String txtusuario = usuario.getText();//tomamos el nombre del usuario ingresado
        System.out.println(txtusuario);
        capturarYAdjuntarCaptura("Captura_MsjBienvenida");//Captura de pantalla

        WebElement segmento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/home\"]/div/div[1]/div/div/div[1]/div/div[1]/div/div/span")));
        String txtsegmento = usuario.getText();//tomamos el nombre del usuario ingresado
        System.out.println(txtsegmento);
    }

    @Test(priority =4)
    public void accesoIntegraNegocio()throws InterruptedException,IOException{
        //Llamamos el metodo para escoger la opcion deseada
        seleccionarMenuSV("Gestiona", "Inscripciones", "Administración de cursos");

    }

    private static void  seleccionarMenuSV(String tarjeta, String subTarjeta, String opcion) throws InterruptedException {

        //Esperamos que carguen las tarjetas
        WebElement tarjetasPresente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("XBzmv")));

        List <WebElement> menuGestiona = driver.findElements(By.className("XBzmv"));//fLrcbj - haOWZD
        //System.out.println(menuGestiona.size());//Mostramos la cantidad de tarjetas que aparezcan
        for (WebElement opcs : menuGestiona){
            System.out.println(opcs.getText());
            if (opcs.getText().toLowerCase().contains(tarjeta.toLowerCase())){
                WebElement btnGestiona = opcs.findElement(By.className("dZqoOK"));
                btnGestiona.click();//Boton tarjeta Gestiona
                //Hacemos una lista con opciones 1
                List<WebElement> opciones1 = driver.findElements(By.className("impacto-de"));
                // Iterar a través de los elementos
                for (WebElement clase : opciones1) {
                    System.out.println("-" + clase.getText());
                    if (clase.getText().trim().toLowerCase().equals(subTarjeta.toLowerCase())) {
                        //System.out.println("Entro al if");
                        wait.until(ExpectedConditions.elementToBeClickable(clase)).click();

                        //Buscamos la    subClase
                        //List<WebElement> opciones2 = opciones1.stream().filter(elemento -> elemento.getAttribute("class").contains("text-darkened")).collect(Collectors.toList());
                        List<WebElement> opciones2 = driver.findElements(By.className("frame-wrapper"));
                        for (WebElement subClase : opciones2) {
                            System.out.println("--" + subClase.getText());
                            if (subClase.getText().trim().toLowerCase().contains(opcion.toLowerCase())) {
                                System.out.println("Hacemos click en: "+subClase.getText());
                                subClase.click();
                                break;
                            } else {
                                System.out.println("No está entrando al segundo if");
                                break;
                            }
                        }
                        break;
                    } else {
                        System.out.println("No: " + clase.getText());
                    }
                    break;
                }
                //Validamos que nos llve a Integra Negocio
                break;
            }

        }
        //Thread.sleep(2000);//Espera necesaria para que carguen los dashboard
        //capturarYAdjuntarCaptura("Captura_IntegraNegocio");//Captura de pantalla

    }


    private void accesoInegraNogocio() throws InterruptedException {

    }

    void capturarYAdjuntarCaptura(String nombreCaptura) throws IOException {
        // Generar un nombre de archivo único para la captura de pantalla
        String fileName = folderName + "/" + nombreCaptura + ".png";

        // Tomar la captura de pantalla y guardarla en la carpeta actual
        FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
                new File(fileName));

        // Devolver la ruta completa del archivo de captura
        test.addScreenCaptureFromPath(fileName);
    }


    public static String extraerDatosDeLinea(String rutaArchivo, int numeroLinea) throws IOException {
        String lineaExtraida = null;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Iterar sobre las líneas hasta llegar a la línea deseada
            for (int i = 1; i <= numeroLinea; i++) {
                //System.out.println(lineaExtraida); //Si quiero saber que está iterando
                lineaExtraida = br.readLine();

                // Si llegamos al final del archivo antes de la línea deseada
                if (lineaExtraida == null) {
                    System.out.println("Número de línea solicitado excede el total de líneas en el archivo.");
                    return null;
                }
            }
        }

        // Dividir la línea por ":"
        String[] partes = lineaExtraida.split(":");

        // Verificar si hay al menos dos partes (antes y después de ":")
        if (partes.length >= 2) {
            // Devolver la segunda parte (datos después de ":") eliminando espacios en blanco adicionales
            return partes[1].trim();
        } else {
            System.out.println("La línea "+numeroLinea+" no contiene el formato esperado (no hay ':').");
            return null;
        }
    }

    @AfterMethod
    public void finalizarTest(ITestResult result) {
        // Finalizar el test en ExtentReports según el resultado
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "El test ha fallado: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "El test ha pasado");
        } else {
            test.log(Status.SKIP, "El test ha sido omitido");
        }
    }

    @AfterTest
    public void close () throws InterruptedException {
        //driver.close();
        driver.quit();
        driver.quit();
        //ReportManager.flushReport();

    }

}