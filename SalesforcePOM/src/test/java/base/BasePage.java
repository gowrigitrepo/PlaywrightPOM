package base;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.options.SelectOption;

import reportlisteners.ExtentListeners;
import utilities.AccessApplicationProperty;

public class BasePage extends AccessApplicationProperty{

	public static Page page;

	public BasePage(Page page) {

		this.page = page;
	}

	public void click(String locatorKey) {

		try {
			page.locator(locatorKey).click();
			ExtentListeners.getExtent().info("Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {

			ExtentListeners.getExtent()
					.fail("Clicking on an Element : " + locatorKey + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}
	
	public void click(Locator locator) {

		try {
			locator.click();
			ExtentListeners.getExtent().info("Clicking on an Element : " + locator);
		} catch (Throwable t) {

			ExtentListeners.getExtent()
					.fail("Clicking on an Element : " + locator + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}

	public void mouseHover(String locatorKey) {

		try {
			page.hover(locatorKey);
			ExtentListeners.getExtent().info("Moving on an Element : " + locatorKey);
		} catch (Throwable t) {

			ExtentListeners.getExtent()
					.fail("Error while Moving on an Element : " + locatorKey + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}

	public boolean isElementPresent(String locatorKey) {

		try {
			page.waitForSelector((locatorKey), new WaitForSelectorOptions().setTimeout(2000));
			ExtentListeners.getExtent().info("Finding an Element : " + locatorKey);
			return true;
		} catch (Throwable t) {
			ExtentListeners.getExtent().fail("Error while finding an Element : " + locatorKey);
			return false;
		}

	}

	public void type(String locatorKey, String value) {
		try {
			page.locator(locatorKey).fill(value);
			ExtentListeners.getExtent()
					.info("Typing in an Element : " + locatorKey + " and entered the value as :" + value);
		} catch (Throwable t) {

			ExtentListeners.getExtent().fail(
					"Error while typing in an Element : " + t.getMessage() + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}

	public void select(String locatorKey, String value) {
		try {
			page.selectOption((locatorKey), new SelectOption().setLabel(value));
			ExtentListeners.getExtent()
					.info("Selecting an Element : " + locatorKey + " and selected the value as :" + value);
		} catch (Throwable t) {

			ExtentListeners.getExtent().fail(
					"Error while Selecting an Element : " + t.getMessage() + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}
	
	public Locator getListValues(String locatorKey) {
		Locator appListValues = null;
		try {
			appListValues = page.locator(locatorKey);
			ExtentListeners.getExtent().info("Returns list values on an Element : " + locatorKey);
		} catch (Throwable t) {

			ExtentListeners.getExtent()
					.fail("Error while getting list values on an Element : " + locatorKey + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
		return appListValues;
	}
	
	public void selectValue(Locator locatorListValues,String searchValue) {
	
		try {
			for (Locator value : locatorListValues.all()) {
				if (value.textContent().equals(searchValue)) {
					click(value);
					break;
				}
			}
			ExtentListeners.getExtent().info("Select the value : " + searchValue);
		} catch (Throwable t) {

			ExtentListeners.getExtent()
					.fail("Error while selecting value : "+ searchValue + "  - error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}
	
	public String getInnerText(String locatorKey) {
		String innerText = null;
		try {
			innerText = page.innerText(locatorKey);
			ExtentListeners.getExtent().info("Returns inner text on an Element : " + locatorKey);
		} catch (Throwable t) {

			ExtentListeners.getExtent()
					.fail("Error while getting inner text on an Element : " + locatorKey + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
		return innerText;
	}
	
	public String getTitle() {
		String title = null;
		try {
			title = page.title();
			ExtentListeners.getExtent().info("Returns page title");
		} catch (Throwable t) {

			ExtentListeners.getExtent()
					.fail("Error while returning page title" + t.getMessage());
			Assert.fail(t.getMessage());
		}
		return title;
	}
	
	

}
