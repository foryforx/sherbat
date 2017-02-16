/**
 * 
 */
package org.karuppaiah.sherbat.pages.timberland.sg;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.karuppaiah.sherbat.utils.Constants;
import org.karuppaiah.sherbat.utils.GeneralActions;
import org.karuppaiah.sherbat.utils.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	@FindBy(xpath = "//*[@id=\"nav\"]/ul/li[4]/div/ul")
	List<WebElement> kidsCategoryElements;
	
	
	@FindBy(linkText = "New Arrivals")
	WebElement newArrivalCategory;
	
	@FindBy(linkText = "Men")
	WebElement menCategory;
	
	@FindBy(linkText = "Women")
	WebElement womenCategory;
	
	@FindBy(linkText = "Kids")
	WebElement kidsCategory;
	
	
	
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	WebDriver driver;
	String Title,Value;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
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
	
	public void captureScreenShot(){
		 // Take screenshot and store as a file format
		 File src= ((TakesScreenshot)this.getDriver()).getScreenshotAs(OutputType.FILE);
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
	
	
	public void selectProductsRandomly(List<WebElement> sectionElemts)
			throws InterruptedException{
			try{
			
			
				int randNum = ReusableActions.randomSelection(sectionElemts);
			
				ReusableActions.waitForElementToBeClickable(this.getDriver(),
						sectionElemts.get(randNum));
				
				inAction.buttonClick(this.getDriver(),sectionElemts.get(randNum),"Click the product");
				
			}catch(Exception t){
				t.printStackTrace();
			}
	}
	
	public void selectWebElement(WebElement element)
			throws InterruptedException{
			try{
			
			
				//int randNum = ReusableActions.randomSelection(sectionElemts);
			
				ReusableActions.waitForElementToBeClickable(this.getDriver(),
						element);
				
				inAction.buttonClick(this.getDriver(),element,"Click the Element");
				
			}catch(Exception t){
				t.printStackTrace();
			}
	}
	
	
	public void mainMenuSelection(String level1, String level2) throws InterruptedException  {

		int menuNum = ReusableActions.randomSelection(mainMenuElements);
		System.out.println("mainMenuElements:"+mainMenuElements);
		

		char mainMenu = 'Z';
		if (level1.equalsIgnoreCase("WOMEN")) {
			mainMenu = 'W';
		} else if (level1.equalsIgnoreCase("MEN")) {
			mainMenu = 'M';
		} else if (level1.equalsIgnoreCase("KIDS")){
			mainMenu = 'K';
		}
			
			

		WebElement subElement;
		switch (mainMenu) {
		case 'W':
			Thread.sleep(1000);
			ReusableActions.mouseHover(driver,womenCategory);
			subElement = this.getDriver().findElement(By.linkText(level2));
			ReusableActions.click(subElement);

			break;

		case 'M':
			Thread.sleep(1000);
			ReusableActions.mouseHover(driver,menCategory);
			subElement = this.getDriver().findElement(By.linkText(level2));
			ReusableActions.mouseHoverAndClick(driver,menCategory,subElement);
			this.captureScreenShot();
			
			ReusableActions.click(subElement);
			break;

		case 'K':
			Thread.sleep(1000);
			ReusableActions.mouseHover(driver,kidsCategory);
			subElement = this.getDriver().findElement(By.linkText(level2));
			ReusableActions.click(subElement);
			break;

		default:
			System.out.println("Element not found" + level2);
			break;

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

	/**
	 * @return the mainMenuElements
	 */
	public List<WebElement> getMainMenuElements() {
		return mainMenuElements;
	}

	/**
	 * @param mainMenuElements the mainMenuElements to set
	 */
	public void setMainMenuElements(List<WebElement> mainMenuElements) {
		this.mainMenuElements = mainMenuElements;
	}

	/**
	 * @return the newArrivalCategoryElements
	 */
	public List<WebElement> getNewArrivalCategoryElements() {
		return newArrivalCategoryElements;
	}

	/**
	 * @param newArrivalCategoryElements the newArrivalCategoryElements to set
	 */
	public void setNewArrivalCategoryElements(
			List<WebElement> newArrivalCategoryElements) {
		this.newArrivalCategoryElements = newArrivalCategoryElements;
	}

	/**
	 * @return the menCategoryElements
	 */
	public List<WebElement> getMenCategoryElements() {
		return menCategoryElements;
	}

	/**
	 * @param menCategoryElements the menCategoryElements to set
	 */
	public void setMenCategoryElements(List<WebElement> menCategoryElements) {
		this.menCategoryElements = menCategoryElements;
	}

	/**
	 * @return the womenCategoryElements
	 */
	public List<WebElement> getWomenCategoryElements() {
		return womenCategoryElements;
	}

	/**
	 * @param womenCategoryElements the womenCategoryElements to set
	 */
	public void setWomenCategoryElements(List<WebElement> womenCategoryElements) {
		this.womenCategoryElements = womenCategoryElements;
	}

	/**
	 * @return the kidsCategoryElements
	 */
	public List<WebElement> getKidsCategoryElements() {
		return kidsCategoryElements;
	}

	/**
	 * @param kidsCategoryElements the kidsCategoryElements to set
	 */
	public void setKidsCategoryElements(List<WebElement> kidsCategoryElements) {
		this.kidsCategoryElements = kidsCategoryElements;
	}

	/**
	 * @return the inAction
	 */
	public ReusableActions getInAction() {
		return inAction;
	}

	/**
	 * @param inAction the inAction to set
	 */
	public void setInAction(ReusableActions inAction) {
		this.inAction = inAction;
	}

	/**
	 * @return the genAction
	 */
	public GeneralActions getGenAction() {
		return genAction;
	}

	/**
	 * @param genAction the genAction to set
	 */
	public void setGenAction(GeneralActions genAction) {
		this.genAction = genAction;
	}

	/**
	 * @return the constants
	 */
	public Constants getConstants() {
		return constants;
	}

	/**
	 * @param constants the constants to set
	 */
	public void setConstants(Constants constants) {
		this.constants = constants;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return Value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		Value = value;
	}





	 

	
	
	

	
}
