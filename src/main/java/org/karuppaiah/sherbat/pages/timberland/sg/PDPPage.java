/**
 * 
 */
package org.karuppaiah.sherbat.pages.timberland.sg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
/**
 * @author Karuppaiah
 *
 */
public class PDPPage extends BasePage {

	/**
	 * 
	 */
	@FindBy(id="colorNmId")
	WebElement colorName;
	public PDPPage() {
		// TODO Auto-generated constructor stub
	}
	
	public void selectColor(WebDriver driver, String colorName){
		driver.findElement(By.cssSelector("img[alt=\""+ colorName +"\"]")).click();
	}
	
	
	public void selectSize(WebDriver driver,String sizeName){
		driver.findElement(By.cssSelector("a[title=\""+sizeName+"\"] > em")).click();
	}
	
	
	public void selectQuantity(WebDriver driver, String quantiy){
		Select dropdown = new Select(driver.findElement(By.id("qty")));
		dropdown.selectByValue(quantiy);
		
	}
	
	public void addToCart(WebDriver driver){
		driver.findElement(By.xpath("//button[@type='button']")).click();
		try {
			driver.wait(10000);
			driver.findElement(By.cssSelector("div.cartOverlay")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
