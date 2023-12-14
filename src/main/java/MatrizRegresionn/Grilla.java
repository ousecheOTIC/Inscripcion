package MatrizRegresionn;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class Grilla extends Filtros{
    //Grilla por cantidad de elementos
    private int cantidadDeRegistros = 20;

    @Test(priority = 16)
    public void GrillaFiltrarPaginado () throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.navigate().refresh();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        //Presionamos boton mostrar cantidad de registros por pagina a mostrar
        WebElement btnMostrarPaginado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-menu-button-2\"]")));
        btnMostrarPaginado.click();
        //Thread.sleep(3000);
        capturarYAdjuntarCaptura("Captura_FiltrarPaginado");//Captura de pantalla

        //1. Se deben mostrar en la grilla la cantidad de registros seleccionado en el filtro de paginado
        // Una vez que se desplieguen las opciones, selecciona una opción específica
        WebElement opcion = driver.findElement(By.xpath("//span[text()='" + cantidadDeRegistros + "']"));
        Thread.sleep(3000);
        opcion.click();

        //1. El usuario podrá visualizartodo el paginado de acuerdo a la cantidad de registros.
        java.util.List<WebElement> elementos = driver.findElements(By.className("kAihBX"));
        System.out.println(elementos);
        // Cuenta la cantidad de elementos encontrados
        int cantidadDeElementos = elementos.size();
        System.out.println("Cantidad de elementos: " + cantidadDeElementos);

        if(cantidadDeElementos == Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Cantidad de registros correcto");
        } else if (cantidadDeElementos >= Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Excede cantidad de registros");
        } else if (cantidadDeElementos <=Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Hay menor cantidad de registros");
        }

    }
    //Grilla Retroceder/Avanzar paginado
    @Test(priority = 17)
    public void GrillaCambiarPaginado ()throws InterruptedException{
        //Cambiamos de pagina para ver más registros
        //1. Debe mostrar todo el detalle del curso
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btnSiguientePaginado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/div[7]/div/div[2]/div[2]/nav/a[6]")));
        btnSiguientePaginado.click();
        Thread.sleep(3000);

        //Esperamos que cargue la nueva pagina
        //By css = By.cssSelector("#single-spa-application\\:\\@CCC\\/dashboard > div > div.sc-bcXHqe.dqlVec > div > div > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(3)");
        //WebElement resultadoSiguientePagina = wait.until(ExpectedConditions.visibilityOfElementLocated(css));
        //resultadoSiguientePagina.getText();
        //1. El usuario podrá visualizartodo el paginado de acuerdo a la cantidad de registros.
        java.util.List<WebElement> elementoss = driver.findElements((By.className("fYMkUI")));
        // Cuenta la cantidad de elementos encontrados
        int cantidadDeElementoss = elementoss.size();
        System.out.println("Cantidad de elementos: " + cantidadDeElementoss);

        if(cantidadDeElementoss == Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Cantidad de registros correcto");
        } else if (cantidadDeElementoss >= Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Excede cantidad de registros");
        } else if (cantidadDeElementoss <=Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Hay menor cantidad de registros");
        }
    }

    @Test(priority = 18)
    public void GrillaDetalleCurso() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //TODO:  La busqueda debe arrojar resultados diferentes cada consulta
        //Esperamos que cargue la pagina
        WebElement btnVerDetalle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody/tr[1]/td[4]/div/div[3]/button")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", btnVerDetalle);
        //btnVerDetalle.click();//Clickeamos el boton Ver detalle del primer resultado
        Thread.sleep(2000);//Espera de prueba

        //Validamos que me lleve a la pagina de INSCRIPCIONES
        String urlactual = driver.getCurrentUrl();
        String linkinscripcion = ("sucursalvirtualv2-qa.ccc.cl/inscriptions");
        //System.out.println(urlactual);
        capturarYAdjuntarCaptura("Captura_DetalleCurso");//Captura de pantalla

        if (urlactual.contains(linkinscripcion)) {
            System.out.println("Estamos en link de Inscripciones");
            //1. Debe mostrartodo el detalle del curso
            //-Contador de dias
            WebElement contadorDias = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[1]/div[4]/div/div[2]/span")));

            String txtContadorDias = contadorDias.getText();
            System.out.println("Los dias son: " + txtContadorDias);

            //-Historial del Curso
            WebElement historialDeCursos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div")));
            if (historialDeCursos.isDisplayed()) {
                System.out.println("Se ve Historial de curso");
            } else {
                System.out.println("No se ve historial de curso");
            }
            String txthistorialDeCursos = historialDeCursos.getText();

            //-Información del Curso
            WebElement informacionDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headlessui-disclosure-button-3")));

            if (informacionDeCurso.isDisplayed()) {
                System.out.println("Se ve informacion de curso");
            } else {
                System.out.println("No se ve informacion de curso");
            }

            //-Fecha
            WebElement fechaDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headlessui-disclosure-button-1")));

            if (fechaDeCurso.isDisplayed()) {
                System.out.println("Se ve fecha de curso");
            } else {
                System.out.println("No se ve fecha de curso");
            }

            //-Montos
            WebElement montosDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headlessui-disclosure-button-7")));

            if (montosDeCurso.isDisplayed()) {
                System.out.println("Se ve montos de curso");
            } else {
                System.out.println("No se ve montos de curso");
            }

            //- ID Sence
            WebElement idSence = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]")));

            if (idSence.isDisplayed()) {
                System.out.println("Se ve ID Sence");
            } else {
                System.out.println("No se ve montos de curso");
            }

            //•	Curso (Nombre)
            WebElement nombreCurso = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[1]/div[2]/h2"));

            if (nombreCurso.isDisplayed()) {
                System.out.println("Se ve Curso");
            } else {
                System.out.println("No se ve Curso");
            }

            //•	Código Sence
            WebElement codigoSence = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/h2"));

            if (codigoSence.isDisplayed()) {
                System.out.println("Se ve Código Sence");
            } else {
                System.out.println("No se ve Código Sence");
            }

            //•	SSC (N° de solicitud de compra)
            WebElement ssc = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div[2]/h2"));

            if (ssc.isDisplayed()) {
                System.out.println("SSC (N° de solicitud de compra)");
            } else {
                System.out.println("No se ve SSC (N° de solicitud de compra)");
            }

            //•	OC (N° Orden de compra del curso)
            WebElement oc = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div[3]/h2"));

            if (oc.isDisplayed()) {
                System.out.println("Se ve OC (N° Orden de compra del curso)");
            } else {
                System.out.println("No se ve OC (N° Orden de compra del curso)");
            }

        } else {
            System.out.println("El link no es el correcto");
            ;
        }
    }



    @AfterTest
    public void close () throws InterruptedException {
        //driver.close();
        driver.quit();
        driver.quit();
    }
}



