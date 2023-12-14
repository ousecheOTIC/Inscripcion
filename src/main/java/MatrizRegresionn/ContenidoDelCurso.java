package MatrizRegresionn;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class ContenidoDelCurso extends Requisitos{

    String codigoSence = "1238013718";
    String IdSence = "6138500";
    //6138500
    String codigoCompra = "";
    private Object GuardarContenidoDeCurso;

    @Test (priority = 26)
    public void IngresoAlmodulo ()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Presionamos boton "contenido de curso"
        WebElement btnconenidoDeCurso =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[2]/div/div/div/ul[1]/li[2]/button/div")));

        //2. El usuario debe poder visualizar en el menú la opción "Contenido del Curso".
        if (btnconenidoDeCurso.isDisplayed()){
            System.out.println("El cliente puede ver boton Contenido del curso");
            btnconenidoDeCurso.click();
        }else{
            System.out.println("No se visualiza boton Contenido del curso");

        }

        //Validamos que estamos en la página contenido de curso
        String urlactual = driver.getCurrentUrl();
        String linkConfiguracion = ("inscriptions");
        //System.out.println(urlactual);

        if (urlactual.contains(linkConfiguracion)){
            System.out.println("Estamos en link de Contenido de Curso");
        }else {
            System.out.println("El link no es el correcto");;
        }

        //1. En la barra superior derecha se debe mostrar el nombre del usuario y el segmento de
        // negocio (OTEC u OTIC)
        WebElement segmentoUsuario =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[1]/div/div[1]/div/div/span")));
        String msjsegemento = segmentoUsuario.getText();
        if (segmentoUsuario.isDisplayed()) {
            System.out.println("El segmento es: " + msjsegemento);
        } else {
            System.out.println("No se visualiza el segmento");
        }




        //3. Al ingresar a la opción antes mencionada se debe visualizar el mensaje "
        // ¿Necesita buscar o agregar contenido de un curso?"
        WebElement msjIniciContenidoCurso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div/div/h1")));
        String TxtMsjIniciContenidoCurso = msjIniciContenidoCurso.getText();

        if (msjIniciContenidoCurso.isDisplayed()){
            System.out.println(TxtMsjIniciContenidoCurso);
        }else {
            System.out.println("No se visualiza el mensaje");
        }


    }

    @Test(priority = 27)
    public void BuscarCursoXCodigoSence ()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Desplegamos la lista de opciones
        WebElement listOpciones = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-menu-button-1\"]")));
        listOpciones.click();
        // Localiza todos los elementos por su clase
        List<WebElement> elementos = driver.findElements(By.className("hover:cursor-pointer"));

        // Verifica que existan al menos dos elementos con esa clase
        if (elementos.size() == 3) {
            // Selecciona el segundo elemento (índice 1 en base a 0)
            WebElement segundoElemento = elementos.get(0);
            System.out.println("Veo los elementos");

            // Realiza acciones con el segundo elemento
            segundoElemento.click();
        }
        //Escribimos el numero de codigo a buscar
        WebElement Codigoinput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-select__input")));
        Codigoinput.sendKeys(codigoSence);
        //Presionamos Buscar
        WebElement btnBuscar = driver.findElement(By.className("hJbcKB"));
        btnBuscar.click();

        //Validamos que el resultado sea correcto
        WebElement resultadoBusqueda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[2]/div/div[1]/div[2]/h1[2]")));
        String txtCodigoResultado = resultadoBusqueda.getText();
        System.out.println(txtCodigoResultado);

        if (txtCodigoResultado.equals(codigoSence) ){
            System.out.println("Codigo correcto");
        }else {
            System.out.println("Codigo incorrecto");
            System.out.println(txtCodigoResultado);
        }



    }

    //Dejé esta prioridad ya que po solicitud no arroja resultados
    @Test(priority = 29)
    public void BuscarCursoXIdSence ()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Desplegamos la lista de opciones
        WebElement listOpciones = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-menu-button-1\"]")));
        listOpciones.click();
        // Localiza todos los elementos por su clase
        List<WebElement> elementos = driver.findElements(By.className("hover:cursor-pointer"));

        // Verifica que existan al menos dos elementos con esa clase
        if (elementos.size() == 3) {
            // Selecciona el segundo elemento (índice 2)
            WebElement segundoElemento = elementos.get(1);
            // Realiza acciones con el segundo elemento
            segundoElemento.click();
        }
        //Escribimos el numero de codigo a buscar
        WebElement Codigoinput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-select__input")));
        Codigoinput.sendKeys(IdSence);
        //Presionamos Buscar
        WebElement btnBuscar = driver.findElement(By.className("hJbcKB"));
        btnBuscar.click();

        //Validamos que el resultado sea correcto
        System.out.println("No tengo como validar el resultado de la busqueda");

        //Dejo comentado igual el codigo para futuro pero no aparece campo para poder validar el resultado de la busqueda
/*
        if (txtCodigoResultadoXID.equals(IdSence) ){
            System.out.println("Id correcto");
        }else {
            System.out.println("Id incorrecto");
            System.out.println(txtCodigoResultadoXID);
        }
*/
    }

    @Test (priority = 28)
    public void BuscarCursoXSolicitudCompra ()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Desplegamos la lista de opciones
        WebElement listOpciones = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headlessui-menu-button-1\"]")));
        listOpciones.click();
        // Localiza todos los elementos por su clase
        List<WebElement> elementos = driver.findElements(By.className("hover:cursor-pointer"));

        // Verifica que existan al menos dos elementos con esa clase
        if (elementos.size() == 3) {
            // Selecciona el segundo elemento (índice 2)
            WebElement segundoElemento = elementos.get(2);
            // Realiza acciones con el segundo elemento
            segundoElemento.click();
        }
        //Escribimos el numero de codigo a buscar
        WebElement Codigoinput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-select__input")));
        Codigoinput.sendKeys(codigoCompra);
        //Presionamos Buscar
        WebElement btnBuscar = driver.findElement(By.className("hJbcKB"));
        btnBuscar.click();

        //Validamos que el resultado sea correcto
        //WebElement resultadoBusquedaXSolicitud = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#single-spa-application\\:\\@CCC\\/inscriptions > div > div.sc-bcXHqe.dqlVec > div > div.grid.grid-cols-9.md\\:grid.lg\\:grid.xl\\:grid.md\\:grid-cols-9.lg\\:grid-cols-9.xl\\:grid-cols-9 > div > div:nth-child(2) > div > div:nth-child(1) > div.w-full > h1.text-primary.font-semibold.text-lg.leading-5")));
        //String txtCodigoResultadoXSolicitud = resultadoBusquedaXSolicitud.getText();
        System.out.println("No tengo como validar el resultado de la busqueda");

    }

    @Test (priority = 30)
    public void AgregarContenidoACurso ()throws InterruptedException{
        //El sistema debe permitir al usuario editar los cuadros de texto denominados "Funciones y/o Tareas" y "Contenidos Temáticos" que estén vacíos.

        Thread.sleep(3000);
        //Agregar contenido a Funciones y/o tareas
        WebElement inputFunciones = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div[1]/textarea"));
        inputFunciones.sendKeys("Prueba"); //Le enviamos una palabra para corroborar que no se habilite el boton guardar

        //Agregar contenido a Contenido temático
        WebElement inputContenido = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div[2]/textarea"));
        inputContenido.sendKeys("Prueba");//Le enviamos una palabra para corroborar que no se habilite el boton guardar

        //Validamos se habilite el boton guardar
        WebElement btnGuardar = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[2]/button"));

        if (btnGuardar.isEnabled()){
            System.out.println("Boton Guardar Habilitado");
        }else{
            System.out.println("Boton Guardar deshabilitado");
        }

        //TODO: Acá agregamos captura de pantalla para evidenciar manejo de scroll
        Thread.sleep(5000);
        inputFunciones.sendKeys("Estas organizaciones son parte del sistema ");
        inputContenido.sendKeys("Estas organizaciones son parte del sistema\"");
        System.out.println("Agregamos el resto del parrafo");

        if (btnGuardar.isDisplayed()){
            System.out.println("Boton Guardar Habilitado");
        }else{
            System.out.println("Boton Guardar deshabilitado");
        }
    }

    @Test(priority = 32)
    public void EditarContenidoACurso ()throws InterruptedException{
        Thread.sleep(5000);
        List<WebElement> Listainputs = driver.findElements(By.className("cjYGAN"));

        for (WebElement inputs : Listainputs){
            inputs.sendKeys("Las OTIC son reguladas \\\\n");

        }




        /*
        //Agregar contenido a Funciones y/o tareas
        WebElement inputFunciones = driver.findElement(By.xpath("//*[@id=\\\"single-spa-application:@CCC/inscriptions\\\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div[1]/textarea"));
        inputFunciones.sendKeys("Las OTIC son reguladas \\n");

        //Agregar contenido a Contenido temático
        WebElement inputContenido = driver.findElement(By.cssSelector("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[3]/div/div[2]/textarea"));
        inputContenido.sendKeys("Las OTIC son reguladas \\n");
        */
        //TODO: Acá agregamos captura de pantalla para evidenciar manejo de scroll
        Thread.sleep(5000);

        //Guardamos los cambios
        GuardarContenidoDeCurso();
        Thread.sleep(5000);

    }

    //Validar primero los persmisos
    @Test(priority = 33)
    public void EditarContenidoACursoSinPermiso ()throws InterruptedException {



    }

    //Dejamos este luego de Agregar para validar correcto flujo
    @Test (priority = 31)
    public void GuardarContenidoDeCurso ()throws InterruptedException{
        //Validamos que boton esté habilitado
        WebElement btnGuardar = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[2]/div/div[4]/div[2]/button"));
        btnGuardar.click();


        Thread.sleep(3000);
        //Vemos si aparece ventana emergente
        // WebElement msjVentanaEmergente = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[3]/div/h1"));
        //if (msjVentanaEmergente.isDisplayed()){
        //    System.out.println("Nos pasamos a ventana emergente");
        //}

        //Guardamos el contenido del curso
        WebElement btnGuardarCurso = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@CCC/inscriptions\"]/div/div[1]/div[3]/div[3]/div/div[2]/div/button[2]"));
        btnGuardarCurso.click(); //Deshabilito el boton para que no se vaya a guardar cada vez que ejecuto la prueba

        //Por mientras hago las pruebas
        //WebElement btnSeguirEditando = driver.findElement(By.className("px-[0.5rem]"));
        //btnSeguirEditando.click();
        Thread.sleep(3000);
    }

    @Test (priority = 34)
    public void SalirEdicionDeContenidoDeCurso ()throws InterruptedException{
        Thread.sleep(3000);
        //Presionamos boton salir
        //WebElement btnSalir = driver.findElement(By.xpath("px-[2.2rem]"));
        ////*[@id="single-spa-application:@CCC/inscriptions"]/div/div[1]/div[3]/div[2]/div/div[4]/div[1]/button
        //btnSalir.click(); //Se comenta ya que por el flujo no hay que presionar este boton

    }


    @AfterTest
    public void close () throws InterruptedException {
        //driver.close();
        driver.quit();
        driver.quit();
    }

}
