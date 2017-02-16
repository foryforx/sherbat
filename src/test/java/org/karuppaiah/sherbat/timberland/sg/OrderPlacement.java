/**
 * 
 */
package org.karuppaiah.sherbat.timberland.sg;

import org.karuppaiah.sherbat.pages.timberland.sg.CategoryPage;
import org.karuppaiah.sherbat.pages.timberland.sg.HomePage;
import org.karuppaiah.sherbat.pages.timberland.sg.PDPPage;
import org.karuppaiah.sherbat.testcase.ChromeBaseTestcase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * @author Karuppaiah
 *
 */
public class OrderPlacement extends ChromeBaseTestcase {

	/**
	 * 
	 */
	public OrderPlacement() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testOrderPlacement() {
		try {
			this.getDriver().navigate().to("http://uatenv:uat@singpost@timberlandsguat.specom.io");
		
			
			HomePage homePage = new HomePage(this.getDriver());
			homePage.verifyTitle(this.getDriver());
			homePage.getPopupCloseLink().click();
			//this.getDriver().navigate().to("http://uatenv:uat@singpost@timberlandsguat.specom.io/men/apparel/shirts.html");
			//homePage.clickMenuLink(this.getDriver(), "Shirts",this.getDriver().findElement(By.linkText("Men")));
			
			//homePage.mainMenuSelection("Men", "//a[contains(text(),'Shirts')]");
			Actions builder = new Actions(this.getDriver());
			WebElement rootElement = this.getDriver().findElement(By.linkText("Men"));
			builder.moveToElement(rootElement).moveToElement(this.getDriver().findElement(By.xpath("//a[contains(text(),'Shirts')]"))).click().build().perform();
			//builder.moveToElement(rootElement).perform();
			//By locator = By.linkText("Shirts");
			//this.getDriver().click(locator);
			homePage.captureScreenShot();
			CategoryPage categoryPage = new CategoryPage("Shirts",this.getDriver());
	
			categoryPage.clickProductWithName(this.getDriver(), "Men's Double Layer Plaid Long Sleeve Shirt");
			PDPPage pdpPage = new PDPPage(this.getDriver());
			pdpPage.selectColor(this.getDriver(), "Cilantro");
			pdpPage.selectSize(this.getDriver(), "00S|0OS");
			pdpPage.selectQuantity(this.getDriver(), "1");
			pdpPage.addToCart(this.getDriver());
			
			
			
			homePage.captureScreenShot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
