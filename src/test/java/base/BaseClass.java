package base;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import utilities.DataProviderObjectFromExcel;
import utilities.PropertyFile;

public class BaseClass {
	
	
	public  WebDriver driver;
	public String fileName="environment";
	public  String browser = PropertyFile.readDataFromPropertyFile(fileName, "browser"); 	 
    public String sURL = PropertyFile.readDataFromPropertyFile(fileName, "url");
    public String excelFileName="";   
    
    
	@BeforeClass
	public void invokeBrowser() {
		switch (browser) {
		case "chrome":
			System.out.println("Invoking chrome browser");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.out.println("invoking edge browser");
			driver = new EdgeDriver();
			break;
		case "firefox":
			System.out.println("Invoking firefox browser");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invoking default chrome browser");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	

	@AfterClass	
	public  void closeBrowser() {
		driver.close();
		driver.quit();
	}
	
	
	@DataProvider(name="DataFromExcel")
	public Object[][] excelData() throws Exception {
		Object[][] values = DataProviderObjectFromExcel.getValue(excelFileName);
		return values;
	}



}
