package testscenarios;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;


public class TC01_login extends BaseClass {
	

	@BeforeTest
	public void excelSetup() {
		excelFileName="tc01";

	}
	

	@Test(priority = 1)
	public void homeFieldValidation() {
		HomePage result = new HomePage(driver);
		  result.verifyHomePageElement();
	}
	
	
	@Test(priority = 2,dataProvider = "DataFromExcel")
	public void loginWithValidCredential(String username,String password) {
		
		LoginPage result = new LoginPage(driver);
				  result.moveToSignbtn()
				  .clickSignbtn()
				  .verifyLoginElements()
				  .enterUserName(username)
				  .clickOnContinueBtn()
				  .enterPassword(password)
				  .clickOnSignInWithvalidData()
				  .verifyHomePageElement()
				  .moveToSignbtn()
				  .clickSignOut()
				  .verifyLoginElements();
				  ;

		
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		
		LoginPage result = new LoginPage(driver);
		result.enterUserName("Skyvennila7@gmail.com")
		.clickOnContinueBtn()
		.enterPassword("12121")
		.clickOnSignInWithInvalidData()
		.validateErrorMsg();
		
	}
	
	
	
	
	
 
}
