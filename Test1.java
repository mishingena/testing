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

public class Test1 {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://www.iguides.ru/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void test() throws Exception {
		selenium.open("/");
		selenium.click("css=div.antiblockMessage > input[type=\"button\"]");
		selenium.click("link=Авторизация");
		selenium.type("name=USER_LOGIN", "username");
		selenium.type("name=USER_PASSWORD", "password");
		selenium.click("name=Login");
		selenium.click("link=Технологии");
		selenium.click("link=Профиль");
		selenium.click("css=div.link.right > a");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Мои подписки");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Редакционные материалы");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Профиль");
		selenium.click("link=Блоги 0");
		selenium.click("link=Выход");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
