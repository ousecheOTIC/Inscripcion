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
import java.util.List;

public class Comunicación extends Inscripciones{
    private static final Logger log = LoggerFactory.getLogger(Inscripciones.class);
    private static WebDriverWait wait;
    private ExtentReports extent;
    private ExtentTest test;



    @Test (priority = 65)
    public void MenuComunicación () throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        String urlactual = driver.getCurrentUrl();
        //Hacemos que presione boton independiente de donde esté parado
        if (urlactual.contains("dashboard")) {
            //Presionamos menú inscripciones
            WebElement menuComunicacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/dashboard\"]/div/div[1]/div[2]/div/div/div/ul[1]/li[4]/button")));
            menuComunicacion.click();

        } else if (urlactual.contains("inscriptions")) {
            WebElement btn = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[2]/div/div/div/ul[1]/li[4]/button"));
            System.out.println("Estamos en link de Inscripciones");
            btn.click();
        }
        Thread.sleep(2000); //Espera necesaria

        //validamos que estemos en comunicacion
        String urlComumnicacion = driver.getCurrentUrl();
        if (urlComumnicacion.contains("communications")){

            //Captura
            capturarYAdjuntarCaptura("Captura_Menu_Comunicacion");//Captura de pantalla

            WebElement msjMenuComunicacion = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/communications\"]/div/div[1]/div[3]/div[2]/div/h1"));

            if (msjMenuComunicacion.getText().equals("¿Necesitas generar un archivo o cargar respuesta de comunicación?")){
                System.out.println("Estamos en menu Comunicación");



            }






        }
    }


    @Test(priority = 66)
    public void SeleccionarCursoAComunicar () throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Al no haber ningún curso de la grilla seleccionado, el botón "Generar archivo" no debe estar habilitado.
        //
        //Así mismo al tener algún curso seleccionado y el botón es"té habilitado, una vez se elimine la selección, el botón "Generar archivo" debe inhabilitarse.
        //WebElement btnGenerarArchivo = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/communications\"]/div/div[1]/div[3]/div[2]/div/div[5]/div[3]/button/div"));
        WebElement btnGenerarArchivo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"single-spa-application:@CCC/communications\"]/div/div[1]/div[3]/div[2]/div/div[5]/div[3]/button")));
        if (btnGenerarArchivo.isSelected()){
            System.out.println("Boton habilitado");
        }else {

            //Le doy el valor numerico a la variable
            Inscripciones.numeroSolicitudDeCompra ="1704";

            //Buscamos los resultados
            WebElement contenedorResultados = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/communications\"]/div/div[1]/div[3]/div[2]/div/div[11]/table/tbody")));

            //Cantidad de cursos cargados
            List<WebElement> NumeroDeOrdenCompra = contenedorResultados.findElements(By.className("fDgyGM"));
            WebElement cursosCargados = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/communications\"]/div/div[1]/div[3]/div[2]/div/div[9]/div"));
            System.out.println("Hay "+cursosCargados.getText());

            for (WebElement Listado : NumeroDeOrdenCompra){
                WebElement CampoSC = Listado.findElement(By.className("cJAKVD"));

                if (CampoSC.getText().contains(Inscripciones.numeroSolicitudDeCompra)){
                    WebElement CheckBox =  CampoSC.findElement(By.className("gVtFyQ"));
                    //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CheckBox);
                    CheckBox.click();
                    break;

                }else {
                    //System.out.println("No se encontró el Sc de la inscripción");
                }
            }
            //Captura
            capturarYAdjuntarCaptura("Captura_Curso_Cargados");//Captura de pantalla

            if (btnGenerarArchivo.isEnabled()){
                System.out.println("Se habilita boton");
                btnGenerarArchivo =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"single-spa-application:@CCC/communications\"]/div/div[1]/div[3]/div[2]/div/div[5]/div[3]/button/div")));
                //btnGenerarArchivo.click();

                WebElement msjExitoso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Archivo Generado Correctamente')]")));


                System.out.println(msjExitoso.getText());

                //Captura
                capturarYAdjuntarCaptura("Captura_Generacion_Archivo_Comunicacion");//Captura de pantalla
                Thread.sleep(10000);

            }


        }





    }


}
