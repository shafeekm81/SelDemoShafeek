package demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//here the below annotations are printing based on the sequence (preference order) regardless of any order
//expand index.html to view the order under chronological view

public class AnnotationDemo {

	@BeforeMethod
	public void beforeMethod() {

		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("After Method");
	}

	@BeforeClass
	public void beforeClass() {

		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {

		System.out.println("After Class");
	}

	@BeforeSuite
	public void beforeSuite() {

		System.out.println("Before Suite");
	}

	@AfterSuite
	public void afterSuite() {

		System.out.println("After Suite");// after suite executes after all combination of test cases are executed
	}

	@BeforeTest
	public void beforeTest() {

		System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {

		System.out.println("After Test");
	}

	@Test
	public void test() {

		System.out.println("Test");
	}
}
