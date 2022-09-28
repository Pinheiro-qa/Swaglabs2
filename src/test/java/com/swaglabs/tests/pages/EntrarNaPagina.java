package com.swaglabs.tests.pages;

import com.swaglabs.tests.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntrarNaPagina extends BasePage {

    @FindBy(id = "user-name")
    private WebElement cUsuario;
    @FindBy(id = "password")
    private WebElement cSenha;
    @FindBy(id = "login-button")
    private WebElement botaoEntrar;
    @FindBy(className = "title")
    private WebElement title;

    public EntrarNaPagina(WebDriver navegador) {
        super(navegador);
    }
    public EntrarNaPagina acessarPaginaDoSwagLabs(){
        navegador.get("https://www.saucedemo.com/");
        return new EntrarNaPagina(navegador);
    }
    public EntrarNaPagina fazerLoginNaPagina(){
        cUsuario.sendKeys("standard_user");
        cSenha.sendKeys("secret_sauce");
        botaoEntrar.click();
        return new EntrarNaPagina(navegador);
    }
    public String entrouNaPagina(){
        return title.getText();
    }
}
