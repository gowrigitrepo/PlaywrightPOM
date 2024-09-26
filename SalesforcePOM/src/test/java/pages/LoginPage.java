package pages;

import com.microsoft.playwright.Page;

import base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(Page page) {
		super(page);
	}

	//Locators
	private String userName = "[id='username']";
	private String password = "[id='password']";
	private String loginButton = "input:has-text('Log In')";
	
	//Page Methods	
	
	public void login(String userID, String passID) {
		type(userName, userID);
		type(password, passID);
		click(loginButton);
	}

}
