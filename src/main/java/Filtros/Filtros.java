package Filtros;

import Login.Login_Positivos;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class Filtros {
    static WebDriverWait wait = Login_Positivos.wait;
    static WebDriver driver = Login_Positivos.driver;

    static String filtroCelula = "CELULA 5";
    String filtroEtapas = "Cerrado";
    String filtroxModalidad = "Presencial";
    String filtroXCriticidad = "Curso Cerrado";

    @Test(priority = 12)
    //Filtro por Celula
    @And("Filtro por Celulas")
    public static void filtrosXCelulas() throws InterruptedException, IOException {
        //Este codigo filtra por etapas, buscando la etapa que se desea filtrar según variable declarada arriba
        //driver.navigate().refresh();//Refrescamos la pagina para que cargue de nuevo
        //Desplegamos opciones de CELULA
        //wait =  new WebDriverWait(Filtros.driver, 20);

        WebElement btncelula = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/div[4]/div[1]/div[1]/div[2]/div/div/div[2]/div")));
        btncelula.click();//Presionamos para desplegar lista de celulas

        List<WebElement> opcionesCelulas = Filtros.driver.findElements(By.id("react-select-1-listbox"));//Hacemos una lista de las opciones desplegadas
        //Si la lista está con al menos un campo
        if (opcionesCelulas.isEmpty() == false){
            for (WebElement listado :opcionesCelulas){
                System.out.println(listado.getText());

                if (listado.getText().contains(filtroCelula)){
                    listado.click();
                }else {
                    System.out.println("No aparece la opcion buscada, se selecciona la primera");

                }
            }
        //Si la lista está vacia
        } else if (opcionesCelulas.isEmpty()==true) {
            System.out.println("No se encontraron opciones en el filtro Celulas");
        }
    }

    @Test(priority = 13)
    //Filtro por Etapa}
    @And  ("Filtro por etapas")
    public void filtrosXEtapas () throws InterruptedException, IOException {
        //Este código filtra por etapas, buscando la opcion que le pasamos para comparar, luego busca en los resultados que al menos
        //un elemento coincida con el texto buscado

        //Buscamos el boton de Etapas para desplegar opciones
        WebElement btnEtapas =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/div[4]/div[1]/div[2]/div[2]/div/div/div[2]/div")));
        btnEtapas.click();//Presionamos para desplegar etapas

        boolean busqueda = false;
        //BUSQUEDA
        WebElement contenedorOpciones = driver.findElement(By.className("css-qr46ko"));
        List<WebElement> opcionesEtapas = contenedorOpciones.findElements(By.className("react-select__option"));
        if (opcionesEtapas.isEmpty() == false){
            //System.out.println(opcionesEtapas.size());
            for (WebElement listado :opcionesEtapas){
                //System.out.println(listado.getText().toLowerCase());
                if (listado.getText().toLowerCase().equals(filtroEtapas.toLowerCase())){
                    listado.click();
                    busqueda = true;
                    break;

                }else {
                    //System.out.println("No aparece la opcion buscada, se selecciona la primera");
                }
            }
            if (!busqueda){
                System.out.println("No aparece la opcion buscada, se selecciona la primera");
            }

            //RESULTADO
            List<WebElement> resultadoFiltro = driver.findElements(By.cssSelector("tr.sc-jSUZER.fYMkUI"));
            //System.out.println(resultadoFiltro.size());
            int cantidadDeResultados = 0;
            // Itera a través de la lista de elementos
            for (WebElement listado : resultadoFiltro) {
                WebElement CampoEtapa = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody/tr[1]/td[3]"));
                //System.out.println(CampoEtapa.getText());
                if (CampoEtapa.getText().toLowerCase().equals(filtroEtapas.toLowerCase())) {
                    //System.out.println("Filtro etapa correcto");
                    cantidadDeResultados=cantidadDeResultados+1;
                } else {
                    System.out.println("No se encontró el Filtro etapa en la busqueda");
                }
            }
            System.out.println("Hay: "+cantidadDeResultados+" de resultados del filtro");



        } else if (opcionesEtapas.isEmpty()==true) {
            System.out.println("No se encontraron opciones en el filtro Celulas");

        }

        Login_Positivos.capturarYAdjuntarCaptura("Captura_FiltroXEtapa");//Captura de pantalla
    }

    @Test(priority = 14)
    //filtro por modalidad
    @And ("Filtro por modalidad")
    public void filtrosXModalidad () throws InterruptedException, IOException {
        //En este codigo solo filtramos por modalidad de curso ya que no tenemos donde validar el correcto filtro

        //Buscamos el boton de Modalidad para desplegar opciones
        WebElement btnModalidad =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/div[4]/div[1]/div[3]/div[2]/div/div/div[1]")));
        btnModalidad.click();//HAcemos click para desplegar opciones

        //BUSQUEDA
        WebElement contenedorOpciones = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-qr46ko")));//Esperamos a que aparezca el contenedor con el listado
        List<WebElement> opcionesEtapas = contenedorOpciones.findElements(By.className("react-select__option"));// Una vez aparezca el contenedor, buscamos las opciones que hay dentro

        boolean encontradaCoincidencia = false;//Boolean para validar si se encontró coincidencia

        //Si el listado de estapas no está vacio, entramos
        if (!opcionesEtapas.isEmpty()) {
            for (WebElement listado : opcionesEtapas) {//Recorremos el listado
                //System.out.println(listado.getText());
                if (listado.getText().equalsIgnoreCase(filtroxModalidad)) {
                    listado.click();
                    encontradaCoincidencia = true;
                    break;
                }
            }
        //Si el contenedor está vacio, entramos
        }else {
            System.out.println("Contenedor vacio");
        }

        //Si no se encuentra resultado mostrar mensaje de error en consola
        if (!encontradaCoincidencia) {
            System.out.println("No se encontró ninguna coincidencia, se selecciona la primera opción por defecto o maneja el error de otra manera.");
        }
    }

    @Test(priority = 15)
    //friltro por Criticidad
    @And ("Filtro por criticidad")
    public void filtrosXCriticidad () throws InterruptedException, IOException {
        //En este codigo filtramos por criticidad y validamos en los resultados si realizó correctamente el filtro
        try{

            //Buscamos el boton de criticidad para filtrar
            WebElement btnCriticidad =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/div[4]/div[1]/div[4]/div[2]/div/div/div[1]")));
            btnCriticidad.click();//Presionamos boton para desplegar opciones

            // Una vez que se desplieguen las opciones, seleccionamos una opción específica
            String opcionASeleccionar =filtroXCriticidad;//Declaramos la opcion que deseamos buscar
            WebElement opcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + opcionASeleccionar + "']")));
            opcion.click();//Presionamos boton
            Thread.sleep(3000);//tiempo para que cargue la pagina


            //RESULTADO
            //Esperamos resultado que arroja la pagina
            WebElement resultadoFiltroCriticidad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody/tr[1]/td[4]/div/div[1]")));
            //System.out.println(resultadoFiltroCriticidad.getText());
            Login_Positivos.capturarYAdjuntarCaptura("Captura_FiltroXCriticidad");//Captura de pantalla

            List<WebElement> resultadoFiltro = driver.findElements(By.className("fYMkUI"));//Enlistamos el resultado del filtro
            int conteoResultadosCriticidad = 0;//Conteo de los resultados obtenidos

            // Iterar a través de la lista de elementos
            for (WebElement listado : resultadoFiltro) {
                String txtIdSence = resultadoFiltroCriticidad.getText(); // Obtengo el texto del ID actual en la lista

                String[] resultadoFiltroBusqueda = txtIdSence.split("\\s+"); // Dividir por espacios en blanco
                String[] comparacion = opcionASeleccionar.split("\\s+"); // Dividir por espacios en blanco


                // Verificar si hay coincidencia de al menos una palabra
                for (String palabra1 : resultadoFiltroBusqueda) {
                    for (String palabra2 : comparacion) {
                        // Comparar palabras (ignorando mayúsculas/minúsculas)
                        if (palabra1.equalsIgnoreCase(palabra2)) {
                            //System.out.println("Filtro correcto");
                            conteoResultadosCriticidad=conteoResultadosCriticidad+1;

                            Login_Positivos.capturarYAdjuntarCaptura("Captura_FiltroXCriticidad");//Captura de pantalla

                        }
                    }
                }
            }
            if (conteoResultadosCriticidad==0){
                System.out.println("No hay resultados con el filtro realizado");
            }else {
                System.out.println("Hay: "+conteoResultadosCriticidad+" resultados con el filtro realizado");
            }


        }catch (TimeoutException e) {
            // Inicializar SoftAssert
            SoftAssert softAssert = new SoftAssert();

            // Verificar todas las aserciones y recopilar resultados
            softAssert.assertAll();


        }


    }

    @AfterSuite
    //finalizamos el reporte
    public void finalizarReporte() {
        // Finalizar y generar el informe ExtentReports
        //extend.flush();
    }

    //Cerramos las ventanas al terminar el test
    public void close () throws InterruptedException {
        //driver.close();
        driver.quit();
        driver.quit();
    }
}
