package Login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class Login_Positivos {
    public static WebDriver driver;
    public static WebDriverWait wait;
    ExtentReports extent;
    public static ExtentTest test;
    public static String folderName;

    public static String rutaArchivo = "C:\\Users\\ouseche\\OneDrive - OTIC CChC\\Escritorio\\Automatización\\probando\\DATOS PARA PRUEBAS.txt";// Ruta del archivo que contiene las credenciales


    @Given("Ingreso a SV")
    //Inicializamos Driver y URL del ambiente de prueba
    public static void paginaSucursalVirtual() {
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

    @When("Me logeo exitosamente con usuario {string} y con contraseña {string}")
    public void login(String usuario, String contraseña) throws InterruptedException, IOException {

        wait =  new WebDriverWait(driver, 90);
        //Valido que Aparezca mensaje "¡Bienvenido a nuestra Sucursal Virtual!"
        WebElement msjHola = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/login\"]/div/div/div[3]/div/div/main/p[1]")));
        String TxtmsjHola = msjHola.getText();//Guardo el texto del elemento mensaje
        System.out.println(TxtmsjHola.equals("¡Bienvenido a nuestra Sucursal Virtual!"));//Se imprime mensaje si coincide con lo requerido

        //NOMBRE DE LA URL
        String nombreURL= driver.getCurrentUrl();//tomamos la url actual y la guardamos en una variable
        System.out.println(nombreURL);

        //CREDENCIALES
        WebElement usernameInput = driver.findElement(By.className("jxrMZn"));//Buscamos el elemento usuario
        WebElement passwordInput = driver.findElement(By.className("gBiohV"));//Buscamos el elemento password
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/login\"]/div/div/div[3]/div/div/footer/button"));//Buscamos el elemento boton


        //usuario = extraerDatosDeLinea(rutaArchivo, 2);//Extraemos el usuario del txt
        //contraseña = extraerDatosDeLinea(rutaArchivo, 3);//Extraemos la contraseña del txt


        //PASAMOS LOS USUARIOS
        usernameInput.clear();//Limpiamos el input usuario
        usernameInput.sendKeys(usuario);//Enviamos el usuario
        passwordInput.clear();//Limpiamos el input contraseña
        passwordInput.sendKeys(contraseña);//Enviamos contraseña

        //capturarYAdjuntarCaptura("Captura_Login");//Captura de pantalla

        //BOTON  INGRESAR
        loginBtn.click();//Presionamos boton ingresar

        //1. Se debe indicar el mensaje de bienvenida al usuario que realiza login.
        WebElement msj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Bienvenido')]"))); //QA2
        //Si aparece el mensaje se muestra, de lo contrario controlamos el error
        String msjBienvenida = msj.getText();
        if (msj.isDisplayed()) {
            System.out.printf(msjBienvenida);

        } else {
            System.out.printf("No aparece mensaje");
            ;
        }
    }

    //Validamos que el usuario sea el correcto
    public void mensajeBienvenida() throws InterruptedException, IOException {
        //Validamos que el usuario y segmento sea el corecto
        WebElement usuario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/home\"]/div/div[1]/div/div/div[1]/div/div[1]/div/div/p")));
        String txtusuario = usuario.getText();//tomamos el nombre del usuario ingresado
        System.out.println(txtusuario);
        capturarYAdjuntarCaptura("Captura_MsjBienvenida");//Captura de pantalla

        WebElement segmento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/home\"]/div/div[1]/div/div/div[1]/div/div[1]/div/div/span")));
        String txtsegmento = usuario.getText();//tomamos el nombre del usuario ingresado
        System.out.println(txtsegmento);
    }

    @And("Presiono boton de configuracion en sesion de usuario para {string}")
    public static void btnConfigUsuario(String cambio_o_Cierre) throws IOException{
        //METODO PARA INGRESAR AL BOTON DE SESION DE USUARUO PARA CAMBIAR CONTRASEÑA O CERRAR SESION
        //DEBEMOS PASARLE EL TEXTO DE LA ACCION QUE QUERRAMOS REALIZAR

        //Buscamos el boton de usuario
        WebElement btnUsuario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/home\"]/div/div[1]/div/div/div[1]/div/div[1]/div/img")));

        if(btnUsuario.isDisplayed()) {
            //Hacemos click
            btnUsuario.click();

            //Contenedor de cambiar contraseña y cerrar sesion
            WebElement contenedorOpciones = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hSoKHV")));
            List<WebElement> cerrarSecsionYCambiarContraseña = contenedorOpciones.findElements(By.tagName("button"));

            for (WebElement btns : cerrarSecsionYCambiarContraseña) {
                System.out.println("--"+btns.getText());
                if (btns.getText().contains(cambio_o_Cierre)){
                    System.out.println("Entro a boton cambiar");
                    btns.click(); //Hacemos click si está presente
                    break;
                }
            }
        }

    }

    @And ("Cambio de contraseña actual {string} por la nueva {string}")
    public static void cambioDeContraseña(String contraseñaActual, String contraseñaNueva) throws IOException, InterruptedException {

        Thread.sleep(2000);
        //Validamos que estamos en el modulo de cambiar contraseña
        if (driver.getCurrentUrl().contains("backofficesucursal/password-change")){
            //Buscamos el campo para ingresar contraseña actual
            WebElement inputContraseñaActual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Ingresa tu contraseña actual']")));
            inputContraseñaActual.sendKeys(contraseñaActual);//Le pasamos la contraseña actual


            //Buscamos el campo de ingresar contaseña nueva
            WebElement inputContraseñaNueva = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Ingresa tu nueva contraseña']")));
            inputContraseñaNueva.sendKeys(contraseñaNueva);//Le pasamos la contraseña nueva

            //Buscamos el campo para confirmar contraseña nueva
            WebElement inputConfirmarContraseñaNueva= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Confirma tu nueva contraseña']")));
            inputConfirmarContraseñaNueva.sendKeys(contraseñaNueva);//Le pasamos la contraseña nueva

            //Validamos que se habilite el boton para confirmar cambio
            WebElement btnConfirmarCambioContraseña = driver.findElement(By.xpath("//button[text()='Cambiar contraseña']"));

            if (btnConfirmarCambioContraseña.isEnabled()){
                //Antes de presionar boton habilitamos la visualizacion de los campos para ver los datos
                //y tomamos captura de pantalla
                System.out.println("Esta entrando a visualizar");
                //WebElement svgElement =  wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"single-spa-application:@CCC/backofficesucursal\"]/div/div[1]/div/div/div[2]/div[1]/main/div[2]/div/svg"))));
                //svgElement.click();
                //driver.findElement((By) inputContraseñaActual.findElement(By.xpath("following-sibling::svg"))).click();
                //driver.findElement((By) inputContraseñaNueva.findElement(By.className("w-6 h-6"))).click();
                //driver.findElement((By) inputConfirmarContraseñaNueva.findElement(By.className("w-6 h-6"))).click();
                //TODO:QUEDA COMENTADO PORQUE NO PUEDO LLAMAR EL ELEMENTO DEL OJITO PARA QUE APAREZCA EL TEXTO



                //Presionamos boton
                //btnConfirmarCambioContraseña.click();

                //Esparamos que aparezca el mensaje de exito

                capturarYAdjuntarCaptura("captura_cambio de contraseña exitoso");

                Thread.sleep(4000);//Espera para visualizar el mensaje

            }else {
                System.out.println("Boton (Cambiar contraseña) no habilitado para presionar");
                Thread.sleep(4000);
            }



        }else {//De lo contrario ceramos el navegador
            System.out.println("No estamos en el modulo de cambiar contraseña");
        }
    }


    @And("Ingreso a integra negocio")
    //Seleccionamos la opcion integra Negocio
    public static void accesoIntegraNegocio()throws InterruptedException,IOException{
        //Llamamos el metodo para escoger la opcion deseada
        seleccionarMenuSV("Gestiona", "Inscripciones", "Administración de cursos");

    }

    //METODOS PRIVADOS
    @And ("El usuario selecciona el menú {string} con submenú {string} y opción {string}")
    public static void  seleccionarMenuSV(String tarjeta, String subTarjeta, String opcion) throws InterruptedException {
        Thread.sleep(3000);
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
        Thread.sleep(5000);
    }

    @And("Presiono boton de recuperacion de contraseña")
    public static void olvidasteTuContraseña ()throws InterruptedException{
        wait =  new WebDriverWait(driver, 20);

        WebElement btnRecuperarContraseña = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("jXxdDZ")));

        if (btnRecuperarContraseña.isDisplayed()){
            btnRecuperarContraseña.click();//Presionamos boton para recuperar contreña

        }else {
            System.out.println("No estamos en modulo de recuperacion de contraseña");
        }


    }

    @And("Inreso la contraseña {string}")
    public static void ingresoContraseñaTemporal (String contraseñaTemporal)throws InterruptedException{
        // Crear un objeto Scanner para leer la entrada del usuario desde la consola
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese un texto
        System.out.print("Por favor, ingresa tu usuario: ");

        // Leer el texto ingresado por el usuario
        String usuario = scanner.nextLine();

        // Mostrar el texto ingresado por el usuario
        System.out.println("El usuario ingresado es: " + usuario);

        // Cerrar el objeto Scanner
        scanner.close();

    }

    @And("Ingreso Rut de usuario {string}")
    public static void olvidasteTuContraseñas (String rutUsuario)throws InterruptedException{

        Thread.sleep(2000);//Espera de 2 segundos para que cargue la nueva URL
        //Validamos que estamos en el modulo de recuperacion de contaseña
        if (driver.getCurrentUrl().contains("olvide-contrasena")) {
            //Buscamos el input para colocar el rut de usuario
            WebElement inputRutUsuario = driver.findElement(By.xpath("//input[@placeholder='Ingresa tu usuario']"));

            //Le pasamos el rut del usuario
            inputRutUsuario.sendKeys(rutUsuario);

            //Validamos que el boton de recuperar se habilite
            WebElement btnRecuperar = driver.findElement(By.xpath("//button[contains(text(), 'Recuperar')]"));

            if (btnRecuperar.isEnabled()) {
                btnRecuperar.click();

                //Esperamos que muestre mensaje de correo enviado
                WebElement msjRecuperacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Recuperación de Contraseña')]")));//Recuperación de Contraseña



                //Buscamos el boton "Cerrar"
                WebElement btnCerrar = driver.findElement(By.xpath("//button[contains(text(), 'Cerrar')]"));//Cerrar
                btnCerrar.click();//Presionamos boton Cerrar
            }

        }
    }

    @When("Me intento logear con usuario correcto {string} y contraseña erronea {string}")
    public static void ingresoCredencialesIncorrectas (String usuarioIncorrecto, String contraseñaIncorrecta)throws InterruptedException{
        //En este metodo nos intentamos logear con usuario y contraseña incorrectas para validar
        //que nos arroje error

        //Inicializamos el mensaje de bloqueo
        //Usuario o contraseña incorrectos
        Boolean usuarioBloqueado=false;
        int conteoIntentos = 0;

        //Abrimos un bucle While para que repita la accion hasta que se bloquee la contraseña
        while (!usuarioBloqueado){
            //Primero ingresamos los caracteres
            //CREDENCIALES
            WebElement usernameInput = driver.findElement(By.className("jxrMZn"));//Buscamos el elemento usuario
            WebElement passwordInput = driver.findElement(By.className("gBiohV"));//Buscamos el elemento password
            WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/login\"]/div/div/div[3]/div/div/footer/button"));//Buscamos el elemento boton


            //PASAMOS LOS USUARIOS
            usernameInput.clear();//Limpiamos el input usuario
            usernameInput.sendKeys(usuarioIncorrecto);//Enviamos el usuario
            passwordInput.clear();//Limpiamos el input contraseña
            passwordInput.sendKeys(contraseñaIncorrecta);//Enviamos contraseña

            //BOTON  INGRESAR
            loginBtn.click();//Presionamos boton ingresar

            //Ahora validamos que salga el mensade de error
            Thread.sleep(2000);//Espera de 1 segundo para que aparezca el mensaje
            WebElement msjErrorCredenciales = null;
            WebElement msjCuentaBloqueada = null;


            try {
                // Intenta encontrar el primer elemento
                msjErrorCredenciales = driver.findElement(By.xpath("//h2[text()='Usuario o contraseña incorrectos']"));


                if (msjErrorCredenciales.getText().equals("Usuario o contraseña incorrectos")){
                    //Buscamos el boton volver
                    WebElement btnVolver = driver.findElement(By.xpath("//button[contains(text(), 'Volver')]"));
                    btnVolver.click();//Presionamos boton volver
                    usuarioBloqueado = false;
                    conteoIntentos=conteoIntentos+1;

                }else {
                    //Buscamos el boton volver
                    WebElement btnVolver = driver.findElement(By.xpath("//button[contains(text(), 'Volver')]"));
                    btnVolver.click();//Presionamos boton volver
                    usuarioBloqueado = true;
                    break;

                }



            } catch (Exception e) {
                // Si no se encuentra el primer elemento, intenta encontrar el segundo elemento
                try {
                    msjCuentaBloqueada = driver.findElement(By.xpath("//h2[text()='Su cuenta ha sido bloqueada, le sugerimos recuperar la contraseña.']"));
                    //Buscamos el boton volver
                    WebElement btnVolver = driver.findElement(By.xpath("//button[contains(text(), 'Volver')]"));
                    btnVolver.click();//Presionamos boton volver
                    usuarioBloqueado = true;
                    System.out.println("llego aqui");
                    break;
                    // Haz algo con elemento2 si lo encuentras
                } catch (Exception ex) {
                    // Si no se encuentra ninguno de los elementos, maneja la excepción o haz otra cosa
                    System.out.println("No se pudo encontrar ninguno de los elementos.");
                }
            }

        }
        //Una vez que sale del bucle, imprimimos la cantidad de veces que ingresó credenciales
        //erroneas para bloquear el usuario
        System.out.println("Se intentó "+conteoIntentos+" veces");





    }

    @And("Ingreso a Modulo {string} del menú")
    public static void ingresarModuloMenú (String modulo) throws InterruptedException{
        //Una vez estemos logeados en la SV, buscamos del lado izquierdo el menú el modulo que deseemos

        //Hacemos una validacion de URL para asegurar que estemos en HOME
        Thread.sleep(10000);//Espera para que cargue la pagina

        WebElement moduloABuscar = null;

        moduloABuscar= driver.findElement(By.xpath("//button[contains(., '" + modulo + "')]"));

        if (moduloABuscar.isDisplayed()){
            moduloABuscar.click();
            Thread.sleep(2000);//Espera para que cargue la pagina
            //Ahora vaidamos que nos lleve al URL correcto
            if (modulo.toLowerCase().equals("usuarios")){
                //Si es modulo usuarios
                String urlU = "/user";

                if(driver.getCurrentUrl().contains(urlU)){
                    System.out.println("\nIngresamos correctamente a modulo Usuarios");
                }
            } else if (modulo.toLowerCase().equals("perfiles")) {
                //Si  es modulo perfiles
                String urlP = "/cargos";

                if(driver.getCurrentUrl().contains(urlP)){
                    System.out.println("\nIngresamos correctamente a modulo perfiles");
                }
            } else if (modulo.toLowerCase().equals("sistemas")) {
                //Si es modulo sistemas
                String urlS = "/system";

                if(driver.getCurrentUrl().contains(urlS)){
                    System.out.println("\nIngresamos correctamente a modulo sistemas");
                }
            }

        }

    }

    @And("Busco usuario por categoría {string} y campo {string}")
    public static void buscoUsuario (String categoriaABuscar, String usuario)throws InterruptedException{

        //Llamamos el metodo para buscar el usuario por
        buscarUsuario_ModuloUsuarios(categoriaABuscar,usuario);

        //Una vez encontrado, buscamos el icono de "Accion"




    }


    public static void btnAccion_ModuloUsuarios (String accionARealizar)throws InterruptedException{
        //Buscamos el boton de accion dentro del modulo usuarios

        //SI aparece el contenedor de resultados hacemos:
        WebElement btnAccion = null;


        //Si no aparece cerramos la prueba



    }
    public static void buscarUsuario_ModuloUsuarios (String categoriaABuscar, String usuario) throws InterruptedException {
        //Una vez estemos en el modulo de usuarios de la SV, buscamos un usuario en especifico para editar

        //Primero buscamos el input de busqueda
        WebElement inputBusqueda = null;
        int conteoResultados = 0;
        inputBusqueda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-2-input")));
        WebElement elementoEncontrado = null;
        Boolean usuarioEncontrado = false;
        String rutSinPuntos = null;
        if (inputBusqueda.isDisplayed()) {
            {
                //Si el input esta visible le pasamos el campo a buscar
                inputBusqueda.clear();//Limpiamos antes de enviar texto
                inputBusqueda.sendKeys(usuario);

                //Presionamos el boton para buscar
                WebElement btnBuscar = driver.findElement(By.className("sc-jSUZER"));
                btnBuscar.click();//Hacemos click

                //Esperamos que cargue la busqueda
                WebElement contenedorResultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("iNDdvE")));


                if (contenedorResultado.isDisplayed()) {
                    //Una vez aparezca el contenedor, buscamos en los resultados
                    List<WebElement> resultados = driver.findElements(By.className("eZLCKR"));
                    System.out.println("Cantidad de resultados " + resultados.size() + "");

                    //Ahora recorremos todos los resultados
                    for (WebElement celda : resultados) { // Itera sobre cada celda
                        String textoCelda = celda.getText(); // Obtiene el texto de la celda

                        //Ahora aplicamos la logica de buscar celda por celda la coincidencia con el texto deseado

                        //Si el elemento es rut
                        if (categoriaABuscar.toLowerCase().equals("nombre")) {
                            //Si el elemento es nombre
                            //System.out.println("Es nombre");

                            //Entramos y buscamos todas las columnas de nombre
                            elementoEncontrado = celda.findElement(By.className("gmzpJX"));

                            System.out.println(elementoEncontrado.getText());


                        } else if (categoriaABuscar.toLowerCase().equals("perfil")) {
                            //Si el elemento es perfil
                            //System.out.println("Es perfil");
                            //Entramos y buscamos todas las columnas de nombre
                            elementoEncontrado = celda.findElement(By.className("cYSOFv"));

                            System.out.println(elementoEncontrado.getText());


                        } else if (categoriaABuscar.toLowerCase().equals("rut")) {
                            System.out.println("Es rut");

                            elementoEncontrado = celda.findElement(By.className("jSZitf"));

                            System.out.println(elementoEncontrado.getText());

                            //Ahora le quitamos los puntos y espacios al rut
                            //Como puedo hacer un ciclo que itere por varios campos y quitarle puntos y espacios a cada campo

                            rutSinPuntos = elementoEncontrado.getText().replaceAll("[.\\s-]", "");
                            String usuarioSinPuntos = usuario.replaceAll("[. ]", "");
                            System.out.println(rutSinPuntos);
                            if (rutSinPuntos.equals(usuarioSinPuntos)) {
                                usuarioEncontrado= true;

                            }
                        }
                    }
                    //Ahora validamos si el usuario fue encontrado
                    if (usuarioEncontrado){
                        System.out.println("Encontramos el " + categoriaABuscar + " " + rutSinPuntos);

                        //AHora tenemos que buscar el boton "Accion"
                        WebElement btnAcciones = driver.findElement(By.className("bQlWee"));
                        btnAcciones.click();

                        //Al desplegar las opciones, buscamos la opcion que deseemos realiar
                        //TODO: QUEDÉ AQUI IMPLEMENTANDO LA BUSQUEDA DEL BOTON DE ACCIONES
                        //PARA BUSCAR LA OPCION DE DESACTIVAR USUARIO.




                    }else {
                        System.out.println("No encontramos nada");
                    }



                } else {
                    System.out.println("No se visualiza resultados");
                }
            }
        }

    }
    public static void capturarYAdjuntarCaptura(String nombreCaptura) throws IOException {
        // Generar un nombre de archivo único para la captura de pantalla
        String fileName = folderName + "/" + nombreCaptura + ".png";

        // Tomar la captura de pantalla y guardarla en la carpeta actual
        FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
                new File(fileName));

        // Devolver la ruta completa del archivo de captura
        //test.addScreenCaptureFromPath(fileName);
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


    /*//Finalizamos la creacion del reporte
    public void finalizarTest(ITestResult result) {
        // Finalizar el test en ExtentReports según el resultado
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "El test ha fallado: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "El test ha pasado");
        } else {
            test.log(Status.SKIP, "El test ha sido omitido");
        }
    }*/


    //Cerramos la ventana al final de la prueba
    public void close () throws InterruptedException {
        driver.close();
        //driver.quit();
        //driver.quit();
        //ReportManager.flushReport();

    }

}