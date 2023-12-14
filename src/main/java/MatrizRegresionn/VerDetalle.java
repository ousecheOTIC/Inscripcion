package MatrizRegresionn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class VerDetalle extends Grilla{
    private static final Logger log = LoggerFactory.getLogger(Inscripciones.class);


    @Test(priority = 19)
    public void VisualizarInformacionDeCurso() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Desplegamos la informacion de curso
        WebElement informacionDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headlessui-disclosure-button-3")));
        informacionDeCurso.click();

        //1. Se debe visualizar el nombre de la OTEc
        WebElement nombreOtec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-4 > div:nth-child(1) > div:nth-child(1) > h2")));
        String txtNombreOtec = nombreOtec.getText();

        if (nombreOtec.isDisplayed()) {
            System.out.println("Nombre de OTEC: " + txtNombreOtec);
        } else {
            System.out.println("No se visualiza nombre de la OTEC");
        }

        //Rut Otec
        WebElement rutOtec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-4 > div:nth-child(1) > div:nth-child(2) > h2")));
        String txtRutOtec = rutOtec.getText();

        if (rutOtec.isDisplayed()) {
            System.out.println("Rut de OTEC: " + txtRutOtec);
        } else {
            System.out.println("No se visualiza rut de la OTEC");
        }

        // Cliente
        WebElement cliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-4 > div:nth-child(2) > div:nth-child(1) > h2")));
        String txtcliente = cliente.getText();

        if (cliente.isDisplayed()) {
            System.out.println("Cliente: " + txtcliente);
        } else {
            System.out.println("No se visualiza Cliente");
        }
        // Rut Cliente.
        WebElement rutcliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-4 > div:nth-child(2) > div:nth-child(2) > h2")));
        String txtRutCliente = rutcliente.getText();

        if (rutcliente.isDisplayed()) {
            System.out.println("Rut Cliente: " + txtRutCliente);
        } else {
            System.out.println("No se visualiza Rut de Cliente");
        }
        // Participantes
        WebElement participantesiniciales = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-4 > div:nth-child(3) > div:nth-child(1) > h2")));
        WebElement participantesActivos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-4 > div:nth-child(3) > div:nth-child(2) > h2")));

        String txtparticipantesiniciales = participantesiniciales.getText();
        String txtparticipantesActivos = participantesActivos.getText();
        if (participantesiniciales.isDisplayed()) {
            System.out.println("Participantes iniciales: " + txtparticipantesiniciales);
            if (participantesActivos.isDisplayed()) {
                System.out.println("Participantes Activos: " + txtparticipantesActivos);
            } else {
                System.out.println("No se visualiza participantes Activos");
            }
        } else {
            System.out.println("No se visualiza Participantes Iniciales");
        }

        // Jefe comercial
        WebElement jefeComercial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-4 > div.flex.gap-\\[4\\.5rem\\].flex-row.justify-start > div:nth-child(2) > h2")));
        String txtjefeComercial = jefeComercial.getText();

        if (jefeComercial.isDisplayed()) {
            System.out.println("Jefe comercial: " + txtjefeComercial);
        } else {
            System.out.println("No se visualiza jefe comercial");
        }

    }

    @Test(priority = 20)
    public void VisualizarTipodeCurso() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Desplegamos Tipo de curso
        WebElement btnTipoDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-button-5")));
        btnTipoDeCurso.click();

        //1. Se debe visualizar la linea de curso
        WebElement lineaCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-6 > div.flex.gap-\\[2\\.8rem\\].flex-row.justify-start > div:nth-child(1) > h2")));
        String txtlineaCurso = lineaCurso.getText();

        if (lineaCurso.isDisplayed()) {
            System.out.println("Linea de Curso: " + txtlineaCurso);
        } else {
            System.out.println("No se visualiza Linea de Curso");
        }

        //sub-línea de trabajo
        WebElement sublineaCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-6 > div.flex.gap-\\[2\\.8rem\\].flex-row.justify-start > div:nth-child(2) > h2")));
        String txtSubLineaCurso = sublineaCurso.getText();

        if (sublineaCurso.isDisplayed()) {
            System.out.println("Sub Linea de Curso: " + txtSubLineaCurso);
        } else {
            System.out.println("No se visualiza Sub Linea de Curso");
        }
        // Modalidad
        WebElement modalidad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-6 > div.flex.gap-\\[2\\.8rem\\].flex-row.justify-start > div:nth-child(3) > h2")));
        String txtmodalidad = modalidad.getText();

        if (modalidad.isDisplayed()) {
            System.out.println("Modalidad de Curso: " + txtmodalidad);
        } else {
            System.out.println("No se visualiza Modalidad de Curso");
        }

        // Contrato
        WebElement contrato = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-6 > div:nth-child(2) > div:nth-child(1) > h2")));
        String txtcontrato = contrato.getText();

        if (contrato.isDisplayed()) {
            System.out.println("Contrato de Curso: " + txtcontrato);
        } else {
            System.out.println("No se visualiza contrato de Curso");
        }


        // Parcial o complementario
        WebElement parcialOComplementario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headlessui-disclosure-panel-6 > div:nth-child(2) > div:nth-child(2) > h2")));
        String txtconpactialOComplementario = parcialOComplementario.getText();

        if (parcialOComplementario.isDisplayed()) {
            System.out.println("Parcial o Complementario de Curso: " + txtconpactialOComplementario);
        } else {
            System.out.println("No se visualiza Parcial o Complementario de Curso");
        }
    }

    //Comentado para la prueba con jefe
/*
    @Test(priority = 21)
    public void VisualizarFechasDelCurso()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Desplegamos fecha de cursos
        WebElement btnfechaDeCurso = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"headlessui-disclosure-button-1\"]")));
        btnfechaDeCurso.click();

        //1. Se debe visualizar la fecha de inicio del curso
        WebElement fechainicio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-disclosure-panel-2\"]/div[1]/div[1]/h2")));
        String txtfechainicio = fechainicio.getText();

        if (fechainicio.isDisplayed()){
            System.out.println("Fecha inicio del Curso: "+txtfechainicio);
        }else {
            System.out.println("No se visualiza Fecha inicio del Curso");
        }

        // fecha de término del curso
        WebElement fechaTermino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-disclosure-panel-2\"]/div[1]/div[2]/h2")));
        String txtfechaTermino = fechaTermino.getText();

        if (fechaTermino.isDisplayed()){
            System.out.println("Fecha termino del Curso: "+txtfechaTermino);
        }else {
            System.out.println("No se visualiza Fecha termino del Curso");
        }

        // fecha de asistencia
        WebElement fechaAsistencia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-disclosure-panel-2\"]/div[2]/div[1]/h2")));
        String txtfechaAsistencia = fechaAsistencia.getText();

        if (fechaAsistencia.isDisplayed()){
            System.out.println("Fecha de asistencia: "+txtfechaAsistencia);
        }else {
            System.out.println("No se visualiza Fecha de asistencia");
        }

        // fecha maxima de liquidación
        WebElement fechaMaximaLiquidacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-disclosure-panel-2\"]/div[2]/div[2]/h2")));
        String txtfechaMaximaLiquidacion = fechaMaximaLiquidacion.getText();

        if (fechaMaximaLiquidacion.isDisplayed()){
            System.out.println("Fecha maxima de Liquidación: "+txtfechaMaximaLiquidacion);
        }else {
            System.out.println("No se visualiza Fecha maxima de Liquidación");
        }


    }
*/

    @Test(priority = 22)
    public void VisualizarMontosDelCurso() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Desplegamos Tipo de curso
        WebElement btnTipoDeCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-disclosure-button-7\"]")));
        btnTipoDeCurso.click();

        //1. Se debe visualizar el monto total Oti
        WebElement montoOtic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-disclosure-panel-8\"]/div/div[1]/h2")));
        String txtmontoOtic = montoOtic.getText();

        if (montoOtic.isDisplayed()) {
            System.out.println("Monto total Otic: " + txtmontoOtic);
        } else {
            System.out.println("No se visualiza Monto total Otic");
        }

        //monto total Otec
        WebElement montoOtec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-disclosure-panel-8\"]/div/div[2]/h2")));
        String txtmontoOtec = montoOtec.getText();

        if (montoOtec.isDisplayed()) {
            System.out.println("Monto total Otec: " + txtmontoOtec);
        } else {
            System.out.println("No se visualiza Monto total Otec");
        }


    }

    @Test(priority = 23)
    public void ContadorDeDias() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Thread.sleep(3000);
        //1. El contador de dias debe indicar los dias que faltan para liquidar el curso
        WebElement diasParaLiquidarCurso =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[1]/div[3]/div/div[1]/div[1]")));
        String txtdiasParaLiquidarCurso = diasParaLiquidarCurso.getText();

        //Mostramos los dias que faltan para liquidar
        System.out.println("Faltan " + txtdiasParaLiquidarCurso + " dias para liquidar el curso");


        // Y los dias que han transcurridos desde el inicio del cursos
        WebElement contadorDias = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("kpnZtE")));
        String txtContadorDias = contadorDias.getText();
        System.out.println("Los dias son: " + txtContadorDias);

    }

    //Comentado para la prueba con jefe

    @Test(priority = 24)
    public void HistorialDelCurso() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //1. Se debe mostrar el historial del curso de acuerdo de acuerdo a los hitos que se vayan cumpliendo.
        // Los hitos mas recientes se mostraran siempre de primero.

        //Desplegamos campo requisitos
        Thread.sleep(2000);
        WebElement btnRequisitos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[2]/button/div")));
        if (btnRequisitos.isDisplayed()) {

        } else {
            btnRequisitos.click();
        }

        Thread.sleep(2000);
        //Requisitos
        WebElement fechasHistorial01 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/ol/li[1]/h3[2]")));
        String txtfechasHistorial01 = fechasHistorial01.getText();
        WebElement fechasHistorial02 = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/ol/li[2]/h3[2]"));
        String txtfechasHistorial02 = fechasHistorial02.getText();
        WebElement fechasHistorial03 = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/ol/li[3]/h3[2]"));
        String txtfechasHistorial03 = fechasHistorial03.getText();
        //System.out.println(txtfechasHistorial01);
        //System.out.println(txtfechasHistorial02);
        //System.out.println(txtfechasHistorial03);


        // Define el formato original
        SimpleDateFormat formatoOriginal = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");

        // Define el formato deseado
        SimpleDateFormat formatoDeseado = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada01 = null;
        String fechaFormateada03 = null;
        String fechaFormateada02 = null;

        //Pasamos la fecha de String a Date
        try {
            // Parsea la fecha en el formato original
            Date fecha01 = formatoOriginal.parse(txtfechasHistorial01);
            Date fecha02 = formatoOriginal.parse(txtfechasHistorial02);
            Date fecha03 = formatoOriginal.parse(txtfechasHistorial03);

            // Formatea la fecha en el nuevo formato
            fechaFormateada01 = formatoDeseado.format(fecha01);
            fechaFormateada02 = formatoDeseado.format(fecha02);
            fechaFormateada03 = formatoDeseado.format(fecha03);

            System.out.println("Fecha formateada: " + fechaFormateada01);
            System.out.println("Fecha formateada: " + fechaFormateada02);
            System.out.println("Fecha formateada: " + fechaFormateada03);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        // Crear una lista de fechas
        List<String> fechasStr = new ArrayList<>();
        fechasStr.add(fechaFormateada01);
        fechasStr.add(fechaFormateada02);
        fechasStr.add(fechaFormateada03);

        // Ordena las fechas en orden ascendente
        Collections.sort(fechasStr);

        // Itera sobre las fechas ordenadas
        for (String fecha : fechasStr) {
            System.out.println(fecha);
        }
    }



    @AfterTest
    public void close () throws InterruptedException {
        //driver.close();
        driver.quit();
        driver.quit();
    }
}
