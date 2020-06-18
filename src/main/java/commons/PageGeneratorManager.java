package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.AddPeoplePO;
import pageObjects.HomePO;
import pageObjects.SignInPO;
import pageObjects.UserAndSettingsPO;


public class PageGeneratorManager {

	 private WebDriver driver;
	 
	 private HomePO homePage;
	 private SignInPO signInPage;
	 private UserAndSettingsPO userAndSetingPage;
	 private AddPeoplePO addPeoplePage;
	 
	public PageGeneratorManager(WebDriver driver) {
		 this.driver = driver;
	}
	
	public HomePO getHomePage(WebDriver driver) {
		return (homePage == null) ? homePage = new HomePO(driver) : homePage;
	}
	
	public SignInPO getSignInPage(WebDriver driver) {
		return (signInPage == null) ? signInPage = new SignInPO(driver) : signInPage;
	}
	public UserAndSettingsPO getUserAndSettingPage(WebDriver driver) {
		return (userAndSetingPage == null) ? userAndSetingPage = new UserAndSettingsPO(driver) : userAndSetingPage;
	}
	public AddPeoplePO getAddPeoplePage(WebDriver driver) {
		return (addPeoplePage == null) ? addPeoplePage = new AddPeoplePO(driver) : addPeoplePage;
	}

}
