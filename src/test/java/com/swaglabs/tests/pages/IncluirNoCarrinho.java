package com.swaglabs.tests.pages;

import com.swaglabs.tests.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IncluirNoCarrinho extends BasePage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement item1;
    @FindBy(id ="add-to-cart-sauce-labs-bike-light")
    private WebElement item2;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement item3;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement item4;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement item5;
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement item6;
    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement removeBotton;
    @FindBy(className = "title")
    private WebElement titulo;
    @FindBy(id = "shopping_cart_container")
    private WebElement carrinho;
    @FindBy(className = "cart_quantity")
    private WebElement qtde;
    @FindBy(id = "checkout")
    private WebElement checkout;
    @FindBy(id = "first-name")
    private WebElement nome;
    @FindBy(id = "last-name")
    private WebElement sobrenome;
    @FindBy(id = "postal-code")
    private WebElement cep;
    @FindBy(id = "continue")
    private WebElement avancar;


    public IncluirNoCarrinho(WebDriver navegador) {
        super(navegador);
    }
    public EntrarNaPagina incluirProdutoNoCarrinho(){
        item1.click();
        carrinho.click();
        return new EntrarNaPagina(navegador);
    }
    public String incluirItemNoCarrinho(){
        return qtde.getText();
    }
    public EntrarNaPagina excluirProdutoDoCarrinho(){
        item2.click();
        carrinho.click();
        removeBotton.click();
        return new EntrarNaPagina(navegador);
    }
    public String verificarCarrinho(){
        return titulo.getText();
    }
    public EntrarNaPagina fazerCheckoutNoCarrinho(){
        item3.click();
        item4.click();
        item5.click();
        item6.click();
        carrinho.click();
        checkout.click();
        return new EntrarNaPagina(navegador);
    }
    public String verificarCheckout(){
        return titulo.getText();
    }
    public EntrarNaPagina preencherDadosValidosCheckout(){
        item3.click();
        item4.click();
        item5.click();
        item6.click();
        carrinho.click();
        checkout.click();
        nome.sendKeys("Joe");
        sobrenome.sendKeys("Pinetree");
        cep.sendKeys("60175047");
        avancar.click();
        return new EntrarNaPagina(navegador);
    }
    public String verificarCheckoutComplete(){
        return titulo.getText();
    }
}
