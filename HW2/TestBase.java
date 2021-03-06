package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class TestBasr {
    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "https://www.iguides.ru/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void test() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }

    public void openUrl(String url) {
        selenium.open(url);
    }

    public void signIn(AuthorizationCred.entials credentials) {
        goToAuth();
        type("name=USER_LOGIN", credentials.login);
        type("name=USER_PASSWORD", credentials.password);
        signIn();
    }

    public void goToAuth() {
        click("link=Авторизация");   
    }

    public void signIn() {
        click("name=Login");
    }

    public void signOut() {
        click("link=Выход");
    }

    public void type(String field, String value) {
        selenium.type(field, value);
    }

    public void click(String link) {
        selenium.click(link);
    }

    public void waitForLoadPage(String timeout) {
        selenium.waitForPageToLoad(timeout);
    }

    public void openProfile() {
        click("link=Ïðîôèëü");
    }

    public void openEditorialMaterials() {
        click("css=div.link.right > a");
        waitForLoadPage("30000");
        click("link=Ìîè ïîäïèñêè");
        waitForPageToLoad("30000");
    }

    public void goToEditorialMaterials() {
        click("link=Мои подписки");
        waitForPageToLoad("30000");
    }

    public void goToProfile(){
        click("link=Профиль");
        waitForLoadPage("30000");
        click("css=div.link.right > a");
        waitForLoadPage("30000");
    }   

    public void goToBlog() {
        click("link=Блоги 0");
        waitForLoadPage("30000");
    }
}