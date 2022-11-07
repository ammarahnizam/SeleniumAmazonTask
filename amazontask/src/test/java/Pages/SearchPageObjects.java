
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;


public class SearchPageObjects {

    WebDriver driver;

	public SearchPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//******************** Web Elements**********************

	@FindBy(how = How.ID, using = "nav-hamburger-menu")
	WebElement hamburgerMenuIcon;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='TV, Appliances, Electronics']")
	WebElement tvApplianceElectronicCategory;

	@FindBy(how = How.XPATH, using = "//a[.='Televisions']")
	WebElement televisionCategory;

	@FindBy(how = How.XPATH, using = "//span[text()='Samsung']")
	WebElement brandCheckbox;

	@FindBy(how = How.XPATH, using = "//*[@id='a-autoid-0-announce']")
	WebElement sortFilter;

	@FindBy(how = How.XPATH, using = "//a[@id='s-result-sort-select_2']")
	WebElement sortFilterOption;

	@FindBy(how = How.XPATH, using = "//*[@data-cel-widget='MAIN-SEARCH_RESULTS-2']")
	WebElement secondItem;

	@FindBy(how = How.XPATH, using = "//h1[@class='a-size-base-plus a-text-bold']")
	public WebElement aboutThisItemHeading;

//********************User Actions(Methods)**********************

	public void clickOnHamburgerMenu() {
		hamburgerMenuIcon.click();

	}

	public void clickOnTVApplianceCategory() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(tvApplianceElectronicCategory)).click();

	}

	public void clickOnTelevisionCategory() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(televisionCategory)).click();

	}

	public void selectBrandCheckbox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(brandCheckbox)).click();

	}

	public void openSortByFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(sortFilter)).click();

	}

	public void selectSortByOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(sortFilterOption)).click();

	}

	public void clickOnSecondHighPriceItem() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(secondItem)).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		

	}



}