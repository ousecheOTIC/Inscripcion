package Grilla;

import Login.Login_Positivos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class Grilla {
    //Grilla por cantidad de elementos
    private int cantidadDeRegistros = 20;
    static WebDriverWait wait = Login_Positivos.wait;
    static WebDriver driver = Login_Positivos.driver;

    @Test(priority = 16)
    //Filtrado de cantidad de resultados
    @And("Valido cantidad de registros seleccionados")
    public void grillaFiltrarPaginado () throws InterruptedException, IOException {
        //Este codigo filtra por cantidad de resultados a mostrar en la pagina (10, 20, 30, etc)

        //wait =  new WebDriverWait(driver, 4000);
        driver.navigate().refresh();//Refrescamos la pagina
        Thread.sleep(3000);

        //Hacemos click con Javascript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        //Presionamos boton mostrar cantidad de registros por pagina a mostrar
        WebElement btnMostrarPaginado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-menu-button-2\"]")));
        btnMostrarPaginado.click();//Hacemos click en boton

        Login_Positivos.capturarYAdjuntarCaptura("Captura_FiltrarPaginado");//Captura de pantalla

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

        //Validamos si la cantidad de resultados es igual a la seleccionada
        if(cantidadDeElementos == Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Cantidad de registros correcto");
        } else if (cantidadDeElementos >= Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Excede cantidad de registros");
        } else if (cantidadDeElementos <=Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Hay menor cantidad de registros");
        }

    }


    @Test(priority = 17)
    //Grilla Retroceder/Avanzar paginado
    @And ("Cambio cantidad de registros a mostrar")
    public void grillaCambiarPaginado ()throws InterruptedException{
        //Este codigo cambia de pagina en la lista de resultados

        //Cambiamos de pagina para ver más registros
        //1. Debe mostrar el detalle del curso
        WebElement btnSiguientePaginado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/div[7]/div/div[2]/div[2]/nav/a[6]")));
        btnSiguientePaginado.click();
        Thread.sleep(3000);//Espera obligatoria

        //Esperamos que cargue la nueva pagina

        //1. El usuario podrá visualizartodo el paginado de acuerdo a la cantidad de registros.
        java.util.List<WebElement> elementoss = driver.findElements((By.className("fYMkUI")));
        // Cuenta la cantidad de elementos encontrados
        int cantidadDeElementoss = elementoss.size();
        System.out.println("Cantidad de elementos: " + cantidadDeElementoss);

        //Validamos que la cantidad de elementos sea igual a la cantidad seleccionada
        if(cantidadDeElementoss == Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Cantidad de registros correcto");
        } else if (cantidadDeElementoss >= Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Excede cantidad de registros");
        } else if (cantidadDeElementoss <=Integer.parseInt(String.valueOf((cantidadDeRegistros)))){
            System.out.println("Hay menor cantidad de registros");
        }
    }

    @Test(priority = 18)
    //"Detalle curso"
    @And ("Presiono ver detalle curso")
    public void grillaDetalleCurso() throws InterruptedException, IOException {
        //Este codigo presiona boton "Detalle curso" del primer resultado de la lista, según se haya filtrado o se haya hecho una busqueda,
        //tambien valida el resultado arrojado según curso seleccionado


        //TODO:  La busqueda debe arrojar resultados diferentes cada consulta
        //Esperamos que cargue la pagina
        WebElement btnVerDetalle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[3]/div[2]/div/div/div/table/tbody/tr[1]/td[4]/div/div[3]/button")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;//Hacemos click con Javascript
        executor.executeScript("arguments[0].click();", btnVerDetalle);

        //btnVerDetalle.click();//Clickeamos el boton Ver detalle del primer resultado
        Thread.sleep(2000);//Espera de prueba

        //Validamos que me lleve a la pagina de INSCRIPCIONES
        String urlactual = driver.getCurrentUrl();//Guardamos la URL acual
        String linkinscripcion = ("sucursalvirtualv2-qa.ccc.cl/inscriptions");//Guardamosla URL que debe aparecer

        //Validamos que las 2 URL se parezcan
        if (urlactual.contains(linkinscripcion)) {
            System.out.println("Estamos en link de Inscripciones");

            //1. Debe mostrartodo el detalle del curso
            //-Contador de dias
            WebElement contadorDias = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[1]/div[4]/div/div[2]/span")));

            String txtContadorDias = contadorDias.getText();//Guradamos texto del contador de dias
            System.out.println("Los dias son: " + txtContadorDias);//Mostramos cantidad de dias


            //VALIDAMOS QUE APAREZCAN TODOS LOS CAMPOS NECESARIOS, DE NO APARECER UNO, SE CORTA LA PRUEBA
            //-Historial del Curso
            WebElement historialDeCursos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div")));
            if (historialDeCursos.isDisplayed()) {
                System.out.println("Se ve Historial de curso");

                //-Información del Curso
                WebElement informacionDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headlessui-disclosure-button-3")));

                if (informacionDeCurso.isDisplayed()) {
                    System.out.println("Se ve informacion de curso");

                    //-Fecha
                    WebElement fechaDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headlessui-disclosure-button-1")));

                    if (fechaDeCurso.isDisplayed()) {
                        System.out.println("Se ve fecha de curso");

                        //-Montos
                        WebElement montosDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headlessui-disclosure-button-7")));

                        if (montosDeCurso.isDisplayed()) {
                            System.out.println("Se ve montos de curso");

                            //- ID Sence
                            WebElement idSence = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]")));

                            if (idSence.isDisplayed()) {
                                System.out.println("Se ve ID Sence");
                                //•	Curso (Nombre)
                                WebElement nombreCurso = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[1]/div[2]/h2"));

                                if (nombreCurso.isDisplayed()) {
                                    System.out.println("Se ve Curso");

                                    //•	Código Sence
                                    WebElement codigoSence = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/h2"));

                                    if (codigoSence.isDisplayed()) {
                                        System.out.println("Se ve Código Sence");

                                        //•	SSC (N° de solicitud de compra)
                                        WebElement ssc = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div[2]/h2"));

                                        if (ssc.isDisplayed()) {
                                            System.out.println("SSC (N° de solicitud de compra)");

                                            //•	OC (N° Orden de compra del curso)
                                            WebElement oc = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div[3]/h2"));

                                            if (oc.isDisplayed()) {
                                                System.out.println("Se ve OC (N° Orden de compra del curso)");

                                            } else {
                                                System.out.println("No se ve OC (N° Orden de compra del curso)");
                                            }

                                        } else {
                                            System.out.println("No se ve SSC (N° de solicitud de compra)");
                                        }
                                    } else {
                                        System.out.println("No se ve Código Sence");
                                    }
                                } else {
                                    System.out.println("No se ve Curso");
                                }
                            } else {
                                System.out.println("No se ve montos de curso");
                            }
                        } else {
                            System.out.println("No se ve montos de curso");
                        }
                    } else {
                        System.out.println("No se ve fecha de curso");
                    }
                } else {
                    System.out.println("No se ve informacion de curso");
                }
            } else {
                System.out.println("No se ve historial de curso");
            }
            String txthistorialDeCursos = historialDeCursos.getText();

        } else {
            System.out.println("El link no es el correcto");
            ;
        }
    }


    @Then("Cierro el navegador Grilla")
    //Cerramos la pagina despues de la prueba
    public void close () throws InterruptedException {
        //driver.close();
        driver.close();
    }
}



