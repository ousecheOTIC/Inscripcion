package Inscripciones;

import Login.Login_Positivos;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Inscripciones {//Hago la extension de login para hacer la prueba más rapido
    private static ExtentReports extent;

    private ExtentTest test;
    static WebDriverWait wait = Login_Positivos.wait;
    static WebDriver driver = Login_Positivos.driver;
    String valorAcordadoMaximo = "123456789123456";
    public WebElement barraCodigo;
    public WebElement btnValidar;


    ///////////////////// DATOS PARA PRUEBAS
    static String NombreCliente = "";
    static String RutCliente = "";
    static String sucursal = "";
    String tipolinea = "";
    String tipoContrato = "";
    String curso_cuenta2="";
    String codigoSence = ""; //1238013718-- 1238019176 -- 1238017721
    String valorAcordado = "";
    String fechaInicio = "";
    String fechaTermino = "";
    boolean fechaEncontrada = false;
    boolean fechaTerminoEncontrada = false;
    String horaInicio = "";
    String horaTermino = "";
    String horaParcial = "";
    String modalidadCurso = null;
    String agregarHoraInicio = "";
    String agregarHoraTermino = "";
    String regionCurso = null;
    String comunaCurso= null;
    String direccionCursoPresencial= null;
    String comentario= null;
    String tipoCuentaCapacitacion = "Capacitacion";
    String rutClienteFinanciamiento = "264483148";
    public static String numeroSolicitudDeCompra;

    int ConteoCantidadParticipantes = 0;
    List<WebElement> cantidadParticipantes = null;


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
    public static void MenuInscripciones()  {
        // Iniciar el informe para el caso de prueba actual
        extent = new ExtentReports();
        wait = new WebDriverWait(driver, 40);

        //this.test = extent.createTest("TestCase2");


        String urlactual = driver.getCurrentUrl();
        //Hacemos que presione boton independiente de donde esté parado
        if (urlactual.contains("dashboard")) {
            //Presionamos menú inscripciones
            WebElement menuInscripciones = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[2]/div/div/div/ul[1]/li[3]/button")));
            menuInscripciones.click();

        } else if (urlactual.contains("inscriptions")) {
            WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[2]/div/div/div/ul[1]/li[3]/button")));
            System.out.println("Estamos en link de Inscripciones");
            btn.click();
        }



        throw new io.cucumber.java.PendingException();
    }

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
    */
    }

    @And("Ingreso nueva inscripción")
    public void CrearNuevaInscripcion() throws InterruptedException {

        //Presionamos Inscripciones
        //MenuInscripciones();

        //Validamos boton Nueva inscripcion
        WebElement btnNuevaInscripcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/button")));
        if (btnNuevaInscripcion.isDisplayed()) {
            //System.out.println("Veo boton Nueva inscripcion");
            //capturarYAdjuntarCaptura("Captura_NuevaIncripcion");//Caprtura de pantalla
            btnNuevaInscripcion.click();


        } else {
            System.out.println("No aparece el boton Nueva inscripcion");
        }

    }

    @And ("Buscamos cliente a inscribir")
    public void InscripcionCursoConPerfilOtic() throws InterruptedException, IOException {

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

            //Buscamos el nombre del curso en el archivo de DATOS PRUEBAS
            NombreCliente = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 15);
            RutCliente = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 16);

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

                    WebElement PrimerElemento = wait.until(ExpectedConditions.visibilityOf(resultado.get(1)));
                    PrimerElemento.click();
                    break;
                }
                //TODO: hay que hacer una iteración que recorra la lista y seleccione la más parecida
                //Thread.sleep(4000);//Espera necesaria Si la quito se daña la prueba

            } else if (resultado.size() >= 5) {
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
            } else {
                System.out.println("No hay resultados");

            }


        } else {
            System.out.println("No veo mensaje de inscripcion de curso");
        }
    }

    @And ("Buscamos susursal de cliente")
    public static void SucursalDeClienteSeleccionado() throws InterruptedException, IOException {

        //a. Si el cliente seleccionado tiene mas de una sucursal y sus aportes son independientes el usuario visualizara
        // una lista desplegable con las opciones de las sucursales para que pueda seleccionar una de ellas
        WebElement Cliente = wait.until (ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div[2]/h1[2]")));
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
        //capturarYAdjuntarCaptura("Captura_Cliente&Sucursal");//Captura de pantalla


        //Buscamos el nombre del curso en el archivo de DATOS PRUEBAS
        sucursal = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 17);

        sucursales.click();

        //TODO: Lo dejaré así para avanzar pero hace falta controlar cuando el cliente tiene más de una sucursal

    }

    public void OpcionSalir() throws InterruptedException {

        //En la parte inferior de la pantalla el usuario visualizará un botón con la opción "Salir" en el caso que
        // desee salir de la inscripción, si el usuario le da clic en este botón lo regresara a la pantalla principal
        // de inscripción, previamente se mostrará un mensaje de confirmación
        try {
            // Utilizar el tiempo de espera para esperar a la visibilidad del elemento
            By btnSalir = By.className("px-[2.2rem]");

            // Identificar el segundo elemento por su texto
            String segundoElementoTexto = "¿Quieres salir de la inscripción?";
            By segundoElementoSelector = By.xpath("//h1[contains(text(), '" + segundoElementoTexto + "')]");


            // Realizar un bucle para hacer clic en el botón hasta que aparezca el segundo elemento
            while (!elementoPresente(driver, segundoElementoSelector)) {
                hacerClicSiExiste(driver, btnSalir);
            }
            // Realizar acciones adicionales después de que se muestra el segundo elemento
            System.out.println("Segundo elemento encontrado. Realizar acciones adicionales...");

            WebElement btnNoSalir = driver.findElement(By.xpath("//button[contains(text(), 'No Salir')]"));
            btnNoSalir.click();
            System.out.println("Salimos");















            /*//    CODIGO ANTIGUO
                //Validamos mensaje de advertencia
            WebElement msjAdvertencia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), '¿Quieres salir de la inscripción?')]")));
            // Lógica para verificar y hacer clic
            try {
                if (msjAdvertencia.isDisplayed()) {
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
                    //Thread.sleep(5000);
                }else {
                    System.out.println("El elemento no está desplegado. Presionando el elemento.");
                        msjAdvertencia.click();
                    // Agrega aquí tu lógica adicional después de presionar el elemento.
                    }
                } catch (Exception e) {
                    System.out.println("Error al manejar el elemento: " + e.getMessage());
                }*/
        } catch (TimeoutException e) {
            // Manejar la excepción, por ejemplo, imprimir un mensaje
            System.out.println("El botón 'Salir' no está presente o visible dentro del tiempo especificado.");

            // Inicializar SoftAssert
            SoftAssert softAssert = new SoftAssert();

            // Realizar aserciones
            softAssert.assertTrue(false, "Aserción 1 fallida");
            softAssert.assertEquals("Texto esperado", "Texto actual", "Aserción 2 fallida");

            // Verificar todas las aserciones y recopilar resultados
            softAssert.assertAll();
        }
    }

    @And ("Presionamos continuar")
    public void OpcionContinuar()  throws InterruptedException {

        // Opción "Continuar" de la selección de un cliente
        WebElement btnContinuar = wait.until(ExpectedConditions.elementToBeClickable((By.className("mr-[0.2rem]"))));
        if (btnContinuar.isDisplayed()) {
            btnContinuar.click();
            System.out.println("Presionamos Continuar");
        } else {
            System.out.println("No aparece boton Continuar");
        }


    }

    @And ("Seleccionamos tipo de linea")
    public void TiposDeLineaDeTrabajo() throws InterruptedException, IOException {
        //1. Se mostrará el título correspondiente al paso actual, que en este caso es "Tipo de curso".
        //2. El título del paso actual "Tipo de curso" deberá permanecer visible para que el usuario siempre sepa en qué etapa del proceso de inscripción se encuentra.

        WebElement TipoDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Tipo de Curso']"))); //"svg[class='h-6 w-6']"
        String txtEtapa = TipoDeCurso.getText();


        if (txtEtapa.contains("Tipo de Curso")) {
            System.out.println("Estamos en Tipo de Curso");
            //Cuando el usuario ingresa al paso 1, todas las opciones tanto de tipo de línea y tipo de contrato se ven inhabilitadas y cuando selecciona una de las opciones respectivamente estas quedan resaltadas.
            List<WebElement> ListLineas = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("mt-[1.75rem]")));


            //Buscamos los datos en el archivo de DATOS PRUEBAS
            tipolinea = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 11);

            if (ListLineas.size() == 2 || ListLineas.size() == 5) {
                //Cuenta 1
                if (tipolinea.contains("1")) {
                    for (WebElement list : ListLineas) {
                        if (list.getText().contains(tipolinea)) {// Aqui comparo la cadena con el texto de la pagina
                            WebElement btn = list.findElement(By.className("hQWSJn"));
                            btn.click();
                            System.out.println("Seleccionamos la opcion: " + list.getText());
                            break;
                        } else {
                            //System.out.println("No hay opcion que coincida");
                        }
                    }
                    TiposDeContrato_Franquicia();

                }else if (tipolinea.contains("2")){
                    // CUenta 2
                    for (WebElement list : ListLineas) {
                        if (list.getText().contains(tipolinea)) {// Aqui comparo la cadena con el texto de la pagina
                            WebElement btn = list.findElement(By.className("hQWSJn"));
                            btn.click();
                            System.out.println("Seleccionamos la opcion: " + list.getText());
                            break;
                        } else {
                            //System.out.println("No hay opcion que coincida");
                        }
                    }
                    TiposDeContrato_NoFranquicia();
                    this.curso_cuenta2 = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo,34);

                    //BUSCAR CURSO
                    buscarCurso_Cuenta2 (this.curso_cuenta2);

                    //CREAR CODIGO
                }else {
                    System.out.println(("No se encontró el tipo de franquicia a seleccionar"));
                }
            } else {
                System.out.println("No hay suficientes botones ");
            }
        } else {
            System.out.println("Etapa incorrecta");
        }
    }

    private void crearCurso() throws InterruptedException, IOException {
        //Estando en el paso 2, buscamos el boton de "Crear codigo"
        WebElement btnCrearCodigo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/button")));

        //Ingresamoe el nombre del OTEC
        WebElement inputRutOtec = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div[1]/input"));
        String rut_NombreDeCursoNuevo = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo,33);

        inputRutOtec.sendKeys(rut_NombreDeCursoNuevo);




    }

    private void buscarCurso_Cuenta2 (String curso_cuenta2) throws InterruptedException,IOException {
        //Buscamos por nombre o ID
        buscadorDeCursos_Cuenta2(this.curso_cuenta2);

        //Esperamos el resultado
        Thread.sleep(3000);

        List<WebElement> listaResultados = driver.findElements(By.className("fDgyGM"));

        System.out.println("Hay " + listaResultados.size() + " resultados de la busqueda");

        //Validamos si la busqueda fue por nombre o por ID
        if (Character.isLetter(this.curso_cuenta2.charAt(0))) { //SI ES LETRA
            //Iteramos en cada resultado para comparar con la busqueda
            boolean cursoSeleccionado = false;
            for (WebElement resultados : listaResultados) {
                WebElement nombre = resultados.findElement(By.className("fjsilu"));
                //Buscamos la coincidencia as cercana
                if (nombre.getText().toLowerCase().contains(curso_cuenta2.toLowerCase())) {
                    System.out.println("Escogimos la opcion letra: " + nombre.getText());
                    cursoSeleccionado = true;
                    nombre.findElement(By.className("ZwaPh")).click();
                    break;
                }
            }
            //Si no coincide ningun valor de la lista, seleccionamos la primera opcion por defecto
            if (cursoSeleccionado == false) { // SI ES NUMERO
                for (WebElement resultados : listaResultados) {
                    WebElement resultadoXDefecto = resultados.findElement(By.className("fjsilu"));
                    resultadoXDefecto.findElement(By.className("ZwaPh")).click();
                    resultadoXDefecto.click();
                    break;
                }
            }
        }else if (Character.isDigit(this.curso_cuenta2.charAt(0))) {
            for (WebElement resultados : listaResultados) {
                WebElement nombre = resultados.findElement(By.className("hHknmo"));
                //Buscamos la coincidencia as cercana
                if (nombre.getText().toLowerCase().equals(curso_cuenta2.toLowerCase())) {
                    resultados.click();
                    System.out.println("Escogimos la opcion numero: " + resultados.getText());

                }
            }

        }else {
            System.out.println("No es ni letra, ni numero.");

        }

        //AHORA VALIDAMOS EL RESULTADO
        System.out.println("Vemos el resultado");
        informacionCurso_Cuenta2();



    }

    private void informacionCurso_Cuenta2() throws InterruptedException,IOException{
        //BUSCAMOS Y MOS MOSTRAMOS LA INFORMACION DEL CURSO SELECCINADO

        WebElement contenedorInformacionDeCurso = null; //contenedor de informacion de curso
        try {
            contenedorInformacionDeCurso=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cBHfXF")));

            // Verifica si se encontró el elemento
            if (contenedorInformacionDeCurso != null) {
                // Si el elemento se encontró, realiza la acción deseada
                System.out.println("Estamos entrando al if de contenedor");
                //- Nombre del curso.
                WebElement NombreCurso = contenedorInformacionDeCurso.findElement(By.xpath("//p[contains(text(), 'ID Interno')]"));
                String tituloNombreCurso = NombreCurso.findElement(By.tagName("h3")).getText();
                System.out.println(NombreCurso.getText() + ": " + tituloNombreCurso);
                //TODO: QUEDE BUSCANDO LA INFORMACION DEL CURSO UNA VEZ SELECCIONADO



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
                this.modalidadCurso = ModalidadCurso.getText();
                WebElement tituloModalidadCurso = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[1]/div[2]/div/div[3]/div[3]/div/h2"));
                System.out.println(tituloModalidadCurso.getText() + ": " + ModalidadCurso.getText());







            } else {
                // Si el elemento no se encontró, realiza otra acción o muestra un mensaje de error
                System.out.println("No se encontró la información de curso");
            }

        }catch (NoSuchElementException e){
            System.out.println("Esta entrando al catch");



        }



    }

    public static String buscadorDeCursos_Cuenta2 (String elementoBusqueda) throws InterruptedException,IOException {
        //Seleccionamos filtro
        WebElement btnDespliegue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-menu-button-1 > svg")));
        btnDespliegue.click();//Desplegamos opciones

        boolean opcEncontrada = false;

        Thread.sleep(3000);//Espera OBLIGATORIA
        List<WebElement> buscador = driver.findElements(By.cssSelector(".block.px-4.py-4"));
        System.out.println(buscador.size());

        if (buscador.size() == 2) {

            //Aqui quiero validar si es por nombre o ID
            if (Character.isLetter(elementoBusqueda.charAt(0))) {
                System.out.println("Entró a nombre");

                for (WebElement opc : buscador) {
                    String palabraMinuscula = opc.getText().toLowerCase();
                    if (palabraMinuscula.contains("Nombre ded curso".toLowerCase())) {
                        System.out.println("Seleccionamos opcion: " + opc.getText());
                        opc.click(); //Seleccionamos "Nombre de Curso"
                        opcEncontrada = true;
                        break;
                    }
                }

                //Ahora le enviamos el caractacter a buscar
                WebElement IDinput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-select__input")));
                IDinput.clear();
                IDinput.sendKeys(elementoBusqueda);
                //Presionamos Buscar
                WebElement btnBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.className("hJbcKB")));
                btnBuscar.click();


            } else if (Character.isDigit(elementoBusqueda.charAt(0))) {
                System.out.println("Entro a Id");

                for (WebElement opc : buscador) {
                    String palabraMinuscula = opc.getText().toLowerCase();
                    if (palabraMinuscula.contains("ID del curso".toLowerCase())) {
                        System.out.println("Seleccionamos opcion: " + opc.getText());
                        opc.click();//Seleccionamos "ID de Curso"
                        opcEncontrada = true;
                        break;
                    }
                }

                //Ahora le enviamos el caractacter a buscar
                WebElement IDinput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-select__input")));
                IDinput.clear();
                IDinput.sendKeys(elementoBusqueda);
                //Presionamos Buscar
                WebElement btnBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.className("hJbcKB")));
                btnBuscar.click();


            }


            List<WebElement> listaResultados = null;
            WebElement msjErrorBusqueda = null;
            //Ahora esperamos el resultado de la busqueda
            try {
                listaResultados = driver.findElements(By.className("fDgyGM"));

                //Buscamos los resultados


            } catch (org.openqa.selenium.NoSuchElementException e) {
                // Si el elemento no está presente, realizar otra acción
                System.out.println("El elemento no está presente en la página");

                msjErrorBusqueda = driver.findElement(By.className("w-[55%]"));
                System.out.println(msjErrorBusqueda.getText());


            }

/*
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////Filtro Nombre de curso
            if (tipoDeBuscador.toLowerCase().equals("nombre")) {
                //System.out.println("Entramos al if nombre");
                //Valido que la busqueda fue precisa
                //Intercepto el Nombre de cada resultado y lo anexo a una lista
                elementoBusqueda = extraerDatosDeLinea(rutaArchivo, 6);
                Thread.sleep(5000);//Espera necesaria
                WebElement tablaResultados = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody")));
                List<WebElement> resultadoFiltro = driver.findElements(By.className("kAihBX"));
                //System.out.println(resultadoFiltro.size());
                // Itera a través de la lista de elementos
                int cantidadResultadosXNombre = 0;

                for (WebElement listado : resultadoFiltro) {
                    if (resultadoFiltro.size() == 0) {
                        System.out.println("Hay 0 regstros");
                        break;
                    } else {
                        String txtCurso = listado.getText(); // Obtengo el texto del elemento actual en la lista

                        //System.out.println("El curso es: " + txtCurso);//Lo imprimo para validar que está correcto

                        String[] palabraCurso = txtCurso.split("\\s+"); // Dividir por espacios en blanco
                        boolean encontrado = false; // Usamos una bandera para rastrear si encontramos la palabra
                        for (String palabra : palabraCurso) {
                            // Eliminar signos de puntuación alrededor de la palabra (opcional)
                            palabra = palabra.replaceAll("[.,!?]", "");
                            // Comprobar si la palabra actual coincide con la palabra buscada (ignorando mayúsculas/minúsculas)
                            if (elementoBusqueda.contains(palabra)) {
                                encontrado = true; // Encontramos la palabra
                                break; // Sal del bucle si la palabra fue encontrada
                            }
                        }

                        if (encontrado) {
                            //System.out.println("Se encontró la palabra: " + nombreCurso);
                            cantidadResultadosXNombre = cantidadResultadosXNombre + 1;
                        } else {
                            //System.out.println("No se encontró la palabra en el registro");
                            cantidadResultadosXNombre = cantidadResultadosXNombre;

                            //System.out.println(encontrado); //Lo imprimo para validar que dato viene
                        }
                    }
                }
                System.out.println("Hay: " + cantidadResultadosXNombre + " resultados de busqueda por Nombre");


            }
            /////Filtro ID Sence
            else if (tipoDeBuscador.toLowerCase().equals("id")) {
                //System.out.println("Entramos al if id");
                //Valido que la busqueda fue precisa
                //Intercepto el Nombre de cada resultado y lo anexo a una lista
                Thread.sleep(5000);//Espera necesaria
                WebElement tablaResultados = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody")));
                List<WebElement> resultadoFiltro = driver.findElements(By.className("fYMkUI"));

                int cantidadResultados = 0;
                // Itera a través de la lista de elementos
                //System.out.println("-"+resultadoFiltro.size());
                for (WebElement listado : resultadoFiltro) {
                    //System.out.println("- "+listado.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody/tr[1]/td[2]")).getText());
                    System.out.println();
                    if (elementoBusqueda.toLowerCase().equals((CharSequence) listado.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody/tr[1]/td[2]")).getText())) {
                        System.out.println("se encontró el Id en la busqueda");
                        cantidadResultados = cantidadResultados + 1;

                    } else {
                    }
                }
                System.out.println("Hay: " + cantidadResultados + " resultados de busqueda por ID Sence");
                /////Filtro Solicitud de compra
            }
            ////Filtro Solicitud de compra
            else if (tipoDeBuscador.toLowerCase().equals("solicitud")) {
                System.out.println("Entro a if de solicitud");
            } else {
                System.out.println("no hay coincidencia entre la busqueda y los tipo de filtros para buscar");
            }
        }
*/


        }
        return elementoBusqueda;
    }
    //Lo dejé en ese orden para poder continuar cn flujo de inscripcion por codigo Sence
    //@Test(priority = 45)
    public void TiposDeContrato_Franquicia() throws InterruptedException, IOException {
        //Thread.sleep(5000);
        //Seguimos flujo de inscripcion de curso
        List<WebElement> ListLineas = driver.findElements(By.className("mt-[1.75rem]"));

        //Buscamos los datos en el archivo de DATOS PRUEBAS
        tipoContrato = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 12);

        if (ListLineas.size() == 1 || ListLineas.size() == 5) {
            for (WebElement lineas : ListLineas) {
                if (lineas.getText().contains(tipoContrato)) {
                    WebElement btn = lineas.findElement(By.className("hQWSJn"));
                    System.out.println("Seleccionamos la opcion: " + lineas.getText());
                    btn.click();
                    break;
                } else {
                    //System.out.println("No hay opcion que coincida");
                }
            }
        } else {
            System.out.println("No hay suficientes botones ");
        }


        //capturarYAdjuntarCaptura("Captura_FranquiciaYContrato");//Caprtura de pantalla

        OpcionSalir();
        OpcionContinuar();
        System.out.println("Nos pasamos al paso 2");

    }

    //@Test(priority = 44)
    public void TiposDeContrato_NoFranquicia() throws InterruptedException, IOException {
        Thread.sleep(2000);
        //Tomamos todos los elementos presentes con la misma clase
        List<WebElement> botones = driver.findElements(By.className("mt-[1.75rem]"));

        //Buscamos los datos en el archivo de DATOS PRUEBAS
        tipolinea = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 11);
        System.out.println(tipoContrato);
        if (tipolinea.contains("2") || tipolinea.contains("No")) {
            WebElement segundoElemento = botones.get(1);//tomamos el segundo boton (No Franquicia)
            segundoElemento.click();

            WebElement btncursoInterno = botones.get(2);//Seleccionamos Curso interno
            btncursoInterno.getText();
            btncursoInterno.click();


        } else {
            System.out.println("No se seleccionó cuenta 2");
        }

        OpcionSalir();
        OpcionContinuar();
        //System.out.println("Nos pasamos al paso 2");

    }

    //Este metodo busca la barra para ingresar coidgo sence
    @Test(priority = 46)
    @And ("Pasamos al paso 2")
    public void IngresoPaso2Inscripcion() throws InterruptedException {

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
    @And ("Ingresamos codigo Sence")
    public void LongitudYValidacionCodigoSence() throws InterruptedException, IOException {
        this.barraCodigo = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[1]/input"));

        //1. Longitud de 10 digitos la cual tendrá un mensaje informativo.
        //barraCodigo.sendKeys(ingresoLetras);
        this.btnValidar = driver.findElement(By.xpath("//button[text()='Validar']"));

        //Buscamos el nombre del curso en el archivo de DATOS PRUEBAS
        codigoSence = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 18);
        System.out.println(codigoSence);
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
    @And ("Valido informacion de curso validado")
    public void ValidadoCorrectamenteCodigoSence() throws InterruptedException, IOException {

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
        this.modalidadCurso = ModalidadCurso.getText();
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
        //capturarYAdjuntarCaptura("Captura_BusquedaDeCursoAInscribir");//Caprtura de pantalla


    }

    //comentado para hacer la prueba más corta
    @Test(priority = 49)
    public void EditarCodigoSence() throws InterruptedException {
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

        */
    }

    @Test(priority = 50)
    @And ("Ingreso valor acordado participante")
    public void ValorAcordadoParticipante() throws InterruptedException, IOException {
        //1. Si la Validación del Código Sence fue Exitosa (Paso 2 de la inscripción Linea trabajo Franquicia), se desplegara un input para que el usuario pueda ingresar el valor acordado por participante con el OTEC debajo de la sección información del curso
        //
        WebElement valorAcordadoInput = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[3]/div[1]/div/input"));
        valorAcordadoInput.sendKeys(valorAcordadoMaximo);

        //2. Se limita largo del campo por la configuración de la longitud en BBDD a 14 caracteres
        //Le envié 15 numeros para comprobar que anota solo 14
        int longitudInputValor = 14;
        String valor = valorAcordadoInput.getAttribute("value").replace(".", "");//Tomo el valor del input y le quito los puntos al String
        //System.out.println(valor); //Imprimo el valor

        if (valor.length() == longitudInputValor) {
            System.out.println("Cantidad de valores correcta");

        } else if (valor.length() > longitudInputValor) {
            System.out.println("Cantidad de valores mayor ");
        } else if (valor.length() < longitudInputValor) {
            System.out.println("Cantidad de valores menor ");
        }

        //Le enviamos un valor normal para contuinuar con la prueba
        valorAcordadoInput.clear();

        //Buscamos el nombre del curso en el archivo de DATOS PRUEBAS
        valorAcordado = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 19);

        valorAcordadoInput.sendKeys(valorAcordado);//Le enviamos el valor acordado
        //capturarYAdjuntarCaptura("Captura_ValorAcordadoParticipante");//Caprtura de pantalla

        //Presionamos continuar
        OpcionContinuar();

    }

    @Test(priority = 51)
    public void Opciones_Salir_Volver_Continuar() throws InterruptedException, IOException {
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
    @And ("Ingreso fecha de inicio y termino del curso")
    public void Ingresos_Fechas_inicio_y_termino_del_curso() throws InterruptedException, IOException {
        OpcionContinuar();//Coloco esto porque comenté la opcion de arriba


        //1. El usuario al ingresar al paso 3 verá un mensaje informativo que le solicita ingresar la fecha de inicio y termino del curso.
        //
        Thread.sleep(2000);//Espera de prueba
        WebElement paso3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[1]/div[2]/span")));
        String txtpaso3 = paso3.getText();

        if ("Horarios".equals(txtpaso3)) {

                //Buscamos la fecha del curso en el archivo de DATOS PRUEBAS
                fechaInicio = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 20);
                seleccionarFechaInicio(fechaInicio);
                //Buscamos la fecha del curso en el archivo de DATOS PRUEBAS
                fechaTermino = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 21);
                seleccionarFechaTermino(fechaTermino);
            if (fechaEncontrada==true&&fechaTerminoEncontrada==true){
                System.out.println("Escogimos las fechas");
                //capturarYAdjuntarCaptura("Captura_FechasDeCurso");//Caprtura de pantall

                //Si es curso presencial aparecerán las opciones para escoger direccion

                if (this.modalidadCurso.equals("Presencial")){
                    seleccionarDireccion_CursoPresencial();
                    //capturarYAdjuntarCaptura("Captura_DireccionCursoPresencial");//Caprtura de pantalla



                }else if (this.modalidadCurso.equals("E-learning")){
                    System.out.println("CURSO E-LEARNING");

                }
            }else {
                System.out.println("No se encontraron ambas fechas");


            }

            }
        }

    @Test(priority = 53)
    @And ("Ingreso hora de inicio y termino del curso")
    public void IngresoHoraInicioYHoraTermino() throws InterruptedException, IOException {

        //Tomamos las horas del archivo
        this.horaInicio = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 22);
        this.horaTermino = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 23);

        //Seleccionamos las horas del curso dependiendo del tipo de curso
        if (modalidadCurso.equals("Presencial")){
            seleccionarHorasCursoPresencial();

        }else {
            seleccionarHorasCursoElearning();
        }


        }
    @Test(priority = 54)
    @And ("Ingreso dias de curso")
    public void IngresarJornada1() throws InterruptedException, IOException {
        //1. El usuario podrá seleccionar el horario correspondiente al dial de la semana del día que inicia el curso.
        //2. Se verá un mensaje en la parte superior del la selección de los horarios donde indica el día en el que inicia el curso con el correspondiente día de la semana.
        //3. El usuario podrá seleccionar mas de un día de la semana para repetir el horario indicado, esta acción la podrá realizar al hacer clic sobre la inicial del día de la semana,  el usuario verá un mensaje informativo que le indica que el horario  se repetirá para los días seleccionados semanalmente
        // Selección de todos los días de la semana
        WebElement textoTodosLosDias = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Selecciona todos los días')]")));
        List <WebElement> btnTodosLosDias=driver.findElements(By.className("kklWZT"));
        //btnTodosLosDias.click();
        btnTodosLosDias.get(0).click();
        // Exclusión de días feriados
        //WebElement btnOmitirFeriados = driver.findElement(By.className("hEwecx"));
        //btnOmitirFeriados.click();
        btnTodosLosDias.get(1).click();
        //Borrar Horario
        //TODO: Hacer la logica para validar si esta vacio los campos los vuelva a llenar

        //WebElement btnLimpiarHorario = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[8]/button[1]"));
        //btnLimpiarHorario.click();

        //TODO: CREAR LOGICA QUE PERMITA PASAR POR TODOS LOS DIAS Y SELECCIONAR AL AZAR


        // Opción "Guardar Horario"
        WebElement btnGuardarCambios = driver.findElement(By.xpath("//button[contains(span/text(), 'Guardar horario')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnGuardarCambios);

        if (btnGuardarCambios.isDisplayed()) {
            //capturarYAdjuntarCaptura("Captura_HorariosDeCurso");//Caprtura de pantalla

            btnGuardarCambios.click();

        }

    }

    @Test(priority = 56)
    @And ("Selecciono horario y comentarios")
    public void seleccionarHorario_Comentarios() throws InterruptedException, IOException {
        //En caso que el usuario le de clic en continuar y exista horas ingresadas que se pasen o faltes   a las que debe tener el curso y no tenga comentario , se debe mostrar un mensaje informativo para que recuerde ingresar el comentario
        //Si aparece la casilla parcial complementario hacemos:
        // Intentar encontrar el elemento sin esperar
        Thread.sleep(2000);//Espera necesaria

       WebElement parcial_Complementario = null;
        try {
            parcial_Complementario = driver.findElement(By.xpath("//p[contains(text(), 'Parcial')]/ancestor::div[@class='w-64']"));

            // Si el elemento está presente, hacer algo
            //System.out.println("El elemento está presente. Continuar con el flujo A.");

            this.horaParcial = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo,26);
            if (this.horaParcial.isEmpty()){
                System.out.println("Campo hora parcial vacio en archivo");

            }else {
                WebElement parcial = parcial_Complementario.findElement(By.name("CLP"));
                parcial.clear();
                parcial.sendKeys(this.horaParcial);
                System.out.println("Colocamos hora parcial: "+this.horaParcial);
            }


            //1. Una vez que se haya ingresado al menos una jornada de capacitación, se habilitará un campo de comentarios adicionales.
            //
            WebElement AreatxtComentarios = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/textarea")));
            this.comentario= Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo,30);
            AreatxtComentarios.sendKeys(this.comentario);


            //3. El campo de comentarios adicionales tendrá un límite máximo de 1500 caracteres.
            //
            String CapacidadDeTexto = AreatxtComentarios.getAttribute("maxlength");
            if (CapacidadDeTexto.equals("1500")) {
                System.out.println("Cantidad de caracteres correcto");
            }



        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Si el elemento no está presente, hacer algo diferente
            System.out.println("El elemento no está presente. Continuar con el flujo B.");
            //1. Una vez que se haya ingresado al menos una jornada de capacitación, se habilitará un campo de comentarios adicionales.
            //
            WebElement AreatxtComentarios = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/textarea")));
            this.comentario= Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo,30);
            AreatxtComentarios.sendKeys(this.comentario);
            //3. El campo de comentarios adicionales tendrá un límite máximo de 1500 caracteres.
            //
            String CapacidadDeTexto = AreatxtComentarios.getAttribute("maxlength");
            if (CapacidadDeTexto.equals("1500")) {
                System.out.println("Cantidad de caracteres correcto");
            }
        }




        //4. El campo de comentarios adicionales tendrá un scroll en caso de que el texto introducido supere el área visible.
        //
        //5. Esto permitirá que los usuarios puedan desplazarse y leer to do el contenido del comentario, incluso si es más largo de lo que se muestra inicialmente.

        //Probamos los botones
        //Salir
        OpcionSalir();

        //Opcion Volver


        //capturarYAdjuntarCaptura("Captura_Horario&LlenadoDeInformacionAdicional");//Caprtura de pantalla

        //Opcion continuar
        OpcionContinuar();
    }

    @Test(priority = 57)
    @And("Cargamos participantes")
    public void CargaMasivadeparticipantes() throws InterruptedException, AWTException, IOException {
        Thread.sleep(5000);
        //capturarYAdjuntarCaptura("Captura_Paso4_Participantes"); // Captura de pantalla
        Thread.sleep(5000);

        // 1. En la plataforma, se proporcionará un cuadro donde el usuario puede arrastrar el archivo que contiene los datos de los participantes.
        //
        WebElement AgregarArchivo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bGgmkt")));
        AgregarArchivo.click();

        // 2. El cuadro de carga aceptará únicamente un solo archivo a la vez.
        //
        // 3. Si el usuario prefiere seleccionar el archivo en lugar de arrastrarlo, al hacer clic sobre el cuadro de carga, se abrirá la librería de su equipo para que seleccione el archivo deseado.
        //

        try {
            // Ejecuta el script de AutoIt para seleccionar el archivo
            Runtime.getRuntime().exec("path_al_script\\SeleccionarArchivo.exe nombre_del_archivo.xlsx");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierra el navegador al finalizar
            // driver.quit();
            System.out.println("Seleccionamos el archivo ");
        }
    }
    @Test(priority = 58)
    @And ("Visualizo participantes")
    public void VisualizacionDeRegistros() throws InterruptedException, IOException {

        try {
            //1. Después de cargar el archivo  Excel, se mostrará una previsualización de los registros de participantes.
            //
            WebElement pantallaEmergenteParticipantes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[11]/div/div/div[2]")));
            //2. Se mostrarán todos los registros cargados, con la posibilidad de desplazarse verticalmente utilizando un scroll.
            //
            cantidadParticipantes = driver.findElements(By.className("CutUQ"));//Buscamos la tabla de datos
            ConteoCantidadParticipantes = cantidadParticipantes.size();
            System.out.println("En el archivo hay " + cantidadParticipantes.size() + " participantes");

            //WebElement NombreParticipantes = cantidadParticipantes.get(0);
            List<WebElement> DatosParticipantes = driver.findElements(By.className("hGmhdP"));
            //System.out.println(DatosParticipantes.get(3).getText());


            //3. Todas las columnas del archivo, incluyendo las columnas opcionales, se mostrarán en la previsualizació
            // Scroll vertical y horizontal
            // Realiza un scroll a la derecha utilizando JavaScript
            scrollRight(driver);
            //capturarYAdjuntarCaptura("Captura_Carga_Participantes_scrollIzquierda");//Captura de pantalla
            //1. Los títulos de la tabla de previsualización permanecerán fijos en la parte superior al realizar el scroll vertical.
            //
            //2. Los títulos en la grilla tendrán la opción de ordenamiento ascendente o descendente
            //if (WebElement ErrorDeCarga = driver.findElement(By.className("gWBTIn")).isDisplayed()){

            List<WebElement> Titulos = driver.findElements(By.className("LdkzEXp"));

        } catch (TimeoutException e) {
            // Inicializar SoftAssert
            SoftAssert softAssert = new SoftAssert();

            // Realizar aserciones
            softAssert.assertTrue(false, "Aserción 1 fallida");
            softAssert.assertEquals("Texto esperado", "Texto actual", "Aserción 2 fallida");

            // Verificar todas las aserciones y recopilar resultados
            softAssert.assertAll();

        }
    }

    @Test(priority = 59)
    @And ("Confirmamos carga exitosa")
    public void ConfirmacionCargaExitosa() throws InterruptedException {
//1. Si el usuario realiza la confirmación de carga (hace clic en "Guardar"), se mostrará un mensaje de carga exitosa. Luego de la carga exitosa, el usuario permanecerá en la misma pantalla de previsualización de participantes cargados con la opción de "Salir".
//
        WebElement btnGuardarCarga = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[11]/div/div/div[3]/div[2]/div/div[1]/button"));
        if (btnGuardarCarga.isDisplayed()) {
            btnGuardarCarga.click();  //PResionamos boton Guardar

        } else {
            Thread.sleep(5000);
            driver.quit();
        }
    }

    @Test(priority = 60)
    @And ("Validamos montos de calculo por participantes")
    public void ResumenDeMontos() throws InterruptedException, IOException {
        BuscarResumenDeMontos();
        //capturarYAdjuntarCaptura("Captura_Carga_Montos_Participantes");//Caprtura de pantalla
    }

    @Test(priority = 61)
    @And ("")
    public void VerParticipantesCargados() throws InterruptedException, IOException {
        //1. En la pantalla principal, se incluirá un botón claramente visible y accesible para el usuario, con el texto "Ver Listado de Participantes". en caso de ya existir una carga previa realizada
        //
        WebElement btnVerListadoPArticipantes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[10]/div/button")));
        if (btnVerListadoPArticipantes.isDisplayed()) {
            btnVerListadoPArticipantes.click();//Presionamos el boton

            //2. Al hacer clic sobre el botón, se mostrará el listado de los participantes cargados en una nueva de previsualización.
            //

            cantidadParticipantes = driver.findElements(By.className("CutUQ"));//Buscamos la tabla de datos
            System.out.println(cantidadParticipantes.size());

            //3. El listado de participantes mostrará todos los registros cargados, con la posibilidad de desplazarse verticalmente utilizando un scroll si es necesario. La información mostrada incluirá todos los campos de cada participante.
            //


            //4. Solo se visualizara la información de los participantes y no se podrá realizar acciones de edición o eliminación

            WebElement btnSalirListadoParticipantes = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[12]/div/div/div[3]/div[2]/div/div[2]/button"));
            if (btnSalirListadoParticipantes.isDisplayed()) {
                //capturarYAdjuntarCaptura("Captura_NuevaIncripcion");//Captura de pantalla

                btnSalirListadoParticipantes.click();
            } else {
                System.out.println("No aparece boton salir");
            }
        } else {
            System.out.println("No aparece boton 'Ver listado de participantes' ");
        }


        //Presionamos continuar para avanzar
        Thread.sleep(5000);//Espera de prueba
        OpcionContinuar();
    }

    @Test(priority = 62)
    @And ("Seleccionamos la cuenta de financiamiento")
    public void TipoCuentaFinanciamiento() throws InterruptedException, IOException {
        //Validar que estamos en el paso 5
        WebElement Paso5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[2]/div[1]")));
        System.out.println(Paso5.getText());
        if (Paso5.isDisplayed() && Paso5.getText().equals("5")) {
            System.out.println("Estamos en el Paso 5");


            //Validamos OpcionSalir
            OpcionSalir();

            //OpcionVolver
            WebElement btnVolver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[8]/div/div[2]/button")));
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
            System.out.println(CapacitacionAlAño.getText() + ": " + ValorCapacitacionAlAño.getText());

            //- Excedente Capacitación
            //
            WebElement ExcedenteCapacitacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[2]/div[2]/div/button/p[1]")));
            WebElement ValorExcedenteCapacitacion = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[7]/div[2]/div[2]/div/button/p[2]"));
            System.out.println(ExcedenteCapacitacion.getText() + ": " + ValorExcedenteCapacitacion.getText());

            if (CapacitacionAlAño.isDisplayed() && ExcedenteCapacitacion.isDisplayed()) {
                //System.out.println("Estan ambos botones");
                CapacitacionAlAño.click();
                ValorExcedenteCapacitacion.click();//OPCION A SELECCIONAR CUENTA

            } else if (CapacitacionAlAño.isDisplayed()) {
                CapacitacionAlAño.click();
                if (ExcedenteCapacitacion.isDisplayed()) {
                    ExcedenteCapacitacion.click();
                } else {
                    System.out.println("Falta uno de los botones");
                }
            }
            //2. El usuario solo podrá seleccionar una cuenta de financiamiento de entre las opciones disponibles.
            //
            //3. En la parte superior de la cuenta de financiamiento se visualizara los montos del curso mostrados en el paso 4
            By clientefinanciamenientoInput = By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[6]/div[1]/input");

            if (elementoPresente(driver, clientefinanciamenientoInput)) {
                //clientefinanciamenientoInput.sendKeys(rutClienteFinanciamiento);
                System.out.println("Si aparece el boton");

            }


        } else {
            System.out.println("No se visualiza el paso 5");
        }
    }

    @Then("Presionamos boton inscribir curso")
    public void InscribirCurso() throws InterruptedException, IOException {
        wait =  new WebDriverWait(driver, 60);
        //WebElement btnValidarCliente = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[7]/div[6]/div[2]/button"));
        //capturarYAdjuntarCaptura("Captura_CuentaFinanciamiento");//Captura de pantalla
        //Buscamos boton Inscribir
        WebElement btnInscribir = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[8]/div/div[3]/button")));
        btnInscribir.click();
        Thread.sleep(40000);//Espera necesaria para que cargue la pagina despues de inscribir curso
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Inscripción de curso realizada']"))).isDisplayed()) {


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
            numeroSolicitudDeCompra = numerosExtraidos;


            //Captura
            //capturarYAdjuntarCaptura("Captura_Descargar_solicitud_Compra");//Captura de pantalla

            //Descargamos la solicitud de compra
            descargarArchivos();


            Thread.sleep(5000);

            //Salimos de incripciones
            OpcionSalir();


        }
    }

    @Test(priority = 64)
    public void DescargarSolicitudDeCompra() throws InterruptedException, IOException {
        /*// Establece la ruta de descarga
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
        visualizarArchivoPDF(rutaDescarga, "SolicitudDeCompra" + numeroSolicitudDeCompra + ".pdf");
        */

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
    public void descargarArchivos() throws InterruptedException, IOException{
        //Hacemos un conteo de los botones "Descargar" que hayan en la pantalla.

        //Esperamos que aparezca el contenedor de los archivos a descargar
        WebElement contenedorArchivosDescarga = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]")));

        List <WebElement> solicitudesParaDescargar = contenedorArchivosDescarga.findElements(By.className("rounded-2xl"));

        System.out.println("Hay: "+solicitudesParaDescargar.size()+" solicitudes de compra para descargar");
        for (WebElement sc: solicitudesParaDescargar){
            WebElement nombreArchivo = sc.findElement(By.className("basis-full"));
            //System.out.println(nombreArchivo.getText());

            WebElement nrSolicitud= sc.findElement(By.className("shrink-0"));
            //System.out.println(nrSolicitud.getText());

            //Presionamos boton "Descargar"
            WebElement btnDescargar = sc.findElement(By.xpath("//button[contains(text(), 'Descargar')]"));
            btnDescargar.click();

        }
    }
    private void mostrarDatos(String cliente) throws InterruptedException {


    }

    private void BuscarResumenDeMontos() throws InterruptedException {
        //a. Valor Franquicia: Se calcula únicamente si el curso es de Línea Franquicia
        //Cuando no tiene Comité Bipartito
        //Se calculará la sumatoria por cada participante de (valor máximo imputable) * (Franquicia de cada participante / 100).  Teniendo un tope de el valor acordado por participante
        //Cuando tiene Comité Bipartito
        //Se calculará la sumatoria por cada participante de (valor máximo imputable+20% del valor imputable) * (Franquicia de cada participante / 100).  teniendo como tope el Valor máximo Efectivo del curso
        //El porcentaje del valor imputable será un parametro en la base de datos
        //
        WebElement ValorFranquicia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[1]/div/h3")));
        WebElement TituloValorFranquicia = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[1]/div/h2"));
        System.out.println(TituloValorFranquicia.getText() + ": " + ValorFranquicia.getText());

        //b. Costo Empresa: Se calculará si es de línea franquicia la sumatoria por cada participante de (Valor acordado participante) - (valor Franquicia)
        //En el caso que sea un curso No franquicia se calcula la sumatoria del valor acordado por participante de cada participante.
        //
        WebElement TitutloCostoEmpresa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[2]/div/h2")));
        WebElement CostoEmpresa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[2]/div/h3")));
        System.out.println(TitutloCostoEmpresa.getText() + ": " + CostoEmpresa.getText());


        //c. Total: Se calculará la sumatoria de Costo Empresa y Costo Franquicia.
        //
        WebElement tituloTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[3]/div/h2")));
        WebElement Total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[3]/div/h3")));
        System.out.println(tituloTotal.getText() + ": " + Total.getText());

        //d. Costo Viático: Se calculará la sumatoria de los viáticos de los participantes.
        //
        WebElement TituloCostoViatico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[1]/div/h2")));
        WebElement CostoViatico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[1]/div/h3")));
        System.out.println(TituloCostoViatico.getText() + ": " + CostoViatico.getText());

        //e. Costo Traslado: Se calculará la sumatoria del traslado de los participantes.
        //
        WebElement TitutloCostoTraslado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[2]/div/h2")));
        WebElement CostoTraslado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[2]/div/h3")));
        System.out.println(TitutloCostoTraslado.getText() + ": " + CostoTraslado.getText());

        //f. Participantes: Se calculará el total de participantes cargados.
        WebElement TituloParticipantes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[3]/div/h2")));
        WebElement Participantes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[3]/div/h3")));
        int PArticipantesCantidad = Integer.parseInt(Participantes.getText());
        if (PArticipantesCantidad == ConteoCantidadParticipantes) {
            System.out.println(TituloParticipantes.getText() + ": " + Participantes.getText());
            //Quedé aqui, comparando la cantidad de participantes que conté al cargar el archivo junto con el resultado que trae la busqueda

        } else {
            System.out.println("No coinciden la cantidad de participantes");
        }
    }

    public static void typeString(Robot robot, String s) {
        for (char c : s.toCharArray()) {
            typeChar(robot, c);
        }
    }
    public void Agregar_Otra_Hora_Franja_Horaria() throws InterruptedException {
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
        if (btnGuardarCambios.isDisplayed()) {
            btnGuardarCambios.click();
        }

    }
    private static void typeChar(Robot robot, char c) {
        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }

    public static void selectFile(Robot robot) {
        // Implementa la lógica para seleccionar un archivo
        // Puedes usar las teclas de flecha, etc.
    }

    public static void closeFileExplorer(Robot robot) {
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

    private String seleccionarFechaInicio(String fechaInicio) throws InterruptedException {
        //TODO: quedé aqui intentando hacer la logica que seleccione las fechas y agregue la direccion para los casos de cursos presenciales
        WebElement inputFechaInicio = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Fecha de Inicio']")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", inputFechaInicio);
        // Espera a que la página y el calendario se carguen completamente
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div/div/div[2]")));
        ////*[@id="single-spa-application:@CCC/inscriptions"]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]

        // Encuentra todos los elementos que representan las fechas en el calendario
        List<WebElement> fechas = driver.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day')]"));//Buscamos el elemento para desplegar
        //System.out.println("Antes de transformar la fecha: "+fechaInicio);
        this.fechaInicio = transformarFecha(this.fechaInicio);//transformamos la feha de 18/07/2024 a 18 de enero de 2024 para poder buscarla en el calendario

        //System.out.println(fechas.size());

        while (!fechaEncontrada) {
            //System.out.println("Se supone que aqui ya esta transformada: "+this.fechaInicio);

            for (WebElement fecha : fechas) {
                String valorAriaDisabled = fecha.getAttribute("aria-disabled");//Aqui busco el elemento

                if (valorAriaDisabled == null || valorAriaDisabled.equals("true")) {
                    // La fecha está en gris (no disponible)
                } else if (valorAriaDisabled.equals("false")) {

                    String fechaDisponible = fecha.getAttribute("aria-label");
                    //System.out.println(fechaDisponible);//Para saber que fechas esta iterando
                    //System.out.println("La fecha a comparar es: "+fechaInicio);


                    if (fechaDisponible.contains(this.fechaInicio)) {
                        // Encuentra el elementoFecha usando el XPath con la fecha específica
                        WebElement elementoFecha = driver.findElement(By.xpath("//div[contains(@aria-label, '" + fechaDisponible + "')]"));

                        // Scroll hacia arriba
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("window.scrollTo(0, 0);");

                        // Hacer clic en el botón de la fecha disponible
                        //JavascriptExecutor executor = (JavascriptExecutor) driver;
                        executor.executeScript("arguments[0].click();", elementoFecha);

                        //Aqui solo seleccionamos la parte de la cadena que contiene la fecha seleccionada
                        String[] partes = fechaDisponible.split(",");
                        fechaDisponible = partes[1].trim();

                        System.out.println("Fecha de inicio seleccionada: " + fechaDisponible);
                        fechaEncontrada = true;
                        break;  // Rompe el bucle después de seleccionar la fecha
                    }
                }


            }
            // Si no se encuentra la fecha, hacer clic en el botón para pasar al siguiente mes
            if (!fechaEncontrada) {
                WebElement btnSiguienteMes = null;
                boolean btnsiguienteMesPresionado = false;
                while (btnsiguienteMesPresionado==false){
                    try {
                        btnSiguienteMes = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/button[2]"))));
                        ////*[@id="single-spa-application:@CCC/inscriptions"]/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/button[2]
                        ////*[@id="single-spa-application:@CCC/inscriptions"]/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/button[1]
                        Actions actions = new Actions(driver);
                        actions.moveToElement(btnSiguienteMes).perform();
                        // Intentar hacer clic en el elemento
                        //System.out.println("Entramos al try");
                        btnSiguienteMes.click();
                        //System.out.println("Clic realizado con éxito.");
                        btnsiguienteMesPresionado=true;

                    } catch (org.openqa.selenium.ElementNotInteractableException e) {
                        // Manejar la excepción en caso de que el elemento no sea clickeable
                        System.out.println("El elemento no es clickeable. Realizar acciones alternativas.");

                        // Puedes agregar aquí acciones alternativas, como hacer clic con JavaScript o realizar otras operaciones
                        // Por ejemplo, hacer clic usando JavaScript
                        hacerClicConJavaScript(btnSiguienteMes);
                    }

                    // Actualizar la lista de fechas después de cambiar al siguiente mes
                    fechas = driver.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day')]"));
                }



                /*WebElement btnSiguienteMes = driver.findElement(By.cssSelector("#single-spa-application\\:\\@CCC\\/inscriptions > div > div.grid.grid-cols-12.sm\\:mx-16.mx-\\[32px\\].mt-\\[9rem\\].gap-\\[1\\.75rem\\].flex-grow > div.sc-bcXHqe.dqlVec > div.grid.grid-cols-9.md\\:grid.lg\\:grid.xl\\:grid.md\\:grid-cols-9.lg\\:grid-cols-9.xl\\:grid-cols-9 > div > div.gap-4.flex.items-center.justify-start > div:nth-child(1) > div > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header.react-datepicker__header--custom > div.sc-gKPRtg.eNakIz > button:nth-child(3) > svg"));
                btnSiguienteMes.click(); //

                // Actualizar la lista de fechas después de cambiar al siguiente mes
                fechas = driver.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day')]"));*/

            }

        }
        return this.fechaInicio;
    }

    private String seleccionarFechaTermino(String fechaTermino)throws InterruptedException {

            WebElement FTermino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[1]/div/input")));
            FTermino.click();

            //Contenedor
            WebElement calendarContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]")));
            //Lista de fechas
            List<WebElement> fechasTermino = calendarContainer.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day')]"));
            this.fechaTermino = transformarFecha(this.fechaTermino);


            while (fechaTerminoEncontrada == false){
                for (WebElement fecha : fechasTermino) {
                    String valorAriaDisabled = fecha.getAttribute("aria-disabled");
                    //System.out.println(fecha.getText());
                    //System.out.println(valorAriaDisabled);

                    if (valorAriaDisabled == null || valorAriaDisabled.equals("true")) {
                        // The date is in grey (not available)
                    } else if (valorAriaDisabled.equals("false")) {
                        // Your existing logic here
                        String fechaDisponible = fecha.getAttribute("aria-label");
                        //System.out.println(fechaDisponible);//Para saber que fechas esta iterando
                        //System.out.println("La fecha a comparar es: "+fechaInicio);
                        if (fechaDisponible.contains(this.fechaTermino)) {
                            // Encuentra el elementoFecha usando el XPath con la fecha específica
                            WebElement elementoFecha = driver.findElement(By.xpath("//div[contains(@aria-label, '" + fechaDisponible + "')]"));
                            // Scroll hacia arriba
                            JavascriptExecutor js = (JavascriptExecutor) driver;
                            js.executeScript("window.scrollTo(0, 0);");
                            // Hacer clic en el botón de la fecha disponible
                            JavascriptExecutor executor = (JavascriptExecutor) driver;
                            executor.executeScript("arguments[0].click();", elementoFecha);

                            //Aqui solo seleccionamos la parte de la cadena que contiene la fecha seleccionada
                            String[] partes = fechaDisponible.split(",");
                            fechaDisponible = partes[1].trim();

                            System.out.println("Fecha de termino seleccionada: " + fechaDisponible);
                            fechaTerminoEncontrada = true;
                            break;  // Rompe el bucle después de seleccionar la fecha

                        }

                    }
                }
                if (fechaTerminoEncontrada == false) {

                    WebElement btnSiguienteMes = null;
                    boolean btnsiguienteMesPresionado = false;
                    while (btnsiguienteMesPresionado==false){
                        try {
                            btnSiguienteMes = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/button[2]"))));
                            //*[@id="single-spa-application:@CCC/inscriptions"]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/button[2]/svg  //Codigo antiguo
                            //*[@id="single-spa-application:@CCC/inscriptions"]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/button[2]
                            Actions actions = new Actions(driver);
                            actions.moveToElement(btnSiguienteMes).perform();
                            // Intentar hacer clic en el elemento
                            System.out.println("Entramos al try");
                            btnSiguienteMes.click();
                            System.out.println("Clic realizado con éxito.");
                            btnsiguienteMesPresionado=true;

                        } catch (org.openqa.selenium.ElementNotInteractableException e) {
                            // Manejar la excepción en caso de que el elemento no sea clickeable
                            System.out.println("El elemento no es clickeable. Realizar acciones alternativas.");

                            // Puedes agregar aquí acciones alternativas, como hacer clic con JavaScript o realizar otras operaciones
                            // Por ejemplo, hacer clic usando JavaScript
                            hacerClicConJavaScript(btnSiguienteMes);
                        }

                        // Actualizar la lista de fechas después de cambiar al siguiente mes
                        fechasTermino = driver.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day')]"));
                    }


                }
            }

        return fechaTermino;

        // CODIGO ANTIGUO
        /*WebElement FTermino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[1]/div/input")));
        FTermino.click();

        //System.out.println("Presiono fecha de termino");
        // Espera a que la página y el calendario se carguen completamente
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]")));

        // Encuentra todos los elementos que representan las fechas en el calendario
        List<WebElement> fechasTermino = driver.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day')]"));
        this.fechaTermino = transformarFecha(this.fechaTermino);//transformamos la fecha de 18/07/2024 a 18 de enero de 2024 para poder buscarla en el calendario
        boolean fechaTerminoEncontrada = false;
        System.out.println(fechasTermino.size());

        while (!fechaTerminoEncontrada) {
            //System.out.println("Se supone que aqui ya esta transformada: "+this.fechaInicio);
            for (WebElement fecha : fechasTermino) {
                //TODO: EL ERROR ESTA DE AQUI PARA ABAJO
                String valorAriaDisabled = fecha.getAttribute("aria-disabled");//Aqui busco el elemento
                System.out.println("Llega aqui");
                System.out.println(valorAriaDisabled);
                if (valorAriaDisabled == null || valorAriaDisabled.equals("true")) {
                    // La fecha está en gris (no disponible)

                } else if (valorAriaDisabled.equals("false")) {
                    String fechaDisponible = fecha.getAttribute("aria-label");
                    System.out.println(fechaDisponible);//Para saber que fechas esta iterando
                    //System.out.println("La fecha a comparar es: "+fechaInicio);
                    if (fechaDisponible.contains(this.fechaTermino)) {
                        // Encuentra el elementoFecha usando el XPath con la fecha específica
                        WebElement elementoFecha = driver.findElement(By.xpath("//div[contains(@aria-label, '" + fechaDisponible + "')]"));
                        // Scroll hacia arriba
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("window.scrollTo(0, 0);");
                        // Hacer clic en el botón de la fecha disponible
                        JavascriptExecutor executor = (JavascriptExecutor) driver;
                        executor.executeScript("arguments[0].click();", elementoFecha);

                        //Aqui solo seleccionamos la parte de la cadena que contiene la fecha seleccionada
                        String[] partes = fechaDisponible.split(",");
                        fechaDisponible = partes[1].trim();

                        System.out.println("Fecha de termino seleccionada: " + fechaDisponible);
                        fechaTerminoEncontrada = true;
                        break;  // Rompe el bucle después de seleccionar la fecha
                    }
                }else {
                    System.out.println("No entró a las condiciones anteriores");
                }

                // Si no se encuentra la fecha, hacer clic en el botón para pasar al siguiente mes
                if (!fechaTerminoEncontrada) {
                    WebElement btnSiguienteMes = driver.findElement(By.cssSelector("#single-spa-application\\:\\@CCC\\/inscriptions > div > div.grid.grid-cols-12.sm\\:mx-16.mx-\\[32px\\].mt-\\[9rem\\].gap-\\[1\\.75rem\\].flex-grow > div.sc-bcXHqe.dqlVec > div.grid.grid-cols-9.md\\:grid.lg\\:grid.xl\\:grid.md\\:grid-cols-9.lg\\:grid-cols-9.xl\\:grid-cols-9 > div > div.gap-4.flex.items-center.justify-start > div:nth-child(2) > div > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header.react-datepicker__header--custom > div.sc-gKPRtg.eNakIz > button:nth-child(3) > svg"));
                    btnSiguienteMes.click(); //

                    // Actualizar la lista de fechas después de cambiar al siguiente mes
                    fechasTermino = driver.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day')]"));

                }
            }
        }
        return fechaTermino;*/
    }

    private String disribucionHorasCursoParcialComplementario(String horaParcial) throws InterruptedException, IOException {
        WebElement txtHorasComplementarias = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[5]/p")));
        if (txtHorasComplementarias.isDisplayed()) {
            WebElement inputHorasParcial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[5]/div/div[1]/div/input")));
            this.horaParcial = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo, 26);
            System.out.println("Hora parcial tomada: "+this.horaParcial);


            if (this.horaParcial.isEmpty()){
                System.out.println("No hay hora");

            }else {
                inputHorasParcial.clear();
                inputHorasParcial.sendKeys(this.horaParcial);
            }



        }
        return horaParcial;
    }

    public static String transformarFecha(String fechaInput) {
        // Define el formato de entrada
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Parsea la fecha de entrada
            Date fecha = formatoEntrada.parse(fechaInput);

            // Define el formato de salida
            SimpleDateFormat formatoSalida = new SimpleDateFormat("d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
            // Convierte la fecha al formato deseado
            //System.out.println("Esta entrando a transforma fecha: "+formatoSalida.format(fecha));

            return formatoSalida.format(fecha);

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static void hacerClicSiExiste(WebDriver driver, By btnSalir) {
        try {
            WebElement elemento = driver.findElement(btnSalir);
            elemento.click();
        } catch (Exception e) {
            System.out.println("No se pudo hacer clic en el elemento: " + e.getMessage());
        }
    }

    private static boolean elementoPresente(WebDriver driver, By segundoElementoSelector) {
        try {
            return driver.findElement(segundoElementoSelector).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    private static void hacerClicConJavaScript(WebElement elemento) {
        // Hacer clic en el elemento usando JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
        //System.out.println("Clic realizado usando JavaScript.");
        // Agrega aquí el código que sigue después de hacer clic




    }
    public  void  seleccionarHorasCursoElearning() throws InterruptedException, IOException {
        WebElement inputHoraInicio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[2]/div/div[1]/div/div/div/div/div[1]")));
        inputHoraInicio.click();//Presionamos boton para desplegar opciones
        WebElement horaInicioSeleccionar = driver.findElement(By.id("react-select-3-input"));
        horaInicioSeleccionar.sendKeys(this.horaInicio);
        wait.until(ExpectedConditions.elementToBeClickable(inputHoraInicio));
        inputHoraInicio.click();


        ///////////////////////HORA DE TERMINO
        WebElement inputHoraTermino = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[2]/div/div[2]/div/div/div/div/div[1]")));
        inputHoraTermino.click();//Presionamos boton para desplegar opciones
        WebElement horaTerminoSeleccionar = driver.findElement(By.id("react-select-4-input"));
        horaTerminoSeleccionar.sendKeys(this.horaTermino);
        wait.until(ExpectedConditions.elementToBeClickable(inputHoraTermino));
        inputHoraTermino.click();
        System.out.println("Ya seleccione las horas");


    }

    public  void seleccionarHorasCursoPresencial ()throws InterruptedException, IOException{
        WebElement inputHoraInicioCursoPresencial = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[6]/div[2]/div/div[1]/div/div/div/div/div[1]")));
        inputHoraInicioCursoPresencial.click();
        WebElement horaInicioSeleccionar = inputHoraInicioCursoPresencial.findElement(By.id("react-select-5-input"));
        horaInicioSeleccionar.sendKeys(this.horaInicio);
        wait.until(ExpectedConditions.elementToBeClickable(inputHoraInicioCursoPresencial));
        inputHoraInicioCursoPresencial.click();

        ///////////////////////HORA DE TERMINO
        WebElement inputHoraTerminoCursoPresencial = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[6]/div[2]/div/div[2]/div/div/div/div/div[1]")));
        inputHoraTerminoCursoPresencial.click();//Presionamos boton para desplegar opciones
        WebElement horaTerminoSeleccionar = inputHoraTerminoCursoPresencial.findElement(By.id("react-select-6-input"));
        horaTerminoSeleccionar.sendKeys(this.horaTermino);
        wait.until(ExpectedConditions.elementToBeClickable(inputHoraTerminoCursoPresencial));
        inputHoraTerminoCursoPresencial.click();

    }
    public void seleccionarDireccion_CursoPresencial () throws InterruptedException, IOException {
        boolean regionIngresada = false;
        boolean comunaIngresada = false;
        while (regionIngresada==false && comunaIngresada==false){

            //System.out.println("Entramos a condición  presencial");
            WebElement listaComunas = null;
            WebElement listaRegiones = null;
            this.regionCurso = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo,27);
            this.comunaCurso = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo,28);
            this.direccionCursoPresencial= Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo,29);
            try {
                listaRegiones= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-select-3-placeholder\"]")));
                listaRegiones.click();
                WebElement contenedorListaRegiones = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-3-listbox")));
                List<WebElement> regiones =contenedorListaRegiones.findElements(By.className("react-select__option"));

                for (WebElement list: regiones){
                    //System.out.println("--"+list.getText());
                    //System.out.println(this.regionCursoPresencial);
                    if (this.regionCurso.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").equals(list.getText().replaceAll("[^a-zA-Z0-9]", "").toLowerCase())) {
                        list.click();
                        regionIngresada= true;
                        System.out.println("Seleccionamos region");

                        break;
                    }
                }

                // Intentar hacer clic en el elemento
                listaComunas= driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div[2]/div/div/div[1]"));
                listaComunas.click();

                WebElement contenedorListaComunas =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-4-listbox")));
                List <WebElement> comunas = contenedorListaComunas.findElements(By.className("react-select__option"));

                for (WebElement lista: comunas){
                    //System.out.println(list.getText());
                    if (lista.getText().equals(this.comunaCurso)){
                        lista.click();
                        comunaIngresada=true;
                        System.out.println("Seleccionamos comuna");

                        break;

                    }
                }
                //Thread.sleep(5000);

                //Escribimos la direccion
                WebElement inputDireccion = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div/input"));
                //inputDireccion.click();
                inputDireccion.sendKeys(this.direccionCursoPresencial);


            } catch (org.openqa.selenium.ElementNotInteractableException e) {
                // Manejar la excepción en caso de que el elemento no sea clickeable
                System.out.println("Aqui esta entrando");

            }

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


