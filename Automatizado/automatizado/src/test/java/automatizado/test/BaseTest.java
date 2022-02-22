package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *Classe base que serve de herança para todas as classes de teste.
 */
 
public abstract class BaseTest {

    /**Driver do navegador da pagina atual*/
    protected static WebDriver driver;
    /**Caminho base da URL do sistema a ser testado*/
    private static final String URL_BASE = "file:///C:/Gabriel/Git/ProjetoAutomatizadoQA/ProjetoAutomatizadoQA/ProjetoQA/login.html";
    /**Caminho relativo do Driver ao projeto referente ao path */
    private static final String CAMINHO_DRIVER = "automatizado/src/test/java/automatizado/resource/ChromeDriver 98.0.4758.102.exe";

    /**
    *Metodo que inicia o driver do navegador antes de qualquer classe de teste.
    */
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

     /**
    *Metodo que inicia o driver do navegador depois de qualquer classe de teste.
    */
    @AfterClass
    public static void finalizar(){
        driver.quit();
    }

}
