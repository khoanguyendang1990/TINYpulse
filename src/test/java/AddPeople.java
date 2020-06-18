import org.testng.annotations.Test;

import commons.BaseTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.AddPeoplePO;
import pageObjects.HomePO;
import pageObjects.SignInPO;
import pageObjects.UserAndSettingsPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterClass;

public class AddPeople extends BaseTest {
	
	WebDriver driver;
	private HomePO homePO;
	private SignInPO signInPO;
	private UserAndSettingsPO userAndSettingPO;
	private AddPeoplePO addPeoplePO;
	private PageGeneratorManager pageGeneratorManager;
	
	private String username = Constants.EMAIL_USERNAME;
	private String password = Constants.PASSWORD;
	private String email="khoa.nguyen"+randomNumber()+"@gmail.com";
	private String firstName="Khoa"+randomNumber();
	private String lastName="Nguyen";
	private String startDate ="2020-06-20";
	
  @Test
  public void TC01_AddPeople() throws InterruptedException {
	  homePO.clickOnUserAndSettingIcon();
	  userAndSettingPO = pageGeneratorManager.getUserAndSettingPage(driver);
	  userAndSettingPO.isUserAndSettingPageDisplay();
	  userAndSettingPO.clickOnAddPeopleMenu();
	  addPeoplePO= pageGeneratorManager.getAddPeoplePage(driver);
	  assertTrue(addPeoplePO.isAddPeoplePageDisplay());
	  addPeoplePO.inputFirstName(firstName);
	  addPeoplePO.inputLastName(lastName);
	  addPeoplePO.inputEmail(email);
	  addPeoplePO.selectStartDate(startDate);
	  addPeoplePO.clickOnAddPeopleButton();
	  assertTrue(addPeoplePO.isAddPeopleSuccessfullyDisplay());
	  String firstNameInTableGrid = addPeoplePO.getAttributeInTable("1","1");
	  String lastNameInTableGrid = addPeoplePO.getAttributeInTable("1","2");
	  String emailInTableGrid = addPeoplePO.getAttributeInTable("1","3");
	  assertEquals(firstNameInTableGrid, firstName);
	  assertEquals(lastNameInTableGrid, lastName);
	  assertEquals(emailInTableGrid, email);
  }
  
  @BeforeClass
  @Parameters("browserName")
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  pageGeneratorManager = new PageGeneratorManager(driver);
	  signInPO = pageGeneratorManager.getSignInPage(driver);
	  log.info("Pre-condition: Open Log in Page");
	  signInPO.openUrl(Constants.URL);
	  signInPO.loginSuccessfully(username, password);
	  homePO= pageGeneratorManager.getHomePage(driver);
	  assertTrue(homePO.isHomePageDisplay());
  }

  @AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
