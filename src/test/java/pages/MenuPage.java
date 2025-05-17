package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import base.BaseClass;

public class MenuPage extends BaseClass {
	

    protected By logo=By.id("nav-logo-sprites");    
    protected By username=By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
    protected By signIn=By.xpath("//span[@class='nav-line-2 ']");
    protected By signbtn=By.xpath("//span[text()='Sign in']");
    protected By signOutLink=By.xpath("//a/span[text()='Sign Out']");
	private By searchProduct=By.xpath("//input[@name='field-keywords']");
	private By productCatagery=By.xpath("//select[@id='searchDropdownBox']");
	private By searchBtn=By.xpath("//input[@type='submit']");
    private WebDriver driver;
     
	
	public MenuPage(WebDriver driver) {
		this.driver=driver;
		
	}
	

	public MenuPage moveToSignbtn() {
		Actions oAct=new Actions(driver);
		oAct.moveToElement(driver.findElement(signIn)).pause(Duration.ofSeconds(1)).perform();
		return this;
		
	}
	
	public LoginPage clickSignbtn() {
		
		driver.findElement(signbtn).click();		
		return new LoginPage(driver); 
	}
	
	
	public LoginPage clickSignOut(){
		
		driver.findElement(signOutLink).click();
		return new LoginPage(driver);
	}
	
public MenuPage productSearch(String name) {
		
		driver.findElement(searchProduct).sendKeys(name);
		return this;
	}
	
    public MenuPage selectcatagery(String catagery) {
		
		Select oSelect=new Select(driver.findElement(productCatagery));
		oSelect.selectByVisibleText(catagery);
		return this;
	}
    
    public ProductSearchPage clickSearchBtn() {
    	
    	driver.findElement(searchBtn).click();
    	return new ProductSearchPage(driver);
    }

	

}
