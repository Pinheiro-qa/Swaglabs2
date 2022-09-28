package com.swaglabs.tests.teste;

import com.swaglabs.tests.pages.EntrarNaPagina;
import com.swaglabs.tests.pages.IncluirNoCarrinho;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.swing.plaf.basic.BasicButtonUI;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Automatizado do SwagLabs")
public class SwagLabs {
    private WebDriver navegador;
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }
    @Test
    @DisplayName("Entrar na pagina principal")
    public void entrarNaPaginaPrincipal(){
        String entrouNaPagina = new EntrarNaPagina(navegador)
                .acessarPaginaDoSwagLabs()
                .fazerLoginNaPagina()
                .entrouNaPagina();
        Assertions.assertEquals("PRODUCTS", entrouNaPagina);
       }
    @Test
    @DisplayName("Colocar produtos no carrinho")
    public void colocarProdutosNoCarrinho(){
        new EntrarNaPagina(navegador)
                .acessarPaginaDoSwagLabs()
                .fazerLoginNaPagina()
                .entrouNaPagina();
        new IncluirNoCarrinho(navegador)
                .incluirProdutoNoCarrinho();
        String itemNoCart = new IncluirNoCarrinho(navegador)
                .incluirItemNoCarrinho();
        Assertions.assertEquals("1", itemNoCart);
    }
    @AfterEach
    public void tearDown(){
        navegador.quit();
    }
}
