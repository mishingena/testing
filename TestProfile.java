package com.example.tests;

import org.junit.*;
import org.openqa.selenium.*;

public class TestProfile extends TestBase {
	@Test
	public void testProfile() throws Exception {
			  
		AuthorizationCredentials credentials = new AuthorizationCredentials("username", "password")

		openUrl(baseUrl);

		signIn(credentials);

		click("link=Профиль");
		click("css=div.link.right > a");
		waitForLoadPage("30000");
        click("link=Мои подписки");
        waitForPageToLoad("30000");

		signOut();
	}


}