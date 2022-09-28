package com.swaglabs.tests.pages;

import com.swaglabs.tests.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IncluirNoCarrinho extends BasePage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement item;
    @FindBy(id = "shopping_cart_container")
    private WebElement carrinho;
    @FindBy(className = "cart_quantity")
    private WebElement qtde;

    public IncluirNoCarrinho(WebDriver navegador) {
        super(navegador);
    }
    public EntrarNaPagina incluirProdutoNoCarrinho(){
        item.click();
        carrinho.click();
        return new EntrarNaPagina(navegador);
    }
    public String incluirItemNoCarrinho(){
        return qtde.getText();
    }
}
