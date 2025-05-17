package testscenarios;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;



public class TC02_ProductSearch extends BaseClass {
	
	@BeforeTest
	public void excelSetup() {
		excelFileName="tc01";
	}
	
	@Test(priority = 1,dataProvider = "DataFromExcel")
	public void loginWithmandatoryfields(String username,String password) {
		HomePage result = new HomePage(driver);
				  result.moveToSignbtn()
				  .clickSignbtn()
				  .verifyLoginElements()
				  .enterUserName(username)
				  .clickOnContinueBtn()
				  .enterPassword(password)
				  .clickOnSignInWithvalidData()
				  .verifyHomePageElement()
				  .productSearch("iphone")
				  .selectcatagery("Electronics")
				  .clickSearchBtn()
				  .productResult()
				  .clickproductLink()
				  .switchWindow()
				  .productName()
				  .productPrice()
				  .ClickaddTocart()
				  .ClickGoCart()
				  .inCartProductName()
				  .deleteProductInCart()
				  .moveToSignbtn()
				  .clickSignOut()
				  .verifyLoginElements();
				  ;
		
	}

}
