package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class ProductSearchPage extends MenuPage {
	

	private By searchresult=By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']");
	private By clickProduct=By.xpath("(//a[@target='_blank'])[2]");                              
	private By productName=By.id("productTitle");
	private By productprice=By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']");
	private By addToCart=By.xpath("(//input[@name='submit.add-to-cart'])[2]");
	private By checkCart=By.xpath("//span[text()=' Cart ']/preceding-sibling::input");
	private By goToCart=By.xpath("//a[contains(text(),'to Cart')]");
	private By delteProduct=By.xpath("(//input[@value='Delete'])[1]");
	private By checkProductName=By.xpath("//span[@class='a-size-base-plus a-color-base sc-product-title sc-grid-item-product-title']");
	
	private WebDriver driver;
	
	public ProductSearchPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	 public ProductSearchPage ProductDetailsPage() {
			if(driver.findElement(searchresult).isDisplayed()){
				return this;
			}else {
				return this;
			}
	}
	 
	public ProductSearchPage productResult() {
		 
		WebElement result=driver.findElement(searchresult); 
		System.out.println(result.getText());
		return this;
		 
	}
	 
	 
	public ProductSearchPage info() {
			String geturl=driver.getCurrentUrl();
			System.out.println("url is:"+geturl);
			String tittle=driver.getTitle();
			System.out.println("tittle is:"+tittle);
			return this;
	}
	 
	public ProductSearchPage clickproductLink() {
	    	info();
	    	System.out.println("before clicking on the product link no of window:  "+driver.getWindowHandles().size());
	    	driver.findElement(clickProduct).click();
	    	return this;
	    	
	}
	public ProductSearchPage switchWindow() {
    	
    	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    	info();
    	System.out.println("after clicking on the product link no of windows:  "+driver.getWindowHandles().size());
    	return this;
    	
    }
	
	public ProductSearchPage productName() {
		 
			WebElement name=driver.findElement(productName); 
			System.out.println(name.getText());
			return this;		 
    }
	
	public ProductSearchPage productPrice() {
		 
		WebElement price=driver.findElement(productprice); 
		System.out.println(price.getText());
		return this;
		 
    }
	
	public ProductSearchPage ClickaddTocart() {
		 
		driver.findElement(addToCart).click();;
		return this;
		 
   }
	
   public ProductSearchPage ClickGoCart() {	   
	  
	   WebDriverWait oWait=new WebDriverWait(driver, Duration.ofSeconds(10));
	   
	       WebElement goCart,cart;
	      
	           String title=driver.getTitle();
	           System.out.println("page title: "+title);//Amazon.in Shopping Cart
	           
	           if(title.equals("Amazon.in Shopping Cart")) {
	        	   
	        	   goCart=driver.findElement(goToCart);
		    	   oWait.until(ExpectedConditions.elementToBeClickable(goCart));
		    	   goCart.click();
	           }
	           
	           else {
	        	  //Apple iPhone 13 (128GB) - Blue : Amazon.in
		    	   cart=driver.findElement(checkCart);
				   oWait.until(ExpectedConditions.elementToBeClickable(cart));
				   cart.click();
	        	   
	           }        
	       
	   return this;
		 
   }
   
   
   public ProductSearchPage inCartProductName() {
		 
		WebElement cartProductName=driver.findElement(checkProductName); 
		System.out.println(cartProductName.getText());
		return this;
		 
  }
   
   public ProductSearchPage deleteProductInCart() {
	   
	   driver.findElement(delteProduct).click();
	   return this;
   }
   
   
 	
	

}
