/**
 * 
 */
package org.karuppaiah.sherbat.pages.timberland.sg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author Karuppaiah
 *
 */
public class CategoryPage extends BasePage {

	/**
	 * 
	 */
	String title;

	
	public CategoryPage(String catName,WebDriver driver) {
		super(driver);
		title = catName + " | Timberland Singapore";
		this.setDriver(driver);
	    PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		
	}
	
	public String getTitleString(WebDriver driver){
		return driver.getTitle();
		
	}
	public void verifyTitle(WebDriver driver){
		Assert.assertTrue(
				this.getTitleString(driver).contains(
						title),
				"Page title doesn't match");
	}
	
	public void verifyPage(WebDriver driver){
		Assert.assertTrue(
				this.getTitleString(driver).contains(
						title),
				"Page title doesn't match");
		
	}
	
	
	public void clickProductWithName(WebDriver driver, String name){
		driver.findElement(By.xpath("//img[@alt=\""+name.trim()+"\"]")).click();
		
	}
	
	public void clickPagination(WebDriver driver,int pagination){
		driver.findElement(By.xpath("(//a[contains(text(),'Load More')])["+pagination+"]")).click();
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

	

	
	
}
