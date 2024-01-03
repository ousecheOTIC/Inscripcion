package MatrizRegresionn;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List ;

public class Inscripciones extends Login2 {//Hago la extension de login para hacer la prueba más rapido
    private static final Logger log = LoggerFactory.getLogger(Inscripciones.class) ;
    private static WebDriverWait wait;
    private ExtentReports extent;
    private ExtentTest test;
    private String folderName ;
    String ingresoLetras = "123801hola";
    String ingresoNumeros = "3718";
    String valorAcordadoMaximo = "123456789123456";
    public WebElement barraCodigo;
    public WebElement btnValidar;

    public WebElement btnBorrarCodigo;

    ///////////////////// DATOS PARA PRUEBAS
    String NombreCliente = "SODIMAC ";
    String RutCliente = "96792430-k";
    String sucursal = "Casa Matriz";
    String codigoSence = "1238044124"; //1238013718-- 1238019176 -- 1238017721
    String valorAcordado ="600.000";
    String fechaInicio = "22/12";
    String fechaTermino = "25/12";
    String rutClienteFinanciamiento= "264483148";
    public static String numeroSolicitudDeCompra;

    int ConteoCantidadParticipantes = 0;
    List <WebElement> cantidadParticipantes = null;
    String tipoCuentaCapacitacion = "Capacitacion";


    //Me quedé pegadooooo
    //open
/*
    @Test (priority = 32)
    public void VisualizacionAccionMenuExpandible ()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Ocultar menu del lado izquierdo
        Thread.sleep(5000);
        WebElement btnMinimizarMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hQWSJn")));

        WebElement menuDesplegado = driver.findElement(By.xpath("//div[@class='col-span-3 grid grid-cols-3 gap-[1.75rem]']"));

        if (menuDesplegado.isDisplayed()){
            System.out.println("Veo el menu");

        }else{
            System.out.println("Menú Plegado");
        }
        Thread.sleep(3000);
        btnMinimizarMenu.click();
        Thread.sleep(3000);
        WebElement menuPlegado = wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("hGRmzP"))));

        if (menuDesplegado.isEnabled()){
            System.out.println("Veo el menu");

        }else if (menuPlegado.isDisplayed()){
            System.out.println("Menú Plegado");
        }
        Thread.sleep(3000);



    }
*/
    @Test(priority = 33)
    public void MenuInscripciones() throws InterruptedException {
        // Iniciar el informe para el caso de prueba actual
        extent = new ExtentReports();

        this.test = extent.createTest("TestCase2");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String urlactual = driver.getCurrentUrl();
        //Hacemos que presione boton independiente de donde esté parado
        if (urlactual.contains("dashboard")) {
            //Presionamos menú inscripciones
            WebElement menuInscripciones = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[2]/div/div/div/ul[1]/li[3]/button")));
            menuInscripciones.click();

        } else if (urlactual.contains("inscriptions")) {
            WebElement btn = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[2]/div/div/div/ul[1]/li[3]/button"));
            System.out.println("Estamos en link de Inscripciones");
            btn.click();
        }

        //Validamos el texto de bienvenida
        String MensajeInicial = "¿Necesitas inscribir o continuar una inscripción?";
        WebElement msjInicialInscripciones = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/h1")));
        String txtMsjInicialInscripciones = msjInicialInscripciones.getText();

        if (txtMsjInicialInscripciones.equals(MensajeInicial)) {
            System.out.println("Mensaje correcto");
        } else {
            System.out.println("Mensaje incorrecto");
        }


    }

    //Lo dejo vacio porque hay que validar temas de permisos
    @Test(priority = 33)
    public void VisualizacionMenuUsuarioSinPermiso() throws InterruptedException {
        System.out.println("Lo dejo vacio porque hay que validar temas de permisos");

    }
/*
    @Test(priority = 34)
    public void VisualizacionOpcionesLinkDeOtrosSistemas() throws InterruptedException {

        //Validamos que aparezca Sucursal Virtual
        WebElement btnGestorSucursalVirtual = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[2]/div/div/div/ul[2]/li[2]/button/div"));
        if (btnGestorSucursalVirtual.isDisplayed()) {
            System.out.println("Aparece boton Sucursal Virtual");
        } else {
            System.out.println("No aparece boton Sucursal Virtual");
        }
        //Validamos que aparezca Gestor Documental
        WebElement btnGestorDocumental = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[2]/div/div/div/ul[2]/li[1]/button/div"));
        if (btnGestorDocumental.isDisplayed()) {
            System.out.println("Aparece boton Gestor Documental");
        } else {
            System.out.println("No aparece boton Gestor Documental");
        }
    }

    /*
        @Test(priority = 35)
        public void OpcionSucursalVirtual() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            //Visualizamos boton Sucursal virtual
            WebElement btnSucursalVirtual = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[2]/div/div/div/ul[2]/li[2]/button")));
            if (btnSucursalVirtual.isDisplayed()) {
                System.out.println("Veo boton sucursal virtual");
                //Presionamos boton
                wait.until(ExpectedConditions.elementToBeClickable(btnSucursalVirtual)).click();
                Thread.sleep(2000);

                //Comprobamos que nos lleve a la página sucursal virtual
                String urlactual = driver.getCurrentUrl();
                String linkConfiguracion = ("sucursalvirtual-qa");
                //System.out.println(urlactual);
                if (urlactual.contains(linkConfiguracion)) {
                    System.out.println("Estamos en sucursal virtual");
                } else {
                    System.out.println("El link no es el correcto");
                    ;
                }
                //Volvemos a ingresar a integra Negocio
                AccesoIntegraNegocio();
            } else {
                System.out.println("No veo boton de sucursal virtual");
            }
        }
    */
    @Test(priority = 36)
    public void OpcionGestorDocumental() throws InterruptedException {
     /*   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //visualizamos boton gestor documental
        WebElement btnGestorDocumental = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[2]/div/div/div/ul[2]/li[1]/button/div")));
        if (btnGestorDocumental.isDisplayed()) {
            System.out.println("Veo boton Gestor Documental");
            //Presionamos boton
            btnGestorDocumental.click();

            //Comprobamos que nos lleve a la página sucursal virtual
            String urlactual = driver.getCurrentUrl();
            String linkConfiguracion = ("gestion-de-firmas");
            //System.out.println(urlactual);
            if (urlactual.contains(linkConfiguracion)) {
                System.out.println("Estamos en Gestor Documental");
            } else {
                System.out.println("El link no es el correcto");
                ;
            }

            //Volvemos a sucursal virtual
            driver.navigate().back();
        } else {
            System.out.println("No veo boton de Gestor Documental");
        }
    */}

    @Test(priority = 37)
    public void CrearNuevaInscripcion() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Presionamos Inscripciones
        MenuInscripciones();

        //Validamos boton Nueva inscripcion
        WebElement btnNuevaInscripcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/button")));
        if (btnNuevaInscripcion.isDisplayed()) {
            //System.out.println("Veo boton Nueva inscripcion");
            capturarYAdjuntarCaptura("Captura_NuevaIncripcion");//Caprtura de pantalla
            btnNuevaInscripcion.click();


        } else {
            System.out.println("No aparece el boton Nueva inscripcion");
        }

    }

    @Test(priority = 38)
    public void InscripcionCursoConPerfilOtic() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        //Validamos que nos lleve a la pagina de inscripciones
        WebElement msjInscripcionDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/h1")));
        String txtmsjInscripcionDeCurso = msjInscripcionDeCurso.getText();
        if (txtmsjInscripcionDeCurso.contains("Inscripción de Curso")) {
            System.out.println("Veo mensaje de inscripcion de curso");

            //Ingresamos un cliente a buscar
            WebElement inputnombreCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hQBaLS")));
            String resultados = "";
            /*if (RutCliente.replaceAll(("[^0-9]"), "").length() >= 8) {
                // Insertar un guion después del octavo carácter
                resultados = resultados.substring(0, 8) + "-" + resultados.substring(8);
            } else {
                System.out.println("La longitud del número es menor a 8. No se insertará el guion.");
            }*/
            inputnombreCliente.sendKeys(NombreCliente);
            Thread.sleep(3000);
            //Hacemos una lista con los resultados que arroja
            List<WebElement> resultado = driver.findElements(By.className("jOXArb"));

            int cantidadDeElementos = resultado.size();
            // Verifica cantidad de resultados
            if (resultado.size() == 1) {
                System.out.println("Solo hay 1 resultado");
                //Recorremos la lista de resultados para tomar los textos
                for (WebElement opc : resultado) {
                    String txtCurso = opc.getText(); // Obtengo el texto del elemento actual en la lista
                    System.out.println("Resultado: " + txtCurso);
                }
                //TODO: hay que hacer una iteración que recorra la lista y seleccione la más parecida
                Thread.sleep(3000);//Espera necesaria Si la quito se daña la prueba
                WebElement PrimerElemento = wait.until(ExpectedConditions.visibilityOf(resultado.get(0)));
                PrimerElemento.click();
            } else if (resultado.size() <= 5) {
                System.out.println("Hay menos de 5 resultados");
                //Recorremos la lista de resultados para tomar los textos
                for (WebElement opc : resultado) {
                    String txtCurso = opc.getText(); // Obtengo el texto del elemento actual en la lista
                    System.out.println("Resultado: " + txtCurso);
                }
                //TODO: hay que hacer una iteración que recorra la lista y seleccione la más parecida
                Thread.sleep(3000);//Espera necesaria Si la quito se daña la prueba
                WebElement PrimerElemento = wait.until(ExpectedConditions.visibilityOf(resultado.get(0)));
                PrimerElemento.click();
            } else if (resultado.size()>=5){
                System.out.println("Hay mas de 5 resultados");
                //Recorremos la lista de resultados para tomar los textos
                for (WebElement opc : resultado) {
                    String txtCurso = opc.getText(); // Obtengo el texto del elemento actual en la lista
                    System.out.println("Resultado: " + txtCurso);
                }
                //TODO: hay que hacer una iteración que recorra la lista y seleccione la más parecida
                Thread.sleep(3000);//Espera necesaria Si la quito se daña la prueba
                WebElement PrimerElemento = wait.until(ExpectedConditions.visibilityOf(resultado.get(0)));
                PrimerElemento.click();
            }else {
                System.out.println("No hay resultados");

            }



        } else {
            System.out.println("No veo mensaje de inscripcion de curso");
        }
    }

    @Test(priority = 39)
    public void SucursalDeClienteSeleccionado() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //a. Si el cliente seleccionado tiene mas de una sucursal y sus aportes son independientes el usuario visualizara
        // una lista desplegable con las opciones de las sucursales para que pueda seleccionar una de ellas
        WebElement Cliente = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div[2]/h1[2]"));
        WebElement tituloCliente = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div[2]/h1[1]"));
        String txtTituloCliente = tituloCliente.getText();
        System.out.println(txtTituloCliente + ": " + Cliente.getText());
        //mostrarDatos(cliente);
        WebElement RutCliente = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div[4]/h1[2]"));
        WebElement tituloRutCliente = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div[4]/h1[1]"));
        System.out.println(tituloRutCliente.getText() + ": " + RutCliente.getText());

        String[] palabras = txtTituloCliente.split("\\s+"); // Dividir por espacios en blanco
        boolean encontrado = false; // Usamos una bandera para rastrear si encontramos la palabra
        for (String palabra : palabras) {
            // Eliminar signos de puntuación alrededor de la palabra (opcional)
            palabra = palabra.replaceAll("[.,!?]", "");

            // Comprobar si la palabra actual coincide con la palabra buscada (ignorando mayúsculas/minúsculas)
            if (palabra.contains(NombreCliente)) {
                encontrado = true; // Encontramos la palabra
                System.out.println("Busqueda exitosa");
                System.out.println("-" + palabra);
                break; // Sal del bucle si la palabra fue encontrada
            } else {
                System.out.println("Busqueda no conicide");
                System.out.println("-" + palabra);
            }
        }

        //b. En caso que el Cliente tenga solo una sucursal se mostrará la Sucursal en el select por defecto

        Thread.sleep(3000);//Espera obligatoria
        //Validamos la sucursal del cliente
        WebElement btnSeleccionaSucursal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1wy0on6")));
        btnSeleccionaSucursal.click();
        Thread.sleep(3000);
        //Se desplegan las sucursales
        WebElement sucursales = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1nmdiq5-menu")));//No mover, es la variable que contiene la lista de sucursales
        //System.out.println(sucursales);
        capturarYAdjuntarCaptura("Captura_Cliente&Sucursal");//Captura de pantalla

        sucursales.click();

        //TODO: Lo dejaré así para avanzar pero hace falta controlar cuando el cliente tiene más de una sucursal

/*
        int cantidadSucursales =0;
        for (WebElement sucursales : SucursalesDeCliente){
            String txtSucursales = sucursales.getText();
            System.out.println(" "+txtSucursales);
            cantidadSucursales ++;
            System.out.println(cantidadSucursales);

        }
        System.out.println(cantidadSucursales);
*/


    }

    @Test(priority = 40)
    public void OpcionSalir() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //En la parte inferior de la pantalla el usuario visualizará un botón con la opción "Salir" en el caso que
        // desee salir de la inscripción, si el usuario le da clic en este botón lo regresara a la pantalla principal
        // de inscripción, previamente se mostrará un mensaje de confirmación
        WebElement btnSalir = driver.findElement(By.className("ml-[0.541rem]"));
        if (btnSalir.isDisplayed()) {
            System.out.println("Presionamos salir");
            btnSalir.click();
        } else {
            System.out.println("No aparece boton salir");
        }

        //Validamos mensaje de advertencia
        WebElement msjAdvertencia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), '¿Quieres salir de la inscripción?')]")));
        String txtmsjAdvertencia = msjAdvertencia.getText();
        if (txtmsjAdvertencia.contains("¿Quieres salir de la inscripción?")) {
            //Buscamos boton Salir
            //WebElement btnConfirmarSalir = driver.findElement(By.cssSelector("#single-spa-application\\:\\@CCC\\/inscriptions > div > div.sc-bcXHqe.dqlVec > div > div.sc-bcXHqe.hlMJoa > div > div.sc-eDvSVe.jDzeEO > div > button.sc-bcXHqe.eCGCgc.rounded-full.whitespace-nowrap.px-\\[2\\.5rem\\].h-12.text-xl.gap-2.py-1.px-4.font-medium.bg-secondary.hover\\:bg-white.hover\\:border-solid.hover\\:border-secondary.hover\\:text-secondary.text-contained"));
            //btnConfirmarSalir.click();
            //Para efectos de continuidad de pruebas, no presionaremos salir si no que continuaremos
            WebElement btnNoSalir = driver.findElement(By.xpath("//button[contains(text(), 'No Salir')]"));
            btnNoSalir.click();
            System.out.println("Salimos");
        } else {
            System.out.println("No aparece boton salir");
        }
        Thread.sleep(5000);
    }

    @Test(priority = 41)
    public void OpcionContinuar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Opción "Continuar" de la selección de un cliente
        WebElement btnContinuar = wait.until(ExpectedConditions.elementToBeClickable((By.className("mr-[0.2rem]"))));
        if (btnContinuar.isDisplayed()) {
            btnContinuar.click();
            System.out.println("Presionamos Continuar");
        } else {
            System.out.println("No aparece boton Continuar");
        }


    }

    @Test(priority = 42)
    public boolean IngresoPaso1Inscripcion() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //1. Se mostrará el título correspondiente al paso actual, que en este caso es "Tipo de curso".
        //2. El título del paso actual "Tipo de curso" deberá permanecer visible para que el usuario siempre sepa en qué etapa del proceso de inscripción se encuentra.

        WebElement TipoDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Tipo de Curso']"))); //"svg[class='h-6 w-6']"
        String txtEtapa = TipoDeCurso.getText();


        if (txtEtapa.contains("Tipo de Curso")) {
            System.out.println("Estamos en Tipo de Curso");
        } else {
            System.out.println("Etapa incorrecta");
        }
        return true;
    }

    @Test(priority = 43)
    public void TiposDeLineaDeTrabajo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(5000);
        //Cuando el usuario ingresa al paso 1, todas las opciones tanto de tipo de línea y tipo de contrato se ven inhabilitadas y cuando selecciona una de las opciones respectivamente estas quedan resaltadas.
        List<WebElement> botones = driver.findElements(By.className("mt-[1.75rem]"));
        System.out.println(botones);

        if (botones.size() == 2) {
            //Vemos si desplega los otros botones
            WebElement nvabusqueda = driver.findElement(By.className("mt-[1.75rem]"));
            List<WebElement> nvaBusqueda = driver.findElements(By.className("mt-[1.75rem]"));
            System.out.println(nvaBusqueda.size());
            //Si la cantidad de botones son 5 entonces vemos cuales son


        }
    }

    //Lo dejé en ese orden para poder continuar cn flujo de inscripcion por codigo Sence
    @Test(priority = 45)
    public void TiposDeContrato_Franquicia() throws InterruptedException, IOException {
        Thread.sleep(1000);
        //Seguimos flujo de inscripcion de curso
        List<WebElement> botones = driver.findElements(By.className("mt-[1.75rem]"));
        System.out.println(botones.size());

        if (botones.size() >= 2) {
            WebElement primerElemento = botones.get(0);//tomamos el primer boton (Franquicia)
            primerElemento.click();
            System.out.println("Presionamos franquicia");
            //Vemos si desplega los otros botones
            WebElement nvabusqueda = driver.findElement(By.className("mt-[1.75rem]"));
            List<WebElement> nvaBusqueda = driver.findElements(By.className("mt-[1.75rem]"));
            //System.out.println(nvaBusqueda.size());
            //Si la cantidad de botones son 5 entonces vemos cuales son
            if (nvaBusqueda.size() == 5) {
                System.out.println("Hay 5 botones");
                for (WebElement opcs : nvaBusqueda) {
                    System.out.println(opcs.getText());
                }

                System.out.println("");
            }
            //Presionamos la opcion contratos
            WebElement btncursoInterno = nvaBusqueda.get(2);
            WebElement btnTipoContratoNormal = nvaBusqueda.get(3);
            btnTipoContratoNormal.click();
        }else {
            System.out.println("No está entrando al if ");
        }
        capturarYAdjuntarCaptura("Captura_FranquiciaYContrato");//Caprtura de pantalla

        OpcionSalir();
        OpcionContinuar();
        System.out.println("Nos pasamos al paso 2");

    }

    @Test(priority = 44)
    public void TiposDeContrato_NoFranquicia() throws InterruptedException {
        Thread.sleep(2000);

        //Tomamos todos los elementos presentes con la misma clase
        List<WebElement> botones = driver.findElements(By.className("mt-[1.75rem]"));
        System.out.println(botones.size());
        WebElement segundoElemento = botones.get(1);//tomamos el segundo boton (No Franquicia)
        segundoElemento.click();

        if (botones.size() == 5) {
            //Vemos si desplega los otros botones
            List<WebElement> nvaBusqueda = driver.findElements(By.className("mt-[1.75rem]"));
            //WebElement segundoElemento = nvaBusqueda.get(1);//tomamos el segundo boton (No Franquicia)
            //segundoElemento.click();
            System.out.println(nvaBusqueda.size());
            //Si la cantidad de botones son 5 entonces vemos cuales son

            if (nvaBusqueda.size() == 3) {
                System.out.println("Hay 3 botones");
                for (WebElement opcs : nvaBusqueda) {
                    System.out.println(opcs.getText());
                }

            }
            WebElement btncursoInterno = nvaBusqueda.get(2);
            btncursoInterno.click();
        }

        OpcionSalir();
        //OpcionContinuar();
        //System.out.println("Nos pasamos al paso 2");

    }

    //Este metodo busca la barra para ingresar coidgo sence
    @Test(priority = 46)
    public void IngresoPaso2Inscripcion() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //1. Se mostrará claramente el título correspondiente al paso 2, que se refiere a los "Datos de curso".
        WebElement DatosDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Datos de Curso']")));
        String txtEtapa = DatosDeCurso.getText();


        if (txtEtapa.contains("Datos de Curso")) {
            System.out.println("Estamos en Datos de Curso");
        } else {
            System.out.println("Etapa incorrecta");
        }

        //2.  Se mostrará una barra donde el usuario podrá ingresar el código Sence, con un mensaje informativo que indica: "Validemos el código Sence".
        WebElement barraCodigo = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[1]/input"));
        if (barraCodigo.isDisplayed()) {
            System.out.println("Aparece la barra para ingresar codigo");
        } else {
            System.out.println("No aparece la barra para ingrear codigo");
        }

        //Validamos aparezca el mensaje
        WebElement msjValidemosCodigoCurso = driver.findElement(By.xpath("//h3[text()='Validemos el código Sence']"));
        System.out.println("-Aparece mensaje (Validemos el código Sence): " + msjValidemosCodigoCurso.getText().equals("Validemos el código Sence"));

    }

    @Test(priority = 47)
    public void LongitudYValidacionCodigoSence() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.barraCodigo = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[1]/input"));

        //1. Longitud de 10 digitos la cual tendrá un mensaje informativo.
        barraCodigo.sendKeys(ingresoLetras);
        this.btnValidar = driver.findElement(By.xpath("//button[text()='Validar']"));

        //TODO: hay que controlar el caso que NO aparezca el resultado de la busqueda, guardar el error y terminar la prueba
        //2. Código Sence solo permite ingresar números
        String valor = (barraCodigo.getAttribute("value"));
        if (btnValidar.isSelected()) {
            System.out.println("Error: Boton habilitado con menos de 10 numeros ingresados");
        } else {
            if (valor.matches(".*[a-zA-Z].*")) {
                // Si hay letras, imprimir mensaje de error
                System.out.println("Error: El código Sence contiene letras.");
            } else {
                // Si no hay letras, imprimir mensaje correcto
                System.out.println("Mensaje: El código Sence es válido.");
                System.out.println("Le enviamos el resto de los numeros");
                barraCodigo.sendKeys(codigoSence);

                //              SIGUIENTE HISTORIA
                //1.  Al ingresar el número del código Sence, se habilitará un botón "Validar".
                //
                if (btnValidar.isEnabled()) {
                    Thread.sleep(1000);
                    btnValidar.click();//Aqui debiera hacer click
                    System.out.println("Se habilitó boton 'Validar'");

                    //2.  Al hacer clic en este botón, pueden ocurrir los siguientes escenarios:
                    //
                    //a. Validado correctamente: Si el código existe en el Sence y aún no ha caducado.
                    //b. Error de validación: Si el código NO existe en el Sence o el código ya ha caducado.
                    WebElement MsjRespuesta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("w-1/5")));
                    String TxtMsjRespuesta = MsjRespuesta.getText();
                    System.out.println(TxtMsjRespuesta);
                    if (TxtMsjRespuesta.equals("¡Validado exitosamente!")) {
                        System.out.println("Codigo correcto");


                    } else if (TxtMsjRespuesta.equals("¡Código inválido!")) {
                        System.out.println("Codigo inválido");
                    } else {
                        System.out.println("Mensaje de respuesta de busqueda inesperado");
                    }

                } else {
                    System.out.println("No se habilita boton");

                }

            }
        }


    }

    @Test(priority = 48)
    public void ValidadoCorrectamenteCodigoSence() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // 1. Se desplegará una sección con la siguiente información del curso:
        //
        //WebElement DespliegueInfoCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[1]/div[2]/svg")));
        Thread.sleep(2000);

        //- Nombre del curso.                                           //*[@id="single-spa-application:@CCC/inscriptions"]/div/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[1]/div/h3
        WebElement NombreCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[1]/div/h3")));
        WebElement tituloNombreCurso = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[1]/div/h2"));
        System.out.println(tituloNombreCurso.getText() + ": " + NombreCurso.getText());

        //- OTEC (Organismo Técnico de Capacitación) asociado.
        WebElement Otec = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[2]/div[1]/div/h3"));
        WebElement tituloOtec = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[2]/div[1]/div/h2"));
        System.out.println(tituloOtec.getText() + ": " + Otec.getText());

        //- Rut del OTEC.
        WebElement RutOtec = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[2]/div[2]/div/h3"));
        WebElement tituloRutOtec = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[2]/div[2]/div/h2"));
        System.out.println(tituloRutOtec.getText() + ": " + RutOtec.getText());

        //- Horas del curso.
        WebElement Horascurso = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[3]/div[1]/div/h3"));
        WebElement tituloHorascurso = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[3]/div[1]/div/h2"));
        System.out.println(tituloHorascurso.getText() + ": " + Horascurso.getText());

        //- Participantes del curso.
        WebElement Participantes = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[3]/div[2]/div/h3"));
        WebElement tituloParticipantes = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[3]/div[2]/div/h2"));
        System.out.println(tituloParticipantes.getText() + ": " + Participantes.getText());

        //- Modalidad del curso.
        WebElement ModalidadCurso = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[3]/div[3]/div/h3"));
        WebElement tituloModalidadCurso = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[3]/div[3]/div/h2"));
        System.out.println(tituloModalidadCurso.getText() + ": " + ModalidadCurso.getText());

        //- Tipo de franquicia asociada.
        WebElement TipoDeFranquicia = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[4]/div[1]/div/h3"));
        WebElement tituloTipoDeFranquicia = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[4]/div[1]/div/h2"));
        System.out.println(tituloTipoDeFranquicia.getText() + ": " + TipoDeFranquicia.getText());

        //- Valor efectivo por participante.
        WebElement ValorEfectivoParticipante = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[4]/div[2]/div/h3"));
        WebElement tituloValorEfectivoParticipante = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[4]/div[2]/div/h2"));
        System.out.println(tituloValorEfectivoParticipante.getText() + ": " + ValorEfectivoParticipante.getText());

        //- Valor máximo imputable.
        WebElement ValorMaxImputale = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[4]/div[3]/div/h3"));
        WebElement TituloValorMaxImputale = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[4]/div[3]/div/h2"));
        System.out.println(TituloValorMaxImputale.getText() + ": " + ValorMaxImputale.getText());

        //2. El sistema realizará un scroll automático para mostrar la sección de información del curso.
        //
        //3. La sección de información del curso estará expandida y visible por defecto
        //
        //4. En la parte inferior del buscador se mostrará la fecha de validación del codigo sence
        WebElement fechaValidoCurso = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[5]/div"));
        System.out.println("Fecha valido hasta: " + fechaValidoCurso.getText());
        scrollHaciaArriba(driver);
        capturarYAdjuntarCaptura("Captura_BusquedaDeCursoAInscribir");//Caprtura de pantalla


    }

    //comentado para hacer la prueba más corta
    @Test(priority = 49)
    public void EditarCodigoSence () throws InterruptedException{
           /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            //1. Estando en el paso 2 para una inscripción de tipo de línea franquicia, donde el usuario ya haya ingresado un código sence, visualizara la acción de “borrar” junto al código previamente validado.
            //
            this.btnBorrarCodigo = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[1]/div/div"));

            if (btnBorrarCodigo.isDisplayed()){
                System.out.println("Presionamos boton borrar");
                //No mover
                Actions actions = new Actions(driver);
                actions.moveToElement(btnBorrarCodigo).click().perform();
                Thread.sleep(5000);

                //Le envio la variable con el codigo correcto
                this.barraCodigo = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[1]/input"));

                barraCodigo.sendKeys(codigoSence);
                this.btnValidar = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[2]/button"));
                btnValidar.click();

                ValidadoCorrectamenteCodigoSence();

            }

            // 2. Si el usuario para el cursor sobre el icono de “borra” este cambia de color

        */}

    @Test(priority = 50)
    public void ValorAcordadoParticipante() throws InterruptedException, IOException {
        //1. Si la Validación del Código Sence fue Exitosa (Paso 2 de la inscripción Linea trabajo Franquicia), se desplegara un input para que el usuario pueda ingresar el valor acordado por participante con el OTEC debajo de la sección información del curso
        //
        WebElement valorAcordadoInput = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[3]/div[1]/div/input"));
        valorAcordadoInput.sendKeys(valorAcordadoMaximo);

        //2. Se limita largo del campo por la configuración de la longitud en BBDD a 14 caracteres
        //Le envié 15 numeros para comprobar que anota solo 14
        int longitudInputValor = 14;
        String valor = valorAcordadoInput.getAttribute("value").replace(".", "");//Tomo el valor del input y le quito los puntos al String
        System.out.println(valor); //Imprimo el valor

        if (valor.length() == longitudInputValor) {
            System.out.println("Cantidad de valores correcta");

        } else if (valor.length() > longitudInputValor) {
            System.out.println("Cantidad de valores mayor ");
        } else if (valor.length() < longitudInputValor) {
            System.out.println("Cantidad de valores menor ");
        }

        //Le enviamos un valor normal para contuinuar con la prueba
        valorAcordadoInput.clear();
        valorAcordadoInput.sendKeys(valorAcordado);
        capturarYAdjuntarCaptura("Captura_ValorAcordadoParticipante");//Caprtura de pantalla

    }

    @Test(priority = 51)
    public void Opciones_Salir_Volver_Continuar () throws InterruptedException, IOException {
         /*                                           //Para efectos del orden hago un solo metodo que valide los 3 botones
            try {
            //En la parte inferior de la pantalla el usuario visualizará un botón con la opción Salir en el caso que desee
            // salir de la inscripción, si el usuario le da clic en este botón se le mostrará un mensaje informativo validando
            // si desea salir de la inscripción que esta realizando, si el usuario lo confirma lo regresara a la pantalla
            // principal de inscripción
            OpcionSalir();

            //En la parte inferior de la pantalla el usuario visualizará un botón con la opción Volver, en el caso que desee
            //Volver al paso anterior de la inscripción, si el usuario le da clic en este botón lo regresara en el proceso y lo posicionará en el paso 1 de proceso.
            WebElement btnVolver = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[4]/div/div[2]/button"));
            btnVolver.click();

            //Validamos que nos lleve a paso 1
            IngresoPaso1Inscripcion(); //Busco el titulo del paso 1
            OpcionContinuar();//Presiono continuar para que me lleve de nuevo al paso 2
            Thread.sleep(3000);//No quitar espera, SI LO QUITO SE DAÑA LA PRUEBA
            IngresoPaso2Inscripcion();//Valido nuevamente la informacion del codigo
            ValidadoCorrectamenteCodigoSence();
            Thread.sleep(3000);//No quitar espera, SI LO QUITO SE DAÑA LA PRUEBA
            ValorAcordadoParticipante();//Escribo nuevamente el monto acordado
            Thread.sleep(2000);//No quitar espera, SI LO QUITO SE DAÑA LA PRUEBA
            OpcionContinuar();


            //El usuario vera al volver las opciones que el había seleccionado previamente en el proceso de inscripción
            //1.- En la parte inferior de la pantalla el usuario visualizará un botón con la opción Continuar en el caso
            // que desee seguir con la inscripción, esta opción solo estará habilitada en caso que todos los datos estén
            // completos y llevara al usuario al paso 3.  se consideran como datos completos el Código Sence ingresado y
            // validado y el ingreso del Monto acordado por participante.
                WebElement btnContinuar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[4]/div/div[3]/button")));
                if (btnContinuar.isEnabled()){
                    System.out.println("Debe seguir la prueba");

                }else {
                    System.out.println("Boton continuar no está habilitado");
                }

            //Thread.sleep(10000);
            log.info("La prueba pasó: El resultado es exitoso.");



            //2. El sistema guardara la información de esta inscripción como borrador hasta este paso, cuando el usuario le de clic en continuar
            } catch (Exception e) {
                log.error("Se produjo un error durante la prueba", e);
            } finally {
                // Cerrar el navegador
                if (driver != null) {
                    //driver.quit();
                }
            }
        }
    */
        Thread.sleep(1000);//Espera necesaria, no quitar
        //capturarYAdjuntarCaptura("Captura_NuevaIncripcion");//Caprtura de pantalla

        OpcionContinuar();


    }

    @Test(priority = 52)
    public void Ingresos_Fechas_inicio_y_termino_del_curso() throws InterruptedException, IOException {
        OpcionContinuar();//Coloco esto porque comenté la opcion de arriba

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //1. El usuario al ingresar al paso 3 verá un mensaje informativo que le solicita ingresar la fecha de inicio y termino del curso.
        //
        Thread.sleep(3000);//Espera de prueba
        WebElement paso3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[1]/div[2]/span")));
        String txtpaso3 = paso3.getText();
        System.out.println(txtpaso3);

        if ("Horarios".equals(txtpaso3)) {
            System.out.println("Entramos al if");

            seleccionarFechaInicio();


            seleccionarFechaTermino();

            System.out.println("Escogimos las fechas");
            capturarYAdjuntarCaptura("Captura_FechasDeCurso");//Caprtura de pantalla

        } else

        {
            System.out.println("No esta entrando al if");
        }


    }

    @Test(priority = 53)
    public void IngresoHoraInicioYHoraTermino () throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //- Hola inicio: Si el usuario le da clic a la hora de inicio verá una lista desplegable con los horarios desde las 00:00 hasta las 23:30 donde puede seleccionar una de ellas, pero támbien es un input que puede ser editado y cambiar a un horario que no esta dentro de la lista.
        //
        //1. El usuario verá dentro de la aplicación las opciones para ingresar una franja horaria para el día correspondiente.
        /////////////////////////HORA DE INICIO
        WebElement horaInicio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[2]/div/div[1]/div/div/div/div/div[1]/div[2]")));
        horaInicio.click();
        WebElement inputHoraInicio = driver.findElement(By.id("react-select-3-input"));
        inputHoraInicio.sendKeys("0350");
        horaInicio.click();
        //seleccionarHoraInicio(driver,"0240");

        //- Horario de Termino: Si el usuario le da clic a la hora de termino verá una lista desplegable con los horarios desde las 00:00 hasta las 23:30 donde puede seleccionar una de ellas, pero támbien es un input que puede ser editado y cambiar a un horario que no esta dentro de la lista.
        //
        ///////////////////////HORA DE TERMINO
        //seleccionarHoraTermino(driver,"0230");
        WebElement horaTermino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[2]/div/div[2]/div/div/div/div/div[1]")));
        horaTermino.click();
        WebElement inputHoraTermino = driver.findElement(By.id("react-select-4-input"));
        inputHoraTermino.sendKeys("0650");
        horaTermino.click();
        System.out.println("Ya seleccione las horas");



        //2. Se realizarán validaciones para asegurarse de que la hora de inicio sea menor que la hora de término.
        //






        //3. Se mostrará un mensaje informativo al usuario que el horario de capacitación no puede exceder 8 horas


    }

    @Test(priority = 54)
    public void IngresarJornada1 () throws InterruptedException, IOException {
        //1. El usuario podrá seleccionar el horario correspondiente al dial de la semana del día que inicia el curso.
        //2. Se verá un mensaje en la parte superior del la selección de los horarios donde indica el día en el que inicia el curso con el correspondiente día de la semana.
        //3. El usuario podrá seleccionar mas de un día de la semana para repetir el horario indicado, esta acción la podrá realizar al hacer clic sobre la inicial del día de la semana,  el usuario verá un mensaje informativo que le indica que el horario  se repetirá para los días seleccionados semanalmente
        // Selección de todos los días de la semana
        WebElement btnTodosLosDias = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[6]/div/div/label/div"));
        btnTodosLosDias.click();
        // Exclusión de días feriados
        WebElement btnOmitirFeriados = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[7]/div/div/label/div"));
        btnOmitirFeriados.click();

        //Borrar Horario
        //TODO: Hacer la logica para validar si esta vacio los campos los vuelva a llenar

        WebElement btnLimpiarHorario = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[8]/button[1]"));
        //btnLimpiarHorario.click();

        //TODO: CREAR LOGICA QUE PERMITA PASAR POR TODOS LOS DIAS Y SELECCIONAR AL AZAR


        //Volvemos a colocar los horarios
        IngresoHoraInicioYHoraTermino ();


        // Opción "Guardar Horario"
        WebElement btnGuardarCambios = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[8]/button[2]")));
        if (btnGuardarCambios.isDisplayed()){
            capturarYAdjuntarCaptura("Captura_HorariosDeCurso");//Caprtura de pantalla

            btnGuardarCambios.click();
        }

    }

    @Test(priority = 55)
    public void  Agregar_Otra_Hora_Franja_Horaria () throws InterruptedException {
//1. El usuario verá un botón o enlace con la opción de "Agregar Horario" que le permitirá ingresar otra franja horaria.
        WebElement btnDespliegueAgregarFranja = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("eDvcLi")));
        btnDespliegueAgregarFranja.click();
//2. Al hacer clic en "Agregar Horario", se desplegarán los campos para ingresar una nueva franja horaria.
//
        WebElement btnAgregarNuevoHorario = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[3]/button"));
        btnAgregarNuevoHorario.click();
//3. Hora de inicio y Hora de término: El usuario podrá ingresar la hora de inicio y la hora de término para la nueva franja horaria. Se utilizarán listas desplegables con los horarios disponibles, desde las 00:00 hasta las 23:30, y también se permitirá la opción de editar el campo de entrada de texto para ingresar horarios específicos.
//
        /////////////////////////HORA DE INICIO
        WebElement horaInicio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[3]/div/div[1]/div/div/div/div/div[1]/div[2]")));
        horaInicio.click();
        WebElement inputHoraInicio = driver.findElement(By.id("react-select-7-input"));
        inputHoraInicio.sendKeys("1750");
        horaInicio.click();
        ///////////////////////HORA DE TERMINO
        WebElement horaTermino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[3]/div/div[2]/div/div/div/div/div[1]/div[2]")));
        horaTermino.click();
        WebElement inputHoraTermino = driver.findElement(By.id("react-select-8-input"));
        inputHoraTermino.sendKeys("2050");
        horaTermino.click();
        System.out.println("Ya seleccione las horas");
        Thread.sleep(1000);//Espera de prueba

//4. Se realizarán validaciones para asegurarse de que la nueva franja horaria no se superponga con las franjas horarias existentes. Si hay superposición, se mostrará un mensaje de error y se pedirá al usuario que ajuste los horarios.
//

//5. Después de ingresar la nueva franja horaria, se mostrará una confirmación visual al usuario indicando que el horario ha sido registrado correctamente.
//
//6.  El usuario visualizara un boton al lado de la hora de inicio y de fin para borrar el horario ingresado.
//
        WebElement btnCheckHorario = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[3]/div/div[3]/div"));

//8. Se mostrará un mensaje informativo al usuario si las sumatoria de los horarios de capacitación excede 8 horas.

        // Opción "Guardar Horario"
        WebElement btnGuardarCambios = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[9]/button[2]/span")));
        if (btnGuardarCambios.isDisplayed()){
            btnGuardarCambios.click();
        }

    }

    @Test(priority = 56)
    public void SeleccionarHorario_Comentarios () throws InterruptedException, IOException {
        //En caso que el usuario le de clic en continuar y exista horas ingresadas que se pasen o faltes   a las que debe tener el curso y no tenga comentario , se debe mostrar un mensaje informativo para que recuerde ingresar el comentario

        //1. Una vez que se haya ingresado al menos una jornada de capacitación, se habilitará un campo de comentarios adicionales.
        //
            WebElement AreatxtComentarios = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/textarea")));
            AreatxtComentarios.sendKeys("Prueba");

        //2. Este campo estará disponible para ingresar información adicional relacionada con los horarios o el lugar de realización del curso.
        //
        //3. El campo de comentarios adicionales tendrá un límite máximo de 1500 caracteres.
        //
            String CapacidadDeTexto = AreatxtComentarios.getAttribute("maxlength");
            if (CapacidadDeTexto.equals("1500")){
                System.out.println("Canidad de caracteres correcto");
            }

        //4. El campo de comentarios adicionales tendrá un scroll en caso de que el texto introducido supere el área visible.
        //
        //5. Esto permitirá que los usuarios puedan desplazarse y leer to do el contenido del comentario, incluso si es más largo de lo que se muestra inicialmente.

        //Probamos los botones
        //Salir
        OpcionSalir();

        //Opcion Volver
        //Validamos que esté el boton
        WebElement btnvolver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[5]/div/div[2]/button")));
        //Este boton no lo presionaré por efectos de la prueba



        //Opcion continuar
        OpcionContinuar();
    }

    @Test(priority = 57)
    public void  CargaMasivadeparticipantes () throws InterruptedException, AWTException, IOException {
        Thread.sleep(5000);
        capturarYAdjuntarCaptura("Captura_Paso4_Participantes");//Captura de pantalla
        Thread.sleep(5000);
        //1. En la plataforma, se proporcionará un cuadro donde el usuario puede arrastrar el archivo que contiene los datos de los participantes.
        //
        WebElement AgregarArchivo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bGgmkt")));
        AgregarArchivo.click();
        //2. El cuadro de carga aceptará únicamente un solo archivo a la vez.
        //
        //3. Si el usuario prefiere seleccionar el archivo en lugar de arrastrarlo, al hacer clic sobre el cuadro de carga, se abrirá la librería de su equipo para que seleccione el archivo deseado.
        //
        try {

        // Espera un segundo para asegurar que el explorador de archivos se haya abierto
        Thread.sleep(1000);

        // Automatiza la navegación y selección del archivo usando Robot
        Robot robot = new Robot();
        typeString(robot, "Carga Masiva Par - SIN ERROR");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        selectFile(robot);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(10000);
        closeFileExplorer(robot);

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Cierra el navegador al finalizar
        //driver.quit();
            System.out.println("Selecionamos el archivo ");
    }
}

    @Test(priority = 58)
    public void VisualizacionDeRegistros () throws InterruptedException, IOException {
        //1. Después de cargar el archivo  Excel, se mostrará una previsualización de los registros de participantes.
        //
        WebElement pantallaEmergenteParticipantes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[11]/div/div/div[2]")));
        //2. Se mostrarán todos los registros cargados, con la posibilidad de desplazarse verticalmente utilizando un scroll.
        //
        cantidadParticipantes= driver.findElements(By.className("CutUQ"));//Buscamos la tabla de datos
        ConteoCantidadParticipantes = cantidadParticipantes.size();
        System.out.println("En el archivo hay "+cantidadParticipantes.size()+" participantes");

        WebElement NombreParticipantes = cantidadParticipantes.get(0);
        List<WebElement> DatosParticipantes = NombreParticipantes.findElements(By.className("hGmhdP"));
        System.out.println(DatosParticipantes.get(3).getText());


        //3. Todas las columnas del archivo, incluyendo las columnas opcionales, se mostrarán en la previsualizació
        // Scroll vertical y horizontal
        // Realiza un scroll a la derecha utilizando JavaScript
        scrollRight(driver);
        capturarYAdjuntarCaptura("Captura_Carga_Participantes_scrollIzquierda");//Captura de pantalla
        //1. Los títulos de la tabla de previsualización permanecerán fijos en la parte superior al realizar el scroll vertical.
        //
        //2. Los títulos en la grilla tendrán la opción de ordenamiento ascendente o descendente
        //if (WebElement ErrorDeCarga = driver.findElement(By.className("gWBTIn")).isDisplayed()){

        List <WebElement> Titulos = driver.findElements(By.className("LdkzEXp"));

        }

    @Test (priority = 59)
    public void ConfirmacionCargaExitosa () throws InterruptedException{
//1. Si el usuario realiza la confirmación de carga (hace clic en "Guardar"), se mostrará un mensaje de carga exitosa. Luego de la carga exitosa, el usuario permanecerá en la misma pantalla de previsualización de participantes cargados con la opción de "Salir".
//
        WebElement btnGuardarCarga = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[11]/div/div/div[3]/div[2]/div/div[1]/button"));
        if (btnGuardarCarga.isDisplayed()){
            btnGuardarCarga.click();  //PResionamos boton Guardar

        }else {
            Thread.sleep(5000);
            driver.quit();
        }


//2. Si posteriormente le da clic en salir, regresara a la pantalla principal del paso 4,  se mostrara qu
        //WebElement btnSalirAgregarPaticipante = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[11]/div/div/div[3]/div[2]/div/div[2]/button"));

        //if (btnSalirAgregarPaticipante.isDisplayed()) {
         //   btnSalirAgregarPaticipante.click();

        //}
    }

    @Test(priority = 60)
    public void ResumenDeMontos () throws InterruptedException, IOException {
        BuscarResumenDeMontos();
        capturarYAdjuntarCaptura("Captura_Carga_Montos_Participantes");//Caprtura de pantalla
    }

    @Test(priority = 61)
    public void VerParticipantesCargados () throws InterruptedException, IOException{
        //1. En la pantalla principal, se incluirá un botón claramente visible y accesible para el usuario, con el texto "Ver Listado de Participantes". en caso de ya existir una carga previa realizada
        //
        WebElement btnVerListadoPArticipantes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[10]/div/button")));
        if (btnVerListadoPArticipantes.isDisplayed()) {
         btnVerListadoPArticipantes.click();//Presionamos el boton

            //2. Al hacer clic sobre el botón, se mostrará el listado de los participantes cargados en una nueva de previsualización.
            //

            cantidadParticipantes= driver.findElements(By.className("CutUQ"));//Buscamos la tabla de datos
            System.out.println(cantidadParticipantes.size());

            //3. El listado de participantes mostrará todos los registros cargados, con la posibilidad de desplazarse verticalmente utilizando un scroll si es necesario. La información mostrada incluirá todos los campos de cada participante.
            //


            //4. Solo se visualizara la información de los participantes y no se podrá realizar acciones de edición o eliminación

            WebElement btnSalirListadoParticipantes = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[12]/div/div/div[3]/div[2]/div/div[2]/button"));
            if (btnSalirListadoParticipantes.isDisplayed()){
                //capturarYAdjuntarCaptura("Captura_NuevaIncripcion");//Captura de pantalla

                btnSalirListadoParticipantes.click();
                }else {
                System.out.println("No aparece boton salir");
            }
        }else {
            System.out.println("No aparece boton 'Ver listado de participantes' ");
        }


        //Presionamos continuar para avanzar
        Thread.sleep(5000);//Espera de prueba
        OpcionContinuar();
    }

    @Test(priority = 62)
    public void TipoCuentaFinanciamiento () throws InterruptedException, IOException {
        //Validar que estamos en el paso 5
        WebElement Paso5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[2]/div[1]")));
        System.out.println(Paso5.getText());
        if (Paso5.isDisplayed() && Paso5.getText().equals("5")){
            System.out.println("Estamos en el Paso 5");


            //Validamos OpcionSalir
            OpcionSalir();

            //OpcionVolver
            WebElement btnVolver =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[8]/div/div[2]/button")));
            btnVolver.click();//Presionamos boton volver

            //Validamos nos lleve al paso 4
            BuscarResumenDeMontos();//confirmamos que aparezcan los datos
            OpcionContinuar();//Seguimos avanzando
            System.out.println("//////////////////////////////////////");

            BuscarResumenDeMontos();//Volvemos a validar que aparezcan los datos

            //1. Las opciones de cuentas de financiamiento son las siguientes:
            //
            //- Capacitación al Año
            //
            System.out.println("----------Bototones-----------");
            WebElement CapacitacionAlAño = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[2]/div[1]/div/button/p[1]")));
            WebElement ValorCapacitacionAlAño = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[7]/div[2]/div[1]/div/button/p[2]"));
            System.out.println(CapacitacionAlAño.getText()+": "+ValorCapacitacionAlAño.getText());

            //- Excedente Capacitación
            //
            WebElement ExcedenteCapacitacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[2]/div[2]/div/button/p[1]")));
            WebElement ValorExcedenteCapacitacion = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[7]/div[2]/div[2]/div/button/p[2]"));
            System.out.println(ExcedenteCapacitacion.getText()+": "+ValorExcedenteCapacitacion.getText());

            if (CapacitacionAlAño.isDisplayed() && ExcedenteCapacitacion.isDisplayed()){
                //System.out.println("Estan ambos botones");
                //CapacitacionAlAño.click();
                ValorExcedenteCapacitacion.click();//OPCION A SELECCIONAR CUENTA

            }else if (CapacitacionAlAño.isDisplayed()){
                CapacitacionAlAño.click();
                if (ExcedenteCapacitacion.isDisplayed()){
                    ExcedenteCapacitacion.click();
                }else {
                    System.out.println("Falta uno de los botones");
                }
            }
            //2. El usuario solo podrá seleccionar una cuenta de financiamiento de entre las opciones disponibles.
            //
            //3. En la parte superior de la cuenta de financiamiento se visualizara los montos del curso mostrados en el paso 4
            WebElement clientefinanciamenientoInput = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[6]/div[1]/input"));
            clientefinanciamenientoInput.sendKeys(rutClienteFinanciamiento);




        }else{
            System.out.println("No se visualiza el paso 5");
        }
    }

    @Test(priority = 63)
    public void InscribirCurso () throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement btnValidarCliente = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[6]/div[2]/button"));
        capturarYAdjuntarCaptura("Captura_CuentaFinanciamiento");//Captura de pantalla
        //Buscamos boton Inscribir
        WebElement btnInscribir = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[8]/div/div[3]/button")));
        btnInscribir.click();

        if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Inscripción de curso realizada']"))).isDisplayed()){


            //Validamos el tipo de contrato creado
            WebElement nombreTipoFranquicia = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div[1]"));
            System.out.println(nombreTipoFranquicia.getText());

            numeroSolicitudDeCompra = String.valueOf(driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div[2]")).getText());
            System.out.println(numeroSolicitudDeCompra);

            String cadenaConNumeros = "abc123xyz456";

            // Itera a través de la cadena y construye un nuevo string con los dígitos
            StringBuilder numeros = new StringBuilder();
            for (char caracter : numeroSolicitudDeCompra.toCharArray()) {
                if (Character.isDigit(caracter)) {
                    numeros.append(caracter);
                }
            }

            String numerosExtraidos = numeros.toString();
            System.out.println("Números extraídos: " + numerosExtraidos);
            numeroSolicitudDeCompra=numerosExtraidos;





            //Captura
            capturarYAdjuntarCaptura("Captura_Descargar_solicitud_Compra");//Captura de pantalla

            //Descargamos la solicitud de compra
            WebElement btnDescargar = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div[3]/button"));
            btnDescargar.click();


            Thread.sleep(5000);

            //Salimos de incripciones
            OpcionSalir();




        }
    }

    @Test(priority = 64)
    public void DescargarSolicitudDeCompra () throws InterruptedException, IOException{
        // Establece la ruta de descarga
        String rutaDescarga = folderName;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("download.default_directory=" + rutaDescarga);


        // Espera un tiempo suficiente para que se complete la descarga (puedes ajustar este tiempo según sea necesario)
        try {
            Thread.sleep(5000); // Espera 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Visualiza el archivo PDF descargado
        visualizarArchivoPDF(rutaDescarga, "SolicitudDeCompra"+numeroSolicitudDeCompra+".pdf");



    }
    public static void scrollHaciaArriba(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
    private static void visualizarArchivoPDF(String rutaDescarga, String nombreArchivo) {
        // Construye la ruta completa del archivo PDF descargado
        String rutaArchivoPDF = rutaDescarga + File.separator + nombreArchivo;

        // Intenta abrir el archivo PDF con el visor de PDF predeterminado
        try {
            // Abre el archivo PDF con el visor predeterminado (puede variar según el sistema operativo)
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                // En Windows
                Runtime.getRuntime().exec("cmd /c start " + rutaArchivoPDF);
            } else if (System.getProperty("os.name").toLowerCase().contains("nix")
                    || System.getProperty("os.name").toLowerCase().contains("nux")
                    || System.getProperty("os.name").toLowerCase().contains("mac")) {
                // En sistemas basados en Unix (Linux y MacOS)
                Runtime.getRuntime().exec("xdg-open " + rutaArchivoPDF);
            } else {
                throw new UnsupportedOperationException("Sistema operativo no compatible");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void mostrarDatos (String cliente) throws InterruptedException{


    }
    private void BuscarResumenDeMontos ( ) throws InterruptedException{
        //a. Valor Franquicia: Se calcula únicamente si el curso es de Línea Franquicia
        //Cuando no tiene Comité Bipartito
        //Se calculará la sumatoria por cada participante de (valor máximo imputable) * (Franquicia de cada participante / 100).  Teniendo un tope de el valor acordado por participante
        //Cuando tiene Comité Bipartito
        //Se calculará la sumatoria por cada participante de (valor máximo imputable+20% del valor imputable) * (Franquicia de cada participante / 100).  teniendo como tope el Valor máximo Efectivo del curso
        //El porcentaje del valor imputable será un parametro en la base de datos
        //
        WebElement ValorFranquicia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[1]/div/h3")));
        WebElement TituloValorFranquicia = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[1]/div/h2"));
        System.out.println(TituloValorFranquicia.getText()+": "+ValorFranquicia.getText());

        //b. Costo Empresa: Se calculará si es de línea franquicia la sumatoria por cada participante de (Valor acordado participante) - (valor Franquicia)
        //En el caso que sea un curso No franquicia se calcula la sumatoria del valor acordado por participante de cada participante.
        //
        WebElement TitutloCostoEmpresa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[2]/div/h2")));
        WebElement CostoEmpresa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[2]/div/h3")));
        System.out.println(TitutloCostoEmpresa.getText()+": "+CostoEmpresa.getText());


        //c. Total: Se calculará la sumatoria de Costo Empresa y Costo Franquicia.
        //
        WebElement tituloTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[3]/div/h2")));
        WebElement Total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[3]/div/h3")));
        System.out.println(tituloTotal.getText()+": "+Total.getText());

        //d. Costo Viático: Se calculará la sumatoria de los viáticos de los participantes.
        //
        WebElement TituloCostoViatico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[1]/div/h2")));
        WebElement CostoViatico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[1]/div/h3")));
        System.out.println(TituloCostoViatico.getText()+": "+CostoViatico.getText());

        //e. Costo Traslado: Se calculará la sumatoria del traslado de los participantes.
        //
        WebElement TitutloCostoTraslado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[2]/div/h2")));
        WebElement CostoTraslado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[2]/div/h3")));
        System.out.println(TitutloCostoTraslado.getText()+": "+CostoTraslado.getText());

        //f. Participantes: Se calculará el total de participantes cargados.
        WebElement TituloParticipantes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[3]/div/h2")));
        WebElement Participantes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[3]/div/h3")));
        int PArticipantesCantidad = Integer.parseInt(Participantes.getText());
        if (PArticipantesCantidad == ConteoCantidadParticipantes){
            System.out.println(TituloParticipantes.getText()+": "+Participantes.getText());
            //Quedé aqui, comparando la cantidad de participantes que conté al cargar el archivo junto con el resultado que trae la busqueda

        }else {
            System.out.println("No coinciden la cantidad de participantes");
        }
    }
    private static void typeString(Robot robot, String s) {
        for (char c : s.toCharArray()) {
            typeChar(robot, c);
        }
    }
    private static void typeChar(Robot robot, char c) {
        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }
    private static void selectFile(Robot robot) {
        // Implementa la lógica para seleccionar un archivo
        // Puedes usar las teclas de flecha, etc.
    }
    private static void closeFileExplorer(Robot robot) {
        // Implementa la lógica para cerrar la ventana del explorador de archivos
        // Puedes usar Alt + F4, por ejemplo
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
    }
    private static void scrollRight(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Puedes ajustar el valor de '500' según la cantidad de píxeles que deseas desplazarte a la derecha
        js.executeScript("window.scrollBy(500,0)");
    }
    private void seleccionarFechaInicio() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement inputFechaInicio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[1]/div/input")));
        inputFechaInicio.click();
        // Espera a que la página y el calendario se carguen completamente
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div/div/div[2]")));
        ////*[@id="single-spa-application:@CCC/inscriptions"]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]
        // Encuentra todos los elementos que representan las fechas en el calendario
        List<WebElement> fechas = driver.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day')]"));

        // Itera sobre las fechas y selecciona la primera opción disponible
        for (WebElement fecha : fechas) {
            //Aqui agarro el atributo para saber en que estado está
            String valorAriaDisabled = fecha.getAttribute("aria-disabled");
            //Si la fecha está en gris
            if (valorAriaDisabled == null || valorAriaDisabled.equals("true")) {
                //System.out.println(fecha.getText());

                //Si la fecha está en azul, entra
            } else if (valorAriaDisabled.equals("false")) {
                String fechaDisponible = fecha.getAttribute("aria-label");
                WebElement elementoFecha = driver.findElement(By.xpath("//div[contains(@aria-label, '"+fechaDisponible+"')]"));//Busco el boton de la fecha disponible aqui esta el error




                //Scroll hacia arriba
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0, 0);");

                //elementoFecha.click();
                //Click en boton de fecha disponible
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", elementoFecha);

                System.out.println("Fecha seleccionada: " +fechaDisponible);
                break;  // Rompe el bucle después de seleccionar la primera fecha disponible
            }
        }
    }
    private static void seleccionarFechaTermino()throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement FTermino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[1]/div/input")));

        if (FTermino.getAttribute("disabled") == null){
            FTermino.click();
            System.out.println("Presiono fecha de termino");
            // Espera a que la página y el calendario se carguen completamente
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]")));

            // Encuentra todos los elementos que representan las fechas en el calendario
            List<WebElement> fechas = driver.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day')]"));

            // Itera sobre las fechas y selecciona la primera opción disponible
            for (WebElement fecha : fechas) {
                String valorAriaDisabled = fecha.getAttribute("aria-disabled");

                if (valorAriaDisabled == null || valorAriaDisabled.equals("true")) {
                    //System.out.println(fecha.getText());

                } else if (valorAriaDisabled.equals("false")) {
                    String fechaDisponible = fecha.getAttribute("aria-label");
                    WebElement elementoFecha = driver.findElement(By.xpath("//div[contains(@aria-label, '"+fechaDisponible+"')]"));

                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", elementoFecha);

                    /////// Codigo antiguo, lo dejo por si acaso
                            /*Actions actions = new Actions((driver));
                            System.out.println(fechaDisponible);
                            actions.moveToElement(elementoFecha).click();
                            System.out.println("Ya presioné");
                            Thread.sleep(3000);*/


                    ///////////////////codigo antiguo ///////////////////
                    // La fecha está disponible, haz clic en ella
                            /*WebElement fechaDisponible = driver.findElement(By.xpath("//div[contains(@class, '" + fecha.getAttribute("class") + "')]"));
                            wait.until(ExpectedConditions.elementToBeClickable(fechaDisponible)).click();*/
                    System.out.println("Fecha seleccionada: " + fechaDisponible);
                    break;  // Rompe el bucle después de seleccionar la primera fecha disponible


                }


            }

        }else {
            System.out.println("Boton fecha termino no habilitado");
            //driver.quit();
        }






    }

    @AfterSuite
    public void finalizarReporte() {
        // Finalizar y generar el informe ExtentReports
        extent.flush();
    }

    @AfterTest
    public void close () throws InterruptedException {

        //Aqui mostraré todos los resultados que trajo
        System.out.println("Nombre y RUT del cliente:");
        System.out.println("Sucursal: ");
        System.out.println("Código Sence:");
        System.out.println("Valor Acordado por Participantes:");
        System.out.println("Fecha de Inicio y término del curso:");
        System.out.println("Región y Comuna: ");
        System.out.println("Dirección: ");
        System.out.println("Horarios:");
        System.out.println("Cuenta de Financiamiento:");
        System.out.println("Franquicia: ");
        System.out.println("Tipo de contrato: ");
        System.out.println("Modalidad: ");


            //driver.close();
            driver.quit();
            driver.quit();
        // Finalizar el informe y generar el archivo final
        extent.flush();
        }
}
