/**
 * 
 */
package org.karuppaiah.sherbat.pages.timberland.sg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * @author Karuppaiah
 *
 */
public class HomePage extends BasePage {

	/**
	 * 
	 */
	String title;
	@FindBy(css="#products-container > div.owl-controls > div.owl-nav > div.owl-next")
	WebElement recommendedRightButton;
	@FindBy(css="#products-container > div.owl-controls > div.owl-nav > div.owl-prev")
	WebElement recommendedLeftButton;
	@FindBy(xpath = "//*[@id=\"products-container\"]/div[1]/div/div[6]/li/div/div[1]")
	WebElement recommendedProduct1;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		title = "Timberland Singapore - Official Online Store";
	}
	
	public String getTitleString(WebDriver driver){
		return driver.getTitle();
		
	}
	public void verifyTitle(WebDriver driver){
		Assert.assertTrue(
				this.getTitleString(driver).equalsIgnoreCase(
						title),
				"Page title doesn't match");
	}
	
	public void verifyPage(WebDriver driver){
		Assert.assertTrue(
				this.getTitleString(driver).equalsIgnoreCase(
						title),
				"Page title doesn't match");
		
	}
	
	
	public void clickNthRecommendedProduct(WebDriver driver,int position){
		//sample xpath:    //*[@id=\"products-container\"]/div[1]/div/div[6]/li/div/div[1]
		String xpathValue = "//*[@id=\"products-container\"]/div[1]/div/div[" + (position+5) + "]/li/div/div[1]";
		//Allow only position movement till 15
		if (position>5 && position<=10){
			this.getRecommendedRightButton().click();
		}else if (position > 10 && position <=15) {
			this.getRecommendedRightButton().click();
			this.getRecommendedRightButton().click();
		}else if (position<=0){
			return;
		}
		driver.findElement(By.id(xpathValue)).click();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the recommendedRightButton
	 */
	public WebElement getRecommendedRightButton() {
		return recommendedRightButton;
	}

	/**
	 * @param recommendedRightButton the recommendedRightButton to set
	 */
	public void setRecommendedRightButton(WebElement recommendedRightButton) {
		this.recommendedRightButton = recommendedRightButton;
	}

	/**
	 * @return the recommendedLeftButton
	 */
	public WebElement getRecommendedLeftButton() {
		return recommendedLeftButton;
	}

	/**
	 * @param recommendedLeftButton the recommendedLeftButton to set
	 */
	public void setRecommendedLeftButton(WebElement recommendedLeftButton) {
		this.recommendedLeftButton = recommendedLeftButton;
	}

	/**
	 * @return the recommendedProduct1
	 */
	public WebElement getRecommendedProduct1() {
		return recommendedProduct1;
	}

	/**
	 * @param recommendedProduct1 the recommendedProduct1 to set
	 */
	public void setRecommendedProduct1(WebElement recommendedProduct1) {
		this.recommendedProduct1 = recommendedProduct1;
	}

	
	
}
