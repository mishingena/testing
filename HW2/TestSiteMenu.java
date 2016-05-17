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

        goToProfile();
        goToEditorialMaterials();
        goToBlog();
        
		signOut();
	}
}
