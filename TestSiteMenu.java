package com.example.tests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class TestSiteMenu extends TestBase {
	@Test
	public void testMenu() throws Exception {
		AuthorizationCredentials credentials = new AuthorizationCredentials("username", "password")

		openUrl(baseUrl);

		signIn(credentials);

		click("link=Технологии");
		waitForLoadPage("30000");
        click("link=Профиль");
        waitForLoadPage("30000");
        click("css=div.link.right > a");
        waitForLoadPage("30000");
        click("link=Мои подписки");
        waitForLoadPage("30000");
        click("link=Редакционные материалы");
        waitForLoadPage("30000");
        click("link=Профиль");
        waitForLoadPage("30000");
        click("link=Блоги 0");
        waitForLoadPage("30000");
		signOut();
	}


}
