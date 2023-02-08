package com.agibank.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    private WebDriver driver;

    private static String URL = "https://blogdoagi.com.br/";

    @FindBy(xpath = "//button[@id='search-open']")
    private WebElement lupaButton;

    @FindBy(xpath = "//div[@class='desktop-search']")
    private WebElement divPesquisa;

    @FindBy(xpath = "//input[@name='s']")
    private WebElement inputPesquisa;
    public Home(WebDriver driver){
        this.driver = driver;
        driver.get(URL);

        PageFactory.initElements(driver,this);
    }

    public void clicarBotaoLupa(){
        lupaButton.click();
    }

    public void digitarCaixaPesquisa(String texto){
        inputPesquisa.sendKeys(texto);
    }

    public String placeholderCaixaPesquisa(){
        return inputPesquisa.getAttribute("placeholder");
    }

    public String textoCaixaPesquisa(){
        return inputPesquisa.getAttribute("value");
    }

    public boolean divPesquisaIsDisplayed(){
        return divPesquisa.isDisplayed();
    }
}
