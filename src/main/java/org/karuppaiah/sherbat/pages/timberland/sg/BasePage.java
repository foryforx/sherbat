/**
 * 
 */
package org.karuppaiah.sherbat.pages.timberland.sg;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Abstract class to set basic page properties and methods
 * @author Karuppaiah
 *
 */
public class BasePage {

	/**
	 * Webelements in webpage
	 */
	@FindBy(css = "img.large")
	private WebElement headerLogo;
	@FindBy(css = "button.popup-close-info")
	private WebElement popupCloseLink;
	@FindBy(id = "header-account")
	private WebElement MyAccountLink;
	@FindBy(className="wishlist-label")
	private WebElement wishlistLink;
	@FindBy(className="find-store-label")
	private WebElement findAStoreLink;
	@FindBy(className="minicart-head")
	private WebElement miniCartLink;
	@FindBy(name="q")
	private WebElement seachTextBox;
	@FindBy(id="searchbtn")
	private WebElement searchButton;
	
	
	
	@FindBy(xpath = "//*[@id=\"newsletterSubscriberStickyForm\"]/div/div/div/div[1]/input")
	private WebElement newsletterTextBox;
	@FindBy(id="gender" )
	private WebElement genderMale;
	@FindBy(xpath="(//input[@id='gender'])[2]" )
	private WebElement genderFemale;
	@FindBy(xpath = "//*[@id=\"signup\"]")
	private WebElement newsletterButton;
	@FindBy(css="p.newsletter-msg.failed")
	private WebElement newsletterMessageFailure;
	@FindBy(css="p.newsletter-msg.success")
	private WebElement newsletterMessageSuccess;

	@FindBy(xpath = "//*[@id=\"nav\"]/ul")
	List<WebElement> mainMenuElements;
	
	@FindBy(xpath = "//*[@id=\"nav\"]/ul/li[1]/div/ul")
	List<WebElement> newArrivalCategoryElements;
	
	@FindBy(xpath = "//*[@id=\"nav\"]/ul/li[2]/div/ul")
	List<WebElement> menCategoryElements;
	
	@FindBy(xpath = "//*[@id=\"nav\"]/ul/li[3]/div/ul")
	List<WebElement> womenCategoryElements;
	
	public BasePage() {
		
	}
	
	public Boolean WaitToVerifyText(WebDriver driver, WebElement searchTextElement,String compareText){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.textToBePresentInElement(searchTextElement, compareText));
		
	}
	
	public void WaitToVerifyElementExistance(WebDriver driver, WebElement searchElement){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(searchElement));
		
	}
	
	public void clickMenuLink(WebDriver driver,String catName, WebElement hoverElement){
		Actions action = new Actions(driver);
		action.moveToElement(hoverElement).perform();
		driver.findElement(By.linkText(catName)).click();
	}
	
	public static void captureScreenShot(WebDriver ldriver){
		 // Take screenshot and store as a file format
		 File src= ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		 try {
			 	// now copy the  screenshot to desired location using copyFile method
			 	FileUtils.copyFile(src, new File(System.getProperty("user.dir")
						+ "\\test-output\\"+System.currentTimeMillis()+".png"));
		 	}
		 	catch (IOException e)
		 	{
		 			System.out.println(e.getMessage());
		 	}
	 }
	/**
	 * @return the headerLogo
	 */
	public WebElement getHeaderLogo() {
		return headerLogo;
	}


	/**
	 * @param headerLogo the headerLogo to set
	 */
	public void setHeaderLogo(WebElement headerLogo) {
		this.headerLogo = headerLogo;
	}


	/**
	 * @return the popupCloseLink
	 */
	public WebElement getPopupCloseLink() {
		return popupCloseLink;
	}


	/**
	 * @param popupCloseLink the popupCloseLink to set
	 */
	public void setPopupCloseLink(WebElement popupCloseLink) {
		this.popupCloseLink = popupCloseLink;
	}


	/**
	 * @return the myAccountLink
	 */
	public WebElement getMyAccountLink() {
		return MyAccountLink;
	}


	/**
	 * @param myAccountLink the myAccountLink to set
	 */
	public void setMyAccountLink(WebElement myAccountLink) {
		MyAccountLink = myAccountLink;
	}

	/**
	 * @return the wishlistLink
	 */
	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	/**
	 * @param wishlistLink the wishlistLink to set
	 */
	public void setWishlistLink(WebElement wishlistLink) {
		this.wishlistLink = wishlistLink;
	}

	/**
	 * @return the findAStoreLink
	 */
	public WebElement getFindAStoreLink() {
		return findAStoreLink;
	}

	/**
	 * @param findAStoreLink the findAStoreLink to set
	 */
	public void setFindAStoreLink(WebElement findAStoreLink) {
		this.findAStoreLink = findAStoreLink;
	}

	/**
	 * @return the miniCartLink
	 */
	public WebElement getMiniCartLink() {
		return miniCartLink;
	}

	/**
	 * @param miniCartLink the miniCartLink to set
	 */
	public void setMiniCartLink(WebElement miniCartLink) {
		this.miniCartLink = miniCartLink;
	}

	/**
	 * @return the seachTextBox
	 */
	public WebElement getSeachTextBox() {
		return seachTextBox;
	}

	/**
	 * @param seachTextBox the seachTextBox to set
	 */
	public void setSeachTextBox(WebElement seachTextBox) {
		this.seachTextBox = seachTextBox;
	}

	/**
	 * @return the searchButton
	 */
	public WebElement getSearchButton() {
		return searchButton;
	}

	/**
	 * @param searchButton the searchButton to set
	 */
	public void setSearchButton(WebElement searchButton) {
		this.searchButton = searchButton;
	}

	

	/**
	 * @return the newsletterTextBox
	 */
	public WebElement getNewsletterTextBox() {
		return newsletterTextBox;
	}

	/**
	 * @param newsletterTextBox the newsletterTextBox to set
	 */
	public void setNewsletterTextBox(WebElement newsletterTextBox) {
		this.newsletterTextBox = newsletterTextBox;
	}

	
	/**
	 * @return the genderMale
	 */
	public WebElement getGenderMale() {
		return genderMale;
	}

	/**
	 * @param genderMale the genderMale to set
	 */
	public void setGenderMale(WebElement genderMale) {
		this.genderMale = genderMale;
	}

	/**
	 * @return the genderFemale
	 */
	public WebElement getGenderFemale() {
		return genderFemale;
	}

	/**
	 * @param genderFemale the genderFemale to set
	 */
	public void setGenderFemale(WebElement genderFemale) {
		this.genderFemale = genderFemale;
	}

	/**
	 * @return the newsletterButton
	 */
	public WebElement getNewsletterButton() {
		return newsletterButton;
	}

	/**
	 * @param newsletterButton the newsletterButton to set
	 */
	public void setNewsletterButton(WebElement newsletterButton) {
		this.newsletterButton = newsletterButton;
	}

	/**
	 * @return the newsletterMessageFailure
	 */
	public WebElement getNewsletterMessageFailure() {
		return newsletterMessageFailure;
	}

	/**
	 * @param newsletterMessageFailure the newsletterMessageFailure to set
	 */
	public void setNewsletterMessageFailure(WebElement newsletterMessageFailure) {
		this.newsletterMessageFailure = newsletterMessageFailure;
	}

	/**
	 * @return the newsletterMessageSuccess
	 */
	public WebElement getNewsletterMessageSuccess() {
		return newsletterMessageSuccess;
	}

	/**
	 * @param newsletterMessageSuccess the newsletterMessageSuccess to set
	 */
	public void setNewsletterMessageSuccess(WebElement newsletterMessageSuccess) {
		this.newsletterMessageSuccess = newsletterMessageSuccess;
	}





	 

	
	
	

	
}
