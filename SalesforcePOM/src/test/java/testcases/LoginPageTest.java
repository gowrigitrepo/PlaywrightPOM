package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.AccessApplicationProperty;

public class LoginPageTest extends BaseTest{

	@Test
	public void loginWithValidDetails() {
		browser=getBrowser(AccessApplicationProperty.getApplicationProperty("browserchrome"));
		navigate(browser, AccessApplicationProperty.getApplicationProperty("url"));
		LoginPage loginPage = new LoginPage(page);
		loginPage.login(AccessApplicationProperty.getApplicationProperty("username"), AccessApplicationProperty.getApplicationProperty("password"));
	}
	
	@Test
	public void loginWithoutValidDetails() {
		browser=getBrowser(AccessApplicationProperty.getApplicationProperty("browserchrome"));
		navigate(browser, AccessApplicationProperty.getApplicationProperty("url"));
		LoginPage loginPage = new LoginPage(getPage());
		loginPage.login(AccessApplicationProperty.getApplicationProperty("wrongusername"), AccessApplicationProperty.getApplicationProperty("wrongpassword"));
	}
}
