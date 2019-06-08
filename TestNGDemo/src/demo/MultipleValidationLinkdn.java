package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleValidationLinkdn {
	private WebDriver driver;
	private String expectedValue;
	private String actualValue;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://account.t-mobile.com/");

		// When running multiple test together, the ORDER will not be in
		// sequence(runs in methods name alphabet order) as
		// we written in the below order so use priority in each test annotation to
		// avoid the failures

	}

//
//	@Test(priority = 0)
//	public void verifyTitle() {
//		expectedValue = "JCPenney Home";
//		actualValue = driver.getTitle();
//		Assert.assertEquals(actualValue, expectedValue);
//	}
//
//	// each test case verification must be written in each test annotation not
//	// combined together in single test annotation
//
	@Test(priority = 0) // here the priority is defined to run the test case in sequence else this will
						// run in method alphabet order
	public void verifySigninBtnVisibility() {

		boolean signInVisibility = driver.findElement(By.cssSelector(
				"#globalHeader > app-root > div:nth-child(3) > div > div.ng-tns-c2-0.ng-trigger.ng-trigger-routeAnimations > app-login > div > div > div.animate-ui-view > div > div > button"))
				.isDisplayed();
		Assert.assertTrue(signInVisibility);
	}

//
	@Test(priority = 1)
	public void verifyText() {
		expectedValue = "Log in";
		actualValue = driver.findElement(By.cssSelector(
				"#globalHeader > app-root > div:nth-child(3) > div > div.ng-tns-c2-0.ng-trigger.ng-trigger-routeAnimations > app-login > div > div > div.animate-ui-view > div > h1"))
				.getText();
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Test(priority = 2) // (priority = 2, enabled = false) to skip this step
	public void verifySearchBtnStsBeforeEnteringText() {

		boolean searchBtnStats = driver.findElement(By.cssSelector(
				"#globalHeader > app-root > div:nth-child(3) > div > div.ng-tns-c2-0.ng-trigger.ng-trigger-routeAnimations > app-login > div > div > div.animate-ui-view > div > form > div > div.text_box_group.margin-bottom-20.ng-star-inserted > button"))
				.isEnabled();
		Assert.assertFalse(searchBtnStats);

	}

//
	@Test(priority = 3)
	public void verifySearchBtnStsAfterEnteringText() {
		driver.findElement(By.id("usernameTextBox")).sendKeys("abc@gmail.com");
		boolean searchBtnStats = driver.findElement(By.cssSelector(
				"#globalHeader > app-root > div:nth-child(3) > div > div.ng-tns-c2-0.ng-trigger.ng-trigger-routeAnimations > app-login > div > div > div.animate-ui-view > div > form > div > div.text_box_group.margin-bottom-20.ng-star-inserted > button"))
				.isEnabled();
		Assert.assertTrue(searchBtnStats);

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
