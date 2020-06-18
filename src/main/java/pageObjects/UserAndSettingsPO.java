package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.PageGeneratorManager;
import commons.ReuseFunctions;

public class UserAndSettingsPO extends ReuseFunctions{

	public UserAndSettingsPO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='main-menu']//div[contains(@class,'SideBarItem') and text()='Add People']")
	WebElement addPeopleMenu;
	
	@FindBy(xpath="//div[contains(@class,'SideBarItem') and text()='People']")
	WebElement peopleButton;

	public void clickOnAddPeopleMenu() {
		waitForElementClickable(addPeopleMenu);
		clickToElementByJS(addPeopleMenu);
	}
	
	public boolean isUserAndSettingPageDisplay() {
		return isElementDisplay(peopleButton);
	}
	
}
