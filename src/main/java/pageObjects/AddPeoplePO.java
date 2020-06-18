package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.PageGeneratorManager;
import commons.ReuseFunctions;

public class AddPeoplePO extends UserAndSettingsPO{

	public AddPeoplePO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@name='button']")
	WebElement signInButton;
	
	@FindBy(xpath="//div[@role='button']//span[text()='Add People']")
	WebElement addPeopleButton;
	
	@FindBy(xpath="//div[contains(text(),'Add your employees below. You will be able to review and adjust your employee list prior to launching.')]")
	WebElement bannerContent;
	
	@FindBy(xpath="//tbody[contains(@class,'invitation-table')]//input[@field='firstName']")
	WebElement firstNameTextbox;
	
	@FindBy(xpath="//tbody[contains(@class,'invitation-table')]//input[@field='lastName']")
	WebElement lastNameTextbox;
	
	@FindBy(xpath="//tbody[contains(@class,'invitation-table')]//input[@field='email']")
	WebElement emailTextbox;
	
	@FindBy(xpath="//tbody[contains(@class,'invitation-table')]//input[@field='startDate']")
	WebElement startDateTextbox;
	
	@FindBy(xpath="//div[contains(@class,'flex items-center green') and contains(text(),'Congratulations')]")
	WebElement congratulationsTitle;
	
	private String tableGrid="//tbody[@data-cucumber='user-list-onboard']//tr[%s]//td[%s]/div[contains(@class,'TruncatedText')]";
	private String startDatePicker="//div[contains(@class,'DateItem') and @data-value='%s']";

	public boolean isAddPeoplePageDisplay() {
		return isElementDisplay(bannerContent);
	}

	public void inputFirstName(String firstname) {
		waitForElementVisible(firstNameTextbox);
		sendKeyToElement(firstNameTextbox, firstname);
	}

	public void clickOnAddPeopleButton() {
		waitForElementVisible(addPeopleButton);
		clickToElement(addPeopleButton);
	}

	public void inputLastName(String lastName) {
		waitForElementVisible(lastNameTextbox);
		sendKeyToElement(lastNameTextbox, lastName);
	}

	public void inputEmail(String email) {
		waitForElementVisible(emailTextbox);
		sendKeyToElement(emailTextbox, email);
	}

	public void selectStartDate(String startDate) {
		waitForElementVisible(startDateTextbox);
		clickToElement(startDateTextbox);
		waitForElementVisible(startDatePicker, startDate);
		clickToElement(startDatePicker, startDate);
	}

	public boolean isAddPeopleSuccessfullyDisplay() {
		waitForElementVisible(congratulationsTitle);
		return isElementDisplay(congratulationsTitle);
	}

	public String getAttributeInTable(String row, String column) {
		return getAttributeFromTableGrid(tableGrid,row,column,"data-original-title");
	}

	


	
	
	

}
