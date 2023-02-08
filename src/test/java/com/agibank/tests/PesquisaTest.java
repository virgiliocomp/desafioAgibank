package com.agibank.tests;

import com.agibank.webpages.Home;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class PesquisaTest {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void pesquisaTest(){
        Home home = new Home(driver);
        home.clicarBotaoLupa();
        Assertions.assertTrue(home.divPesquisaIsDisplayed());
    }

    @Test
    public void placeHolderPesquisaTest(){
        Home home = new Home(driver);
        home.clicarBotaoLupa();
        Assertions.assertEquals("Pesquisar …", home.placeholderCaixaPesquisa());
    }
    @Test
    public void inputPesquisaTest() {
        Home home = new Home(driver);
        home.clicarBotaoLupa();
        home.digitarCaixaPesquisa("Teste");
        Assertions.assertEquals("Teste", home.textoCaixaPesquisa());
    }

    @AfterEach
    public void quit(){
        driver.quit();
    }

}
