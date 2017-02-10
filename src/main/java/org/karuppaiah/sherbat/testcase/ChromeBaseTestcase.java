/**
 * 
 */
package org.karuppaiah.sherbat.testcase;

import org.karuppaiah.sherbat.pages.timberland.sg.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Class to initiate a chrome driver and get ready for usage in test case. All
 * Test classes should extend from this base class
 * 
 * @author Karuppaiah
 *
 */
public class ChromeBaseTestcase {

	/**
	 * Declaration of variables
	 * 
	 * @author Karuppaia
	 */
	public static String driverPath = System.getProperty("user.dir")
			+ "\\selenium_standalone\\windows\\googlechrome\\64bit\\";
	private WebDriver driver;

	/**
	 * @return the driver
	 * @author Karuppaia
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver
	 *            the driver to set
	 * @author Karuppaia
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Constructor to setup the driver
	 * 
	 * @author Karuppaiah
	 */
	public ChromeBaseTestcase() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver",
				driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	
	/**
	 * Quit driver object
	 * 
	 * @author Karuppaia
	 */
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			System.out.println("Closing chrome browser");
			driver.quit();
		}
	}

}
