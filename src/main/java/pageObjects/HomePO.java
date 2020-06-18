package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.ReuseFunctions;

public class HomePO extends ReuseFunctions {

	public HomePO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Khoa Nguyen']")
	WebElement imageUser;
	
	@FindBy(xpath="//i[@class='icon-people-setting']")
	WebElement userAndSettingIcon;

	public boolean isHomePageDisplay() {
		waitForElementVisible(imageUser);
		return isElementDisplay(imageUser);
	}
	
	public void clickOnUserAndSettingIcon() {
		waitForElementVisible(userAndSettingIcon);
		clickToElement(userAndSettingIcon);
	}

}
