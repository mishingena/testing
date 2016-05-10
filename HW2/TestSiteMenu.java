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
