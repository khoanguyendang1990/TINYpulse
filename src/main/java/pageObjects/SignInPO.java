package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.PageGeneratorManager;
import commons.ReuseFunctions;

public class SignInPO extends ReuseFunctions{

	public SignInPO(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="session_email")
	WebElement emailTextbox;
	
	@FindBy(id="session_password")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//button[@name='button']")
	WebElement signInButton;

	public void inputTextToEmail(String email) {
		waitForElementVisible(emailTextbox);
		sendKeyToElement(emailTextbox, email);
	}

	public void inpurtTextToPassword(String password) {
		waitForElementVisible(passwordTextbox);
		sendKeyToElement(passwordTextbox, password);
	}

	public void clickOnSignIn() {
		waitForElementVisible(signInButton);
		clickToElement(signInButton);
	}
	
	public void loginSuccessfully(String email, String password) {
		inputTextToEmail(email);
		inpurtTextToPassword(password);
		clickOnSignIn();
	}

}
