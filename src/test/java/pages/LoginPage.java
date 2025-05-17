package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage extends HomePage {
	
	private By email=By.id("ap_email_login");
	private By continueBtn=By.className("a-button-input");
	private By usrpassword=By.id("ap_password");
	private By signBtn=By.id("signInSubmit");
//	private By forgotLink=By.id("auth-fpp-link-bottom");
    private By loginErrorMsg = By.xpath("//div[@class='a-box-inner a-alert-container']");
    private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
    
    
    public LoginPage verifyLoginElements() {
		
		if(driver.findElement(email).isDisplayed() &&
				driver.findElement(continueBtn).isDisplayed()){
			return this;
		}else {
			return this;
		}
	}
    
	public LoginPage enterUserName(String userName) {
		driver.findElement(email).sendKeys(userName);
		return this;
	}
	
	public LoginPage clickOnContinueBtn() {
		driver.findElement(continueBtn).click();
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		driver.findElement(usrpassword).sendKeys(password);
		return this;
	}
	
	public HomePage clickOnSignInWithvalidData() {
		driver.findElement(signBtn).click();
		return new HomePage(driver);
	}
	
	public LoginPage clickOnSignInWithInvalidData() {
		driver.findElement(signBtn).click();
		return this;
	}
	
	public boolean validateErrorMsg() {
		WebElement errorMsg=driver.findElement(loginErrorMsg);
		if(errorMsg.isDisplayed()){
			System.out.println(errorMsg.getText());
			return true;
		}else {
			return false;
		}
	}
	  

}
