package com.example.tests;

import org.junit.*;
import org.openqa.selenium.*;

public class TestProfile extends TestBase {
	@Test
	public void testProfile() throws Exception { 
		AuthorizationCredentials credentials = new AuthorizationCredentials("username", "password")

		openUrl(baseUrl);

		signIn(credentials);
		openProfile();
		openEditorialMaterials();
		
		signOut();
	}
}