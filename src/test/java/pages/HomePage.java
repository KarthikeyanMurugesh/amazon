package pages;


import org.openqa.selenium.WebDriver;





public class HomePage extends MenuPage{
	
	 private WebDriver driver;
	 
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;

	}
	
	public HomePage verifyHomePageElement() {
		if(driver.findElement(logo).isDisplayed() && 
				driver.findElement(username).isDisplayed())
		{
				System.out.println("User landed to the home page");
			    return this;
		}else {
			System.out.println("User not landed to the home page");
			return this;
		}
	}
	

}
