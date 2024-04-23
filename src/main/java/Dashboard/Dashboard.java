package Dashboard;

import Inscripciones.Inscripciones;
import Login.Login_Positivos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;




public class Dashboard  {
    private static final Logger log = LoggerFactory.getLogger(Inscripciones.class);
    String nombreCurso = "";
    static String IdSdence = "";
    String tipoDeBuscadorr = "id sence";
    String elementoBusquedaa = "6423520";
    public int IDinput =6306572;
    int cantidadRegistros = 10;
    static WebDriverWait wait = Login_Positivos.wait;
    static WebDriver driver = Login_Positivos.driver;

    //Volver a sucursal virtual
    //TODO Falta terminar el flujo
    /*@Test (priority = 5)
    public  void VolverASucursalVirtual ()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Al pulsar el botón "Sucursal Virtual" se debe volver directamente a la sucursal virtual
        WebElement btnSucursalVirtual =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#single-spa-application\\:\\@CCC\\/dashboard > div > div.col-span-3.grid.grid-cols-3.gap-\\[1\\.75rem\\] > div > div > div > ul:nth-child(4) > li:nth-child(2)")));


        if (btnSucursalVirtual.isDisplayed()){
            System.out.println("Veo el boton de sucursal virtual");
        }else {
            System.out.println("No veo el boton de sucursal virtual");
        }
        //TODO El elemento para hacer click no está disponible
        btnSucursalVirtual.click();

        //1. Se debe indicar el mensaje de bienvenida al usuario que realiza login.
        WebElement msj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div > div > section > main > div > main > div > div.ant-col.ant-col-24")));
        String msjBienvenida = msj.getText();
        if (msj.isDisplayed()) {
            System.out.printf(msjBienvenida);
        }else {
            System.out.printf("No aparece mensaje");;
        }

        //Ingresar a la tarjeta Integra Negocios
        WebElement btnIntegraNegocio = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > div > div > section > main > div > main > div > div:nth-child(13) > div > div > div > button")));
        btnIntegraNegocio.click();

        //Cambiamos de pantalla
        String mainTab = driver.getWindowHandle();
        String newTab = "";
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            //System.out.println(" --Handles ID: " + actual);

            if (!actual.equalsIgnoreCase(mainTab)) {
                //System.out.println(" -- Cambiando tab");
                driver.switchTo().window(actual);
                newTab = actual;
            }
        }

        System.out.println("Volvemos a Integra Negocios");
        Thread.sleep(5000);

    }
    */
    // Método para inicializar el driver y el wait



    //InfoDeUsuario
    @Test(priority = 6)
    public void infoDeUsuario() throws InterruptedException {
        /*wait =  new WebDriverWait(driver, 4000);

        //1. En la barra superior derecha se debe mostrar el nombre del usuario y el segmento de negocio (OTIC, OTEC o CLIENTE)
        WebElement segmentoUsuario =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[1]/div/div[1]/div/div/span")));
        String msjsegemento = segmentoUsuario.getText();
        if (segmentoUsuario.isDisplayed()) {
            System.out.println("El segmento es: " + msjsegemento);
        } else {
            System.out.println("No se visualiza el segmento");
        }
        if (msjsegemento == "Administrador") {
            System.out.println("Perfil autorizado para usar boton de configuracion");
        } else {
            System.out.println("Perfil no autorizado para usar boton de configuracion");
        }

        //2. Para un usuario administrador se debe mostrar el icono de configuración


        //3. Para un usuario final no se debe mostrar el ícono admisnitrador.
        //falta definicion*/
    }

    //Configuracion
    @Test (priority = 7)
    public void configuracion ()throws InterruptedException {
        /*

        try {


            boolean btnconfig = true;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement btnConfigu = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[1]/div[2]/div/button[3]"));
            btnConfigu.click();


            //1. La configuración debe ser solo de vizualización.
            //WebElement btnConfigu = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[1]/div[2]/div/button[3]"));
        /*if (btnConfigu.isDisplayed()){
            btnConfigu.click();
            System.out.println("Pinchamos el boton configuración");
        }else {
            System.out.println("No encontramos boton confiruracion");
        }
            //Validamos que estamos en la pagina configuracion
            String urlactual = driver.getCurrentUrl();
            String linkConfiguracion = ("backoffice");
            //System.out.println(urlactual);

            if (urlactual.contains(linkConfiguracion)) {
                System.out.println("Estamos en link de Configuracion");
            } else {
                System.out.println("El link no es el correcto");
                ;
            }

            //2. Solo los usuarios administradores deben tener acceso a la configuración

            Thread.sleep(3000);
            //Presionamos boton Dashboard para volver a inicio
            //Asi como esta abajo estaba definida la variable que buscaba antes, si sigue funcionando bien dejo la nueva
            WebElement btnDashboard = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/backoffice\"]/div/div[1]/div[2]/div/div/div/ul[1]/li[1]/button"));
            btnDashboard.click();


        } catch (Exception e) {
            log.error("Se produjo un error durante la prueba", e);
        } finally {
            // Cerrar el navegador
            if (driver != null) {
                //driver.quit();
            }

        }*/
    }

    //Buscador de cursos
    /*@Test(priority = 8)
    public void buscadorDeCursos() throws InterruptedException {


        //2. Admite máximo 10 registros en el campo de búsqueda
        //Lo que entiendo es que del resultado arroja maximo 10, quedando los proximos 10 en la proxima pagina

        java.util.List<WebElement> elementos = driver.findElements(By.className("fYMkUI"));
        // Cuenta la cantidad de elementos encontrados
        int cantidadDeElementos = elementos.size();
        if (cantidadDeElementos == cantidadRegistros) {
            System.out.println("Hay 10 registros");
        } else if (cantidadDeElementos >= cantidadRegistros) {
            System.out.println("Hay menos registros de los esperamos");
        } else if (cantidadDeElementos <= cantidadRegistros) {
            System.out.println("Excede cantidad de registros");
        }

        //TODO definir bien para desarrollar
        //3. Se deben permitir realizar búsquedas sin hacer enter en el campo de búsqueda.
        // Falta definicion


        //4. Descripción de búsqueda
        //Por defecto, al ingresar a la página principal de Optimus en la barra de búsqueda se debe visualizar el parámetro
        // de búsqueda por Nombre del Curso, el cual tendrá un mensaje informativo indicando “Busca un curso por nombre”.
        WebElement btnDespliegue = driver.findElement(By.cssSelector("#headlessui-menu-button-1 > svg"));
        btnDespliegue.click();
        Thread.sleep(3000);
        // Localiza todos los elementos por su clase
        List<WebElement> buscador = driver.findElements(By.cssSelector(".block.px-4.py-2"));
        WebElement txtBuscador = driver.findElement(By.xpath("//*[@id=\"react-select-2-placeholder\"]"));
        //En el caso que el usuario seleccione ID Sence o Solicitud de Compra tendrá el siguiente mensaje respectivamente
        // “Busca un curso por su ID Sence” o “Busca un curso por Solicitud de Compra” 5. Se pueden realizar búsquedas sin
        // discriminar por mayúscula, minúscula y/o acentos.
        //System.out.println(buscador);
        System.out.println(buscador.size());
        try {
            if (buscador.size() == 3) {
                for (WebElement opc : buscador) {
                    // Selecciona cada elemento
                    opc.click();
                    String text = txtBuscador.getText();
                    if (text.contains("Buscar por nombre")) {
                        System.out.println(text);
                    } else if (text.contains("Buscar por ID Sence")) {
                        System.out.println(text);
                    } else if (text.contains("Buscar por Solicitud de compra")) {
                        System.out.println(text);
                    }else {
                        System.out.println("No se encontraron todos los botones");
                        System.out.println(text);
                    }
                }
            }else {
                System.out.println("No hay suficientes numero de opciones");
            }
        } catch (NoSuchElementException e) {
            // Acciones a realizar en caso de que el elemento no se encuentre
            System.out.println("El elemento no se encontró en la página.");
        } catch (Exception e) {
            // Otras excepciones no manejadas específicamente
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
        driver.navigate().refresh();
    }*/

    //Buscador x nombre
    @Test(priority = 9)
    @And("Filtro por nombre de curso")
    public void filtro_por_nombre_de_curso() throws InterruptedException,IOException {
        //1. El buscador debe funcionar al hacer enter en el campo despúés de introducir un registro
        //Buscamos el nombre del curso en el archivo de DATOS PRUEBAS
        nombreCurso= Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo,6);

        System.out.println("Entra acá");
        //Llamamos el metodo buscar y filtramos por nombre
        buscadorDeCursos("Nombre de curso",nombreCurso);//Le enviamos el tipo de curso y el campo a buscar

    }

    //Buscador de cursos por ID
    @Test(priority = 10)
    public static void buscadorDeCursosPorID () throws InterruptedException, IOException {
        //String tipoDeBuscador =elementoBusqueda;

        //Buscamos el nombre del curso en el archivo de DATOS PRUEBAS
        IdSdence= Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo,7);


        buscadorDeCursos("ID Sence", IdSdence);//Le enviamos el tipo de curso y el campo a buscar
        Thread.sleep(5000);
    }

    //Boton de graficos
    @Test (priority = 11)
    @Then("Valido visibilidad de graficos")
    public void botonGraficos () throws InterruptedException, IOException {
        //1. EL botón mostrar gráficos debe permitir visualizar los graficos
        Login_Positivos.wait.until(ExpectedConditions.elementToBeClickable(By.className("justify-content-center")));

        //Buscamos el boton para oculpar/aparecer los gráficos
        WebElement btnGraficos = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/div[2]/button"));
        String msjBoton= btnGraficos.getText();//Guardamos el texto de boton
        //capturarYAdjuntarCaptura("Captura_GraficosVisible");//Captura de pantalla

        //2. El botón ocultar gráficos debe suprimir la visualización de los gráficos
        String BotonHabilitado = "Ocultar gráficos";
        String BotonDeshabilitado = "Mostrar gráficos";

        //Validamos si el boton está visible, lo ocultamos
        if (msjBoton.equals(BotonHabilitado)) {
            System.out.println("Graficos visibles");
            btnGraficos.click();//Presionamos el boton
            Login_Positivos.wait.until(ExpectedConditions.elementToBeClickable(By.className("justify-content-center")));
            msjBoton = btnGraficos.getText();//Guardamos el texto del boton
            if (msjBoton.equals(BotonDeshabilitado)){
                System.out.println("Pudimos ocultar los graficos");
                //capturarYAdjuntarCaptura("Captura_GraficosOcultos");//Captura de pantalla

            }else if (msjBoton.equals(BotonHabilitado)){
                System.out.printf("Aún aparecen los graficos");
            }
        //Validamos si el boton está oculto, lo ostramos
        } else if (msjBoton.equals(BotonDeshabilitado)) {
            System.out.println("Graficos no visibles");
            btnGraficos.click();
            Login_Positivos.wait.until(ExpectedConditions.elementToBeClickable(By.className("justify-content-center")));
            msjBoton = btnGraficos.getText();
            if (msjBoton.equals(BotonHabilitado)){
                System.out.println("Pudimos mostrar los graficos");
                //capturarYAdjuntarCaptura("Captura_GraficosOcultos");//Captura de pantalla

            }else if (msjBoton.equals(BotonDeshabilitado)){
                System.out.println("Siguen sin aparecer los graficos");
            }
        }
        Thread.sleep(2000);//Espera obligatoria
    }

    //METODOS REUTILIZABLES
    //Metodo que permite buscar cursos pasandole el tipo de buscador y el elemento a buscar
    public static  String buscadorDeCursos(String tipoDeBuscador, String elementoBusqueda) throws InterruptedException, IOException {


        //Seleccionamos filtro
        WebElement btnDespliegue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-menu-button-1 > svg")));

        btnDespliegue.click();//Desplegamos opciones

        boolean opcEncontrada = false;

        ///////////////////// TOMAMOS LA PRIMERA PALABRA PARA FILTRAR
        // Dividir la cadena en palabras
        String[] palabras = tipoDeBuscador.split("\\s+");
        // Tomar la primera palabra
        if (palabras.length > 0) {
            tipoDeBuscador = palabras[0].toLowerCase();
            //System.out.println("Primera palabra: " + tipoDeBuscador);
        } else {
            System.out.println("La cadena está vacía.");
        }
        /////////////////////

        // Localiza todos los elementos por su clase
        Thread.sleep(3000);//Espera OBLIGATORIA
        List<WebElement> buscador = driver.findElements(By.cssSelector(".block.px-4.py-2"));
        System.out.println(buscador.size());
        if (buscador.size()==3) {
            for (WebElement opc : buscador) {
                String palabraMinuscula = opc.getText().toLowerCase();
                if (palabraMinuscula.contains(tipoDeBuscador.toLowerCase())) {
                    System.out.println("Seleccionamos opcion: " + opc.getText());
                    opc.click();
                    opcEncontrada = true;
                    break;
                }
            }
            if (!opcEncontrada) {
                System.out.println("No se encontró la opcion de buscador seleccionada");
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Escribimos el numero a buscar
            WebElement IDinput = Login_Positivos.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-select__input")));
            IDinput.clear();
            IDinput.sendKeys(elementoBusqueda);
            //Presionamos Buscar
            WebElement btnBuscar = Login_Positivos.wait.until(ExpectedConditions.elementToBeClickable(By.className("drFfTY")));
            btnBuscar.click();
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            /////Filtro Nombre de curso
            if (tipoDeBuscador.toLowerCase().equals("nombre")) {
                //System.out.println("Entramos al if nombre");
                //Valido que la busqueda fue precisa
                //Intercepto el Nombre de cada resultado y lo anexo a una lista
                elementoBusqueda = Login_Positivos.extraerDatosDeLinea(Login_Positivos.rutaArchivo,6);
                Thread.sleep(5000);//Espera necesaria
                WebElement tablaResultados = Login_Positivos.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody")));
                List<WebElement> resultadoFiltro = driver.findElements(By.className("kAihBX"));
                //System.out.println(resultadoFiltro.size());
                // Itera a través de la lista de elementos
                int cantidadResultadosXNombre = 0;

                for (WebElement listado : resultadoFiltro) {
                    if (resultadoFiltro.size()==0) {
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
                            cantidadResultadosXNombre=cantidadResultadosXNombre+1;
                        } else {
                            //System.out.println("No se encontró la palabra en el registro");
                            cantidadResultadosXNombre=cantidadResultadosXNombre;

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
                WebElement tablaResultados = Login_Positivos.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody")));
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
        return tipoDeBuscador;
    }

    @AfterSuite
    //Finalizacion de reporte
    public void finalizarReporte() {
        // Finalizar y generar el informe ExtentReports
        //extent.flush();
    }

    //Cierre de test
    public void close () throws InterruptedException {
        //driver.close();
        driver.quit();
    }

}
