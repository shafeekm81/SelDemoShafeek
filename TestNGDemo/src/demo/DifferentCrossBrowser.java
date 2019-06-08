package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class DifferentCrossBrowser {

	@Test
	public void openBrowser() {
//		System.setProperty("Webdriver.firefox.marionette", "geckodriver.exe");// download and install the firefox
//																				// webdriver as usual like Chrome
//		WebDriver driver = new FirefoxDriver();

//		System.setProperty("Webdriver.ie.driver", "IEDriverServer.exe"); // only when using IE browser we need to do
//																			// additional set up in IE that i) Settings
//																			// > Zoom% > 100% ii) Settings > Internet
//																			// Option > Security > make sure all zones
//																			// are equally enabled or disabled the
//																			// protected mode and its
//																			// one time activity
//		WebDriver driver = new InternetExplorerDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://facebook.com/"); // locating the element is all similar to other browser using developer
//												// tool F12 except Css selector, so in that case get the css selector
//												// from
//												// chrome and can use it in IE, so locator remains the same

		System.setProperty("webdriver.Edge.driver", "MicrosoftWebDriver.exe");// download the edge driver in the same
																				// way from selenium/download
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://facebook.com/");

	}

}
