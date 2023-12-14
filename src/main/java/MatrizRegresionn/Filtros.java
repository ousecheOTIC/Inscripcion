package MatrizRegresionn;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Filtros extends Dashboard{

    String filtroCelula = "CELULA 5";
    String filtroEtapas = "Cerrado";
    String filtroxModalidad = "Presencial";
    //Filtro por Celula
    @Test(priority = 12)
    public void filtrosXCelulas () throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.navigate().refresh();
        //Desplegamos opciones de CELULA
        WebElement btncelula = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/div[4]/div[1]/div[1]/div[2]/div/div/div[2]/div")));
        btncelula.click();

        List<WebElement> opcionesCelulas = driver.findElements(By.id("react-select-3-listbox"));
        if (opcionesCelulas.isEmpty() == false){
            for (WebElement listado :opcionesCelulas){
                System.out.println(listado.getText());

                if (listado.getText().contains(filtroCelula)){
                    listado.click();
                }else {
                    System.out.println("No aparece la opcion buscada, se selecciona la primera");

                }
            }
        } else if (opcionesCelulas.isEmpty()==true) {
            System.out.println("No se encontraron opciones en el filtro Celulas");
        }
    }

    //Filtro por Etapa
    @Test(priority = 13)
    public void filtrosXEtapas () throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
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
            WebElement espera = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fYMkUI")));
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

        capturarYAdjuntarCaptura("Captura_FiltroXEtapa");//Captura de pantalla
    }

    //filtro por modalidad
    @Test(priority = 14)
    public void filtrosXModalidad () throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement btnModalidad =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/div[4]/div[1]/div[3]/div[2]/div/div/div[1]")));
        btnModalidad.click();

        //BUSQUEDA
        WebElement contenedorOpciones = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-qr46ko")));
        List<WebElement> opcionesEtapas = contenedorOpciones.findElements(By.className("react-select__option"));

        boolean encontradaCoincidencia = false;

        if (!opcionesEtapas.isEmpty()) {
            for (WebElement listado : opcionesEtapas) {
                //System.out.println(listado.getText());
                if (listado.getText().equalsIgnoreCase(filtroxModalidad)) {
                    listado.click();
                    encontradaCoincidencia = true;
                    break;
                }
            }
        }

        if (!encontradaCoincidencia) {
            System.out.println("No se encontró ninguna coincidencia, se selecciona la primera opción por defecto o maneja el error de otra manera.");
        }
    }

    //friltro por Criticidad
    @Test(priority = 15)
    public void filtrosXCriticidad () throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement btnCriticidad =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-select-6-placeholder\"]")));
        btnCriticidad.click();

        // Una vez que se desplieguen las opciones, selecciona una opción específica
        String opcionASeleccionar = "Curso Cerrado";
        WebElement opcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + opcionASeleccionar + "']")));
        opcion.click();
        Thread.sleep(3000);//tiempo para que cargue la pagina

        //WebElement contenedorTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fEqhcF")));
        //Thread.sleep(1000);//tiempo para que cargue la pagina

        //Esperamos resultado que arroja la pagina
        WebElement resultadoFiltroCriticidad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody/tr[1]/td[4]/div/div[1]")));
        //System.out.println(resultadoFiltroCriticidad.getText());


        //Mostramos resultado que arroja la pagina
        //System.out.println("El resultado del filtro por Criticidad fue: "+resultadoFiltroCriticidad.getText());

        //WebElement campCriticidad = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody/tr/td[2]"));
        List<WebElement> resultadoFiltro = driver.findElements(By.className("fYMkUI"));
        int conteoResultadosCriticidad = 0;
        // Itera a través de la lista de elementos
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

                        capturarYAdjuntarCaptura("Captura_FiltroXCriticidad");//Captura de pantalla

                    }
                }
            }
        }
        if (conteoResultadosCriticidad==0){
            System.out.println("No hay resultados con el filtro realizado");
        }else {
            System.out.println("Hay: "+conteoResultadosCriticidad+" resultados con el filtro realizado");
        }

    }



    @AfterTest
    public void close () throws InterruptedException {
        //driver.close();
        driver.quit();
        driver.quit();
    }
}
