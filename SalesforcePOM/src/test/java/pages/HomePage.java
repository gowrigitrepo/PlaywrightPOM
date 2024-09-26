package pages;

import java.util.Random;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.BasePage;

public class HomePage extends BasePage{
	public HomePage(Page page) {
		super(page);
	}

	private String appLauncher = ".slds-icon-waffle";
	private String searchApp = "//input[@placeholder='Search apps and items...']";
	private String appList = "//div[@aria-label='Apps']//one-app-launcher-menu-item";
	private String tabNameFirst = "//a[contains(@title,'";
	private String tabNameLast = "')]/span";
	private String newButton = "//div[contains(text(),'New')]";
	private String accountName = "//input[@name='Name']";
	private String type = "//div[@part='combobox']/label[text()='Type']/parent::div/child::div//button";
	private String typeListFirst = "//div[@part='combobox']/label[text()='Type']/parent::div//child::div[@aria-label='Type']//lightning-base-combobox-item//span[@class='slds-media__body']/span[text()='";
	private String typeListLast = "']";
	private String ownership = "//div[@part='combobox']/label[text()='Ownership']/parent::div/child::div//button";
	private String ownershipListFirst = "//div[@part='combobox']/label[text()='Ownership']/parent::div//child::div[@aria-label='Ownership']//lightning-base-combobox-item//span[@class='slds-media__body']/span[text()='";
	private String ownershipListLast = "']";
	private String description = "//label[text()='Description']/parent::lightning-textarea/child::div/textarea";
	private String saveButton = "//button[@name='SaveEdit']";

	public void searchApp(String appNameToSearch) throws InterruptedException {
		System.out.println("Entered searchApp");
		click(appLauncher);
		System.out.println("App Launcher clicked");
		type(searchApp, appNameToSearch);
		System.out.println("Entered AppName : " + appNameToSearch);
		selectValue(getListValues(appList),appNameToSearch);
		// System.out.println("appListValues count : "+appListValues.count());
		
	}

	public void searchTab(String tabNameToSearch) {
		System.out.println("Entered searchTab");
		click(tabNameFirst + tabNameToSearch + tabNameLast);
	}

	public void clickNewButton() {
		click(newButton);
	}

	public void createAccount(String typeValue, String ownershipValue) {
		Random random = new Random();
		int randomNumber = random.nextInt();
		String acountNme = "AC" + "" + randomNumber;

		//page.click(accountName);
		type(accountName, acountNme);
		System.out.println("Account Name element clicked and filled : " + acountNme);

		click(type);
		System.out.println("Scrolled to type element");
		Locator typeListValues = getListValues(typeListFirst + typeValue + typeListLast);
		selectValue(typeListValues, typeValue);
		
		click(ownership);
		System.out.println("Scrolled to ownership element");
		Locator ownershipListValues = getListValues(ownershipListFirst + ownershipValue + ownershipListLast);
		selectValue(ownershipListValues, ownershipValue);
		
		String descriptionValue = "Account Created with Account ID : " + getInnerText(accountName);
		type(description, descriptionValue);
		System.out.println("Filled in description");
		
		click(saveButton);
		System.out.println("Clicked Save button");
		
		//page.click("//tbody//tr/th/span/a[contains(text(),'AC421087697')]");

	}

}
