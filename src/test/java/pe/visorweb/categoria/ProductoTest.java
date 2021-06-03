package pe.visorweb.categoria;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pe.visorweb.driver.CrearDriver;
import pe.visorweb.driver.tipos.Navegador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ProductoTest {
    private static WebDriver driver;
    private String url = "http://localhost:8080/VisorWeb/index.xhtml";

    @BeforeAll
    public static void configurarDriver(){
        driver = CrearDriver.getDriver(Navegador.CHROME);
    }
    @AfterAll
    public static void cerrarDriver(){
        driver.close();
    }

    @Test
    public void testInsertarProductoExitoso(){
        try{


            Thread.sleep(2000); //una demora de dos segundos
            driver.findElement(By.xpath("/html/body/section/div[1]/div")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/section/div[1]/nav/ul/li/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Mnt. de Productos")).click();
            driver.findElement(By.id("btnNuevo")).click();
            driver.findElement(By.id("txtNombre")).clear();
            driver.findElement(By.id("txtNombre")).sendKeys("Agua San Luis");
            driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[3]/select/option[5]")).click();
            driver.findElement(By.id("txtPrecio")).clear();
            driver.findElement(By.id("txtPrecio")).sendKeys("3.00");
            driver.findElement(By.id("btnGuardar")).click();

            Thread.sleep(2000);

            String mensajeEsperado= "Se guardó de manera correcta el Producto";
            String mensajeObtenido= driver.findElement(By.id("messages")).getText();

            assertEquals(mensajeEsperado, mensajeObtenido);

        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
    @Test
    public void testInsertarProductoExitoso2(){
        try{


            Thread.sleep(2000); //una demora de dos segundos
            driver.findElement(By.xpath("/html/body/section/div[1]/div")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/section/div[1]/nav/ul/li/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Mnt. de Productos")).click();
            driver.findElement(By.id("btnNuevo")).click();
            driver.findElement(By.id("txtNombre")).clear();
            driver.findElement(By.id("txtNombre")).sendKeys("Pizza Familiar Peperoni");
            driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[3]/select/option[5]")).click();
            driver.findElement(By.id("txtPrecio")).clear();
            driver.findElement(By.id("txtPrecio")).sendKeys("19.90");
            driver.findElement(By.id("btnGuardar")).click();

            Thread.sleep(2000);

            String mensajeEsperado= "Se guardó de manera correcta el Producto";
            String mensajeObtenido= driver.findElement(By.id("messages")).getText();

            assertEquals(mensajeEsperado, mensajeObtenido);

        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
    @Test
    public void testInsertarProductoDatosVacios(){
        try{

            driver.get(url);
            driver.findElement(By.id("txtUsuario")).clear();
            driver.findElement(By.id("txtUsuario")).sendKeys("admin");

            WebElement txtClave = driver.findElement(By.id("txtClave"));
            txtClave.clear();
            txtClave.sendKeys("clave");

            WebElement btnIniciarSesion = driver.findElement(By.id("btnIniciarSesion"));
            btnIniciarSesion.click();

            Thread.sleep(2000); //una demora de dos segundos
            driver.findElement(By.xpath("/html/body/section/div[1]/div")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/section/div[1]/nav/ul/li/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Mnt. de Productos")).click();
            driver.findElement(By.id("btnNuevo")).click();
            driver.findElement(By.id("txtNombre")).clear();
            driver.findElement(By.id("txtPrecio")).clear();

            driver.findElement(By.id("btnGuardar")).click();

            Thread.sleep(2000);

            String mensajeEsperado= "Nombre: Error de validación: se necesita un valor.\n" +
                    "Precio: Error de validación: se necesita un valor.";
            String mensajeObtenido= driver.findElement(By.id("messages")).getText();

            assertEquals(mensajeEsperado, mensajeObtenido);

        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
}
