package Tests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.SearchPageObjects;

public class SearchTestSpec {
	public WebDriver driver;
	String baseURL = "http://localhost:4444";

	@BeforeClass
	public void initialize() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URL(baseURL), caps);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}

	@Test()
	public void searchOnAmazon() throws Exception {
		SearchPageObjects homepage = PageFactory.initElements(driver, SearchPageObjects.class);
		homepage.clickOnHamburgerMenu();
		homepage.clickOnTVApplianceCategory();
		homepage.clickOnTelevisionCategory();
		homepage.selectBrandCheckbox();
		homepage.openSortByFilter();
		homepage.selectSortByOption();
		homepage.clickOnSecondHighPriceItem();
		Thread.sleep(3000);
		Assert.assertEquals(true, homepage.aboutThisItemHeading.isDisplayed());
		Reporter.log("About This Item Label is Present", true);

	}

	@AfterClass

	public void TeardownTest() {
		driver.quit();
	}

}