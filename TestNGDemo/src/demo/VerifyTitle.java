package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest; //all annotations from from testng library
import org.testng.annotations.Test;

public class VerifyTitle {
	private WebDriver driver;// here the variable is created at the class level so that it can be extended or
								// used across the method within the class and mark as Private (refer access
								// modifier class) and its a java convention

	@BeforeTest // when using TestNG, main method will not be used rather used this annotations
				// which functioned similar to main method
	// BeforeTest act as a pre-condition
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");

	}

	@Test // what is the action to be performed and what is to be tested in the
			// application
	public void titleVerification() {

		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = driver.getTitle(); // here the driver creates error unless or until the Webdriver driver is
												// extended so refer the line #21 and define the driver variable in
												// class level line #11
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();

	}

}

//Refresh the project to get the test report,expand the report and access "emailable-report.html" and also refer index.html
