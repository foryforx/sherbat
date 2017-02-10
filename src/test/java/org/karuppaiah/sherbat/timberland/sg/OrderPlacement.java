/**
 * 
 */
package org.karuppaiah.sherbat.timberland.sg;

import org.karuppaiah.sherbat.pages.timberland.sg.CategoryPage;
import org.karuppaiah.sherbat.pages.timberland.sg.HomePage;
import org.karuppaiah.sherbat.pages.timberland.sg.PDPPage;
import org.karuppaiah.sherbat.testcase.ChromeBaseTestcase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
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
		
		this.getDriver().navigate().to("http://uatenv:uat@singpost@timberlandsguat.specom.io");
	
		
		HomePage homePage = PageFactory.initElements(this.getDriver(), HomePage.class);
		homePage.verifyTitle(this.getDriver());
		homePage.getPopupCloseLink().click();
		this.getDriver().navigate().to("http://uatenv:uat@singpost@timberlandsguat.specom.io/men/apparel/shirts.html");
		//homePage.clickMenuLink(this.getDriver(), "Shirts",this.getDriver().findElement(By.linkText("Men")));
		CategoryPage categoryPage = new CategoryPage("Shirts");

		categoryPage.clickProductWithName(this.getDriver(), "Men's Double Layer Plaid Long Sleeve Shirt");
		PDPPage pdpPage = PageFactory.initElements(this.getDriver(), PDPPage.class);
		pdpPage.selectColor(this.getDriver(), "Cilantro");
		pdpPage.selectSize(this.getDriver(), "00S|0OS");
		pdpPage.selectQuantity(this.getDriver(), "1");
		pdpPage.addToCart(this.getDriver());
		
		
		
		homePage.captureScreenShot(this.getDriver());
		
	}

}
