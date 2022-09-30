package com.swaglabs.tests.teste;

import com.swaglabs.tests.pages.EntrarNaPagina;
import com.swaglabs.tests.pages.IncluirNoCarrinho;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.plaf.basic.BasicButtonUI;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Automatizado do SwagLabs")
public class SwagLabs {
    private WebDriver navegador; // Atributo privado
    @BeforeEach
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver(options);
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
    @Test
    @DisplayName("Excluir Produtos do Carrinho")
    public void excluirProdutoDoCarrinho(){
        new EntrarNaPagina(navegador)
                .acessarPaginaDoSwagLabs()
                .fazerLoginNaPagina()
                .entrouNaPagina();
        new IncluirNoCarrinho(navegador)
                .excluirProdutoDoCarrinho();
        String newCart = new IncluirNoCarrinho(navegador)
                .verificarCarrinho();
        Assertions.assertEquals("YOUR CART",newCart );
    }
    @Test
    @DisplayName("Fazer Checkout do Carrinho")
    public void fazerCheckoutDoCarrinho(){
        new EntrarNaPagina(navegador)
                .acessarPaginaDoSwagLabs()
                .fazerLoginNaPagina()
                .entrouNaPagina();
        new IncluirNoCarrinho(navegador)
                .fazerCheckoutNoCarrinho();
        String checkout = new IncluirNoCarrinho(navegador)
                .verificarCheckout();
        Assertions.assertEquals("CHECKOUT: YOUR INFORMATION", checkout);
    }
    @Test
    @DisplayName("Checkout com Dados Validos")
    public void preencherDadosValidosCheckout() {
        new EntrarNaPagina(navegador)
                .acessarPaginaDoSwagLabs()
                .fazerLoginNaPagina()
                .entrouNaPagina();
        new IncluirNoCarrinho(navegador)
                .preencherDadosValidosCheckout();
        String CheckDadosValidos = new IncluirNoCarrinho(navegador)
                .verificarCheckoutComplete();
        Assertions.assertEquals("CHECKOUT: OVERVIEW", CheckDadosValidos);
    }

    @AfterEach
    public void tearDown(){
        navegador.quit();
    }
}
