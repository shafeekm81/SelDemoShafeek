package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

	private WebDriver driver;
	private String expectedValue;
	private String actualValue;

	@BeforeTest
	@Parameters("browser") // here the parameter act as a Tape in which water source flows into all below
	// if statements but the get the water source right click on the respective
	// class >
	// TestNG > Convert to TestNG (which will create an XML as testng.xml)
	// Now edit XML to define the parameter by passing name as 'browser' and value
	// as all the browsers so during runtime parameter from xml should pass on to
	// @Parameter annotation which flows further down the line for all below
	// statements
	// Now the script cannot be run from this class itself. it suppose to run from
	// testng.xml so execute from xml file not from java file
	// To run all the browser in parallel, just mention <suite name="Suite" parallel
	// = "tests">
	// Difference between Sequential and Parallel run is about good performance in
	// execution time and it depends on the hardware too
	public void openBrowser(String browser) {
		// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}

		else if (browser.equals("Internet Explorer")) {

			System.setProperty("Webdriver.ie.driver", "IEDriverServer.exe");
			// WebDriver driver = new InternetExplorerDriver(); // here we don't need to
			// mention "WebDriver" again as it
			// will act as different which will execute as own
			// and end up with null pointer exception so omit the
			// WebDriver and always create the driver only once but
			// initialization can takes place multiple times
			driver = new InternetExplorerDriver();

		} else if (browser.equals("Edge")) {

			System.setProperty("webdriver.Edge.driver", "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}

		else if (browser.equals("FireFox")) {

			System.setProperty("Webdriver.firefox.marionette", "geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://account.t-mobile.com/");

	}

	@Test(priority = 0)
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
		
		//Today is Wednesday
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
