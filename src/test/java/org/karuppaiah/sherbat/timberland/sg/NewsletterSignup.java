/**
 * 
 */
package org.karuppaiah.sherbat.timberland.sg;

import org.karuppaiah.sherbat.pages.timberland.sg.BasePage;
import org.karuppaiah.sherbat.pages.timberland.sg.HomePage;
import org.karuppaiah.sherbat.testcase.ChromeBaseTestcase;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Karuppaiah
 *
 */
public class NewsletterSignup extends ChromeBaseTestcase {

	/**
	 * 
	 */
	public NewsletterSignup() {
	}
	
	@Test
	public void testNewsletterSignupFailure() {
		
		this.getDriver().navigate().to("http://uatenv:uat@singpost@timberlandsguat.specom.io");
	
		
		HomePage homePage = PageFactory.initElements(this.getDriver(), HomePage.class);
		homePage.verifyTitle(this.getDriver());;
		homePage.getPopupCloseLink().click();
		homePage.getHeaderLogo().click();
		homePage.getNewsletterTextBox().sendKeys("karuppaiah@singpost.com");
		homePage.getGenderMale().click();
		homePage.getNewsletterButton().click();	
		homePage.WaitToVerifyText(this.getDriver(), homePage.getNewsletterMessageFailure(), "There was a problem with the subscription: This email address already exist.");
		homePage.captureScreenShot();
		
	}
	
	


}
